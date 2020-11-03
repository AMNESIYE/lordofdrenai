import { Component, OnInit } from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import { UtilisateurService } from 'src/app/services/utilisateur/utilisateur.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['../../resources/bootstrap/css/bootstrap.min.css', './connexion.component.css']
})
export class ConnexionComponent implements OnInit {

  errorMessage: string;
  loginForm: FormGroup;

  constructor(private userService: UtilisateurService, private formBuilder: FormBuilder, private router: Router) {
    this.loginForm = formBuilder.group({
      pseudo: ['', Validators.required],
      mdp: ['', Validators.required]
    });
   }

  ngOnInit() {

  }

  loginUser() {
    this.errorMessage = '';
    if (this.loginForm.invalid) {
      this.errorMessage = `Nom d'utilisateur ou mot de passe incorrect.`;
      return;
    }
    this.userService.login(this.pseudo.value, this.mdp.value)
      .pipe()
      .subscribe(data => {
        localStorage.setItem('currentUser', JSON.stringify(data));
        this.router.navigate(['/accueil']);
      }, error => {
        if (error.status === 404) {
          this.errorMessage = `Aucun utilisateur de trouvé avec cette combinaison.`;
        }
        if (error.status === 400) {
          this.errorMessage = `Nom d'utilisateur ou mot de passe incorrect.`;
        }
      });
  }

  get pseudo() {
    return this.loginForm.get('pseudo');
  }

  get mdp() {
    return this.loginForm.get('mdp');
  }

}
