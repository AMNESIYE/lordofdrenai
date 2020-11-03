import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AppSettings} from '../../settings/app.settings';
import {Post} from '../../models/post';
import {Utilisateur} from '../../models/utilisateur';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient) { }

  findAll() {
    return this.http.get<Post[]>(AppSettings.POST_URL + '/all');
  }

  findBySujet(idSujet: number) {
    return this.http.get<Post[]>(AppSettings.POST_URL + '/' + idSujet);
  }

  findByUtilisateurByPostsInSujets(idSujet: number) {
    return this.http.get<Utilisateur[]>(AppSettings.POST_URL + '/checkUsers/' + idSujet);
  }
}
