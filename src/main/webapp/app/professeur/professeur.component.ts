import { Component, OnInit } from '@angular/core';
import { Professeur } from './professeur.model';
import { ProfesseurService } from './professeur.service';

@Component({
  selector: 'jhi-professeur',
  templateUrl: './professeur.component.html',
  styleUrls: ['./professeur.component.css']
})
export class ProfesseurComponent implements OnInit {
  professeurs: Professeur[] = [];
  professeur: Professeur = new Professeur();
  appelleMethode: boolean = false;

  constructor(private professeurService: ProfesseurService) {}

  ngOnInit(): void {
    this.professeurService.getAll().subscribe(data => {
      this.professeurs = data;
    });
  }

  ajouterProfesseur(): void {
    this.professeurService.creer(this.professeur).subscribe(professeur => {
      this.professeurs.push(professeur);
      this.professeur = new Professeur();
      this.appelleMethode = false;
    });
  }

  mettreAJourProfesseur(): void {
    this.professeurService.mettreAJour(this.professeur).subscribe(updatedProfesseur => {
      const index = this.professeurs.findIndex(p => p.id === updatedProfesseur.id);
      if (index !== -1) {
        this.professeurs[index] = updatedProfesseur;
      }
      this.professeur = new Professeur();
      this.appelleMethode = false;
    });
  }

  supprimerProfesseur(id: number): void {
    this.professeurService.supprimer(id).subscribe(() => {
      this.professeurs = this.professeurs.filter(p => p.id !== id);
    });
  }

  modifierProfesseur(professeur: Professeur): void {
    this.professeur = { ...professeur };
    this.appelleMethode = true;
  }
}
