import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AppSettings} from '../../settings/app.settings';
import {Sujet} from '../../models/sujet';
import {Utilisateur} from '../../models/utilisateur';

@Injectable({
  providedIn: 'root'
})
export class SujetService {

  constructor(private http: HttpClient) { }

  findAllSujets() {
    return this.http.get<Sujet[]>(AppSettings.SUJET_URL + '/all');
  }

  findSujetsByCategorie(idCategorie: number) {
    return this.http.get<Sujet[]>(AppSettings.SUJET_URL + '/all/' + idCategorie);
  }

  findOneSujet(idSujet: number) {
    return this.http.get<Sujet>(AppSettings.SUJET_URL + '/' + idSujet);
  }
}
