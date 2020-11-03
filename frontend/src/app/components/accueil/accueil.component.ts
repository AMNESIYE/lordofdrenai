import {Component, OnInit, Pipe, PipeTransform} from '@angular/core';
import {UtilisateurService} from 'src/app/services/utilisateur/utilisateur.service';
import {Utilisateur} from 'src/app/models/utilisateur';
import {Router} from '@angular/router';
import {CategorieService} from '../../services/categorie/categorie.service';
import {Categorie} from '../../models/categorie';

@Pipe({name: 'pairs'})
export class PairsPipe implements PipeTransform {
  transform(value: any) {
    return value.filter((v, i) =>
      i % 2 == 0).map((v, i) =>
      [value[i * 2], value[i * 2 + 1]]);
  }
}

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['../../resources/bootstrap/css/bootstrap.min.css', '../../resources/fontawesome/css/all.min.css', './accueil.component.css']
})
export class AccueilComponent implements OnInit {

  utilisateur: Utilisateur;
  categorieList: Categorie[];
  accueilCategorie: Categorie[];

  constructor(private utilisateurService: UtilisateurService, private categorieService: CategorieService, private router: Router) {
    //this.checkUser();
  }

  ngOnInit() {
    this.findAllCategories();
    this.findAllAccueilCategorie();
  }

  findAllCategories() {
    this.categorieService.FindAll()
      .pipe()
      .subscribe(data => {
        console.log(data);
        this.categorieList = data;
      }, error => {
        console.log(error);
      });
  }

  findAllAccueilCategorie() {
    this.categorieService.findAccueil()
      .pipe()
      .subscribe(data => {
        console.log(data);
        this.accueilCategorie = data;
      }, error => {
        console.log(error);
      });
  }

  /*checkUser() {
    if (localStorage.getItem('currentUser') === undefined || localStorage.getItem('currentUser') === null) {
      console.log('Utilisateur invalide : Redirection.');
      this.router.navigate(['/connexion']);
      return;
    }
    this.utilisateur = JSON.parse(localStorage.getItem('currentUser'));
  }*/

}
