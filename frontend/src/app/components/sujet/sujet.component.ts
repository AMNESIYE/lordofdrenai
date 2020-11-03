import {Component, OnInit} from '@angular/core';
import {Sujet} from '../../models/sujet';
import {SujetService} from '../../services/sujet/sujet.service';
import {PostService} from '../../services/post/post.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Post} from '../../models/post';
import {Utilisateur} from '../../models/utilisateur';

@Component({
  selector: 'app-sujet',
  templateUrl: './sujet.component.html',
  styleUrls: ['./sujet.component.css'],
  providers: [SujetService]
})
export class SujetComponent implements OnInit {

  sujet: Sujet;
  postList: Post[];
  utilisateurPostList: Utilisateur[];

  constructor(private sujetService: SujetService, private postService: PostService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(routeParams => {
      this.loadUserDetail(routeParams.id);
    });
  }

  loadUserDetail(id: number) {
    this.findSujet(id);
    this.findAllPosts(id);
    this.findAllUsersForPost(id);
  }

  findAllUsersForPost(id: number) {
    this.postService.findByUtilisateurByPostsInSujets(id)
      .pipe()
      .subscribe(data => {
        console.log(data);
        this.utilisateurPostList = data;
      }, error => {
        console.log(error);
      });
  }

  findAllPosts(id: number) {
    this.postService.findBySujet(id)
      .pipe()
      .subscribe(data => {
        console.log(data);
        this.postList = data;
      }, error => {
        console.log(error);
      });
  }

  findSujet(id: number) {
    this.sujetService.findOneSujet(id)
      .pipe()
      .subscribe(data => {
        console.log(data);
        this.sujet = data;
      }, error => {
        console.log(error);
        const link = ['/accueil'];
        this.router.navigate(link);
      });
  }
}
