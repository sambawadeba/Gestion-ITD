import { Component, OnInit } from '@angular/core';
import { ProfesseurService } from './professeur.service';
import { Professeur } from './professeur.model';

@Component({
  selector: 'app-professeur',
  templateUrl: './professeur.component.html',
  styleUrls: ['./professeur.component.css'],
})
export class ProfesseurComponent implements OnInit {
  professeurs: Professeur[] = [];
  professeur: Professeur = new Professeur();
  selectedId: number | null = null;

  constructor(private professeurService: ProfesseurService) {}

  ngOnInit(): void {
    this.getAllProfesseurs();
  }

  getAllProfesseurs(): void {
    this.professeurService.getAllProfesseurs().subscribe(data => {
      this.professeurs = data;
    });
  }

  getProfesseur(id: number): void {
    this.professeurService.getProfesseurById(id).subscribe(data => {
      this.professeur = data;
    });
  }

  creerProfesseur(): void {
    this.professeurService.creerProfesseur(this.professeur).subscribe(() => {
      this.getAllProfesseurs();
      this.professeur = new Professeur();
    });
  }

  ajouteProfesseur(): void {
    if (this.selectedId !== null) {
      this.professeurService.ajouteProfesseur(this.selectedId, this.professeur).subscribe(() => {
        this.getAllProfesseurs();
        this.professeur = new Professeur();
      });
    }
  }

  supprimeProfesseur(id: number): void {
    this.professeurService.supprimeProfesseur(id).subscribe(() => {
      this.getAllProfesseurs();
    });
  }

  selectProfesseur(id: number): void {
    this.selectedId = id;
    this.getProfesseur(id);
  }
}
