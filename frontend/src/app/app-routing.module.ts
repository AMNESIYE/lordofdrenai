import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ConnexionComponent} from './components/connexion/connexion.component';
import { InscriptionComponent } from './components/inscription/inscription.component';
import { AccueilComponent } from './components/accueil/accueil.component';
import { PageErreurComponent } from './components/pageErreur/pageErreur.component';
import {CategorieComponent} from './components/categorie/categorie.component';
import {SujetComponent} from './components/sujet/sujet.component';

const routes: Routes = [
  {
    path: 'connexion',
    component: ConnexionComponent
  },
  {
    path: 'inscription',
    component: InscriptionComponent
  },
  {
    path: 'accueil',
    component: AccueilComponent
  },
  {
    path: 'categorie/:id',
    component: CategorieComponent,
    runGuardsAndResolvers: 'always',
  },
  {
    path: 'sujet/:id',
    component: SujetComponent,
    runGuardsAndResolvers: 'always',
  },
  {
    path: '',
    redirectTo: 'accueil',
    pathMatch: 'full'
  },
  {
    path: '**',
    component: PageErreurComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
