import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { ConnexionComponent } from './components/connexion/connexion.component';
import { AppRoutingModule } from './app-routing.module';
import { InscriptionComponent } from './components/inscription/inscription.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {AccueilComponent, PairsPipe} from './components/accueil/accueil.component';
import {PageErreurComponent} from './components/pageErreur/pageErreur.component';
import { CategorieComponent } from './components/categorie/categorie.component';
import { SujetComponent } from './components/sujet/sujet.component';


@NgModule({
  declarations: [
    AppComponent,
    ConnexionComponent,
    InscriptionComponent,
    AccueilComponent,
    PageErreurComponent,
    CategorieComponent,
    SujetComponent,
    PairsPipe
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
