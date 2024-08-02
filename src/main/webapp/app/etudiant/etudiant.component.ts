/*import { Component, OnInit } from '@angular/core';
import { EtudiantService } from './etudiant.service';
import { Etudiant } from './etudiant.model';

@Component({
  selector: 'app-etudiant',
  templateUrl: './etudiant.component.html'
 // styleUrls: ['./etudiant.component.css']
})
export class EtudiantComponent implements OnInit {

  etudiants: Etudiant[] = [];
  etudiant: Etudiant = new Etudiant();
  selectedId: number | null = null;

  constructor(private etudiantService: EtudiantService) { }

  ngOnInit(): void {
    this.getAllEtudiants();
  }

  getAllEtudiants(): void {
    this.etudiantService.getAllEtudiants().subscribe(data => {
      this.etudiants = data;
    });
  }

  getEtudiant(id: number): void {
    this.etudiantService.getEtudiantById(id).subscribe(data => {
      this.etudiant = data;
    });
  }

  createEtudiant(): void {
    this.etudiantService.createEtudiant(this.etudiant).subscribe(() => {
      this.getAllEtudiants();
      this.etudiant = new Etudiant();
    });
  }

  updateEtudiant(): void {
    if (this.selectedId !== null) {
      this.etudiantService.updateEtudiant(this.selectedId, this.etudiant).subscribe(() => {
        this.getAllEtudiants();
        this.etudiant = new Etudiant();
      });
    }
  }

  deleteEtudiant(id: number): void {
    this.etudiantService.deleteEtudiant(id).subscribe(() => {
      this.getAllEtudiants();
    });
  }

  selectEtudiant(id: number): void {
    this.selectedId = id;
    this.getEtudiant(id);
  }
}*/
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
  newEtudiant: Etudiant = { id: 0, nom: '', prenom: '', adresse: '', email: '', telephone: '' };
  etudiantActuel: Etudiant | null = null;

  constructor(private etudiantService: EtudiantService) {}

  ngOnInit(): void {
    this.getEtudiants();
  }

  getEtudiants(): void {
    this.etudiantService.getEtudiants().subscribe(etudiants => (this.etudiants = etudiants));
  }

  creerEtudiant(): void {
    this.etudiantService.creerEtudiant(this.newEtudiant).subscribe(etudiant => {
      this.etudiants.push(etudiant);
      this.newEtudiant = { id: 0, nom: '', prenom: '', adresse: '', email: '', telephone: '' };
    });
  }

  ajourEtudiant(): void {
    if (this.etudiantActuel) {
      this.etudiantService.ajourEtudiant(this.etudiantActuel.id, this.etudiantActuel).subscribe(ajourEtudiant => {
        const index = this.etudiants.findIndex(e => e.id === ajourEtudiant.id);
        if (index !== -1) {
          this.etudiants[index] = ajourEtudiant;
        }
        this.etudiantActuel = null;
      });
    }
  }

  editEtudiant(etudiant: Etudiant): void {
    this.etudiantActuel = { ...etudiant };
  }

  supprimeEtudiant(id: number): void {
    this.etudiantService.supprimeEtudiant(id).subscribe(() => {
      this.etudiants = this.etudiants.filter(etudiant => etudiant.id !== id);
    });
  }
}
