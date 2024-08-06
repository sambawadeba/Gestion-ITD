import { Component, OnInit } from '@angular/core';
import { EtudiantService } from './etudiant.service';
//import { Etudiant } from './etudiant';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import SharedModule from 'app/shared/shared.module';
import { Etudiant } from './etudiant.model';

@Component({
  standalone: true,
  selector: 'jhi-etudiant',
  templateUrl: './etudiant.component.html',
  styleUrls: ['./etudiant.component.scss'],
  imports: [FormsModule, SharedModule, RouterModule],
})
export class EtudiantComponent implements OnInit {
  etudiants: Etudiant[] = [];
  etudiant: Etudiant = new Etudiant();
  editMode = false;

  constructor(private etudiantService: EtudiantService) { }

  ngOnInit(): void {
    this.getEtudiants();
  }

  getEtudiants(): void {
    this.etudiantService.getEtudiants().subscribe(data => {
      this.etudiants = data;
    });
  }

  ajouterEtudiant(): void {
    this.etudiantService.creerEtudiant(this.etudiant).subscribe(data => {
      this.getEtudiants();
      this.etudiant = new Etudiant();
    });
  }

  mettreAJourEtudiant(): void {
    this.etudiantService.mettreAJourEtudiant(this.etudiant.id, this.etudiant).subscribe(data => {
      this.getEtudiants();
      this.etudiant = new Etudiant();
      this.editMode = false;
    });
  }

  modifierEtudiant(etudiant: Etudiant): void {
    this.etudiant = { ...etudiant };
    this.editMode = true;
  }

  supprimerEtudiant(id: number): void {
    this.etudiantService.supprimerEtudiant(id).subscribe(() => {
      this.getEtudiants();
    });
  }
}


