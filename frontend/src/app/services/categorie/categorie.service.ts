import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppSettings } from 'src/app/settings/app.settings';
import {Categorie} from '../../models/categorie';

@Injectable({
  providedIn: 'root'
})
export class CategorieService {

  constructor(private http: HttpClient) {}

  FindAll() {
    return this.http.get<Categorie[]>(AppSettings.CAT_URL + '/all');
  }

  FindById(idCategorie: number) {
    return this.http.get<Categorie>(AppSettings.CAT_URL + '/' + idCategorie);
  }

  findListByAssociation(association: number) {
    return this.http.get<Categorie[]>(AppSettings.CAT_URL + '/sub/' + association);
  }

  findAccueil() {
    return this.http.get<Categorie[]>(AppSettings.CAT_URL + '/accueil');
  }
}
