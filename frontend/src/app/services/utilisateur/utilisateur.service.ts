import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppSettings } from 'src/app/settings/app.settings';
import { Utilisateur } from 'src/app/models/utilisateur';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {

  constructor(private http: HttpClient) { }

  login(pseudo: string, mdp: string) {
    return this.http.post<Utilisateur>(AppSettings.USER_URL + '/login/?pseudo=' + pseudo + '&mdp=' + mdp, null);
  }
}
