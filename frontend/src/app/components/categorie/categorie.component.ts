import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Categorie} from '../../models/categorie';
import {SujetService} from '../../services/sujet/sujet.service';
import {CategorieService} from '../../services/categorie/categorie.service';
import {Sujet} from '../../models/sujet';

@Component({
  selector: 'app-categorie',
  templateUrl: './categorie.component.html',
  styleUrls: ['./categorie.component.css'],
  providers: [CategorieService]
})
export class CategorieComponent implements OnInit {

  subCategorieList: Categorie[];
  sujetList: Sujet[];
  categorie: Categorie;

  constructor(private categorieService: CategorieService, private sujetService: SujetService,
              private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit(): void {
    /*this.route.queryParams.subscribe(queryParams => {
      // do something with the query params
    });*/
    this.route.params.subscribe(routeParams => {
      this.loadUserDetail(routeParams.id);
    });
  }

  loadUserDetail(id: number) {
    this.findOne(id);
    this.findAssociation(id);
    this.findAllSujets(id);
  }

  findAllSujets(id: number) {
    this.sujetService.findSujetsByCategorie(id)
      .pipe()
      .subscribe(data => {
        console.log(data);
        this.sujetList = data;
      }, error => {
        console.log(error);
      });
  }

  findAssociation(id: number) {
    this.categorieService.findListByAssociation(id)
      .pipe()
      .subscribe(data => {
        console.log(data);
        this.subCategorieList = data;
      }, error => {
        console.log(error);
      });
  }

  findOne(id: number) {
    this.categorieService.FindById(id)
      .pipe()
      .subscribe(data => {
        console.log(data);
        this.categorie = data;
      }, error => {
        console.log(error);
        const link = ['/accueil'];
        this.router.navigate(link);
      });
  }
}
