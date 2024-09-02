import { Component, OnInit, OnDestroy } from '@angular/core';
import { EtudiantService } from './etudiant.service';
//import { Etudiant } from './etudiant';
import { Router, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import SharedModule from 'app/shared/shared.module';
import { Etudiant } from './etudiant.model';
import { Account } from 'app/core/auth/account.model';
import { AccountService } from 'app/core/auth/account.service';
import { takeUntil } from 'rxjs/operators';
import { Subject } from 'rxjs';

@Component({
  standalone: true,
  selector: 'jhi-etudiant',
  templateUrl: './etudiant.component.html',
  styleUrl: './etudiant.component.scss',
  imports: [FormsModule, SharedModule, RouterModule],
})
export class EtudiantComponent implements OnInit, OnDestroy {
  account: Account | null = null;
  etudiants: Etudiant[] = [];
  etudiant: Etudiant = new Etudiant();
  editMode = false;
  private destroy$ = new Subject<void>();
  constructor(
    private etudiantService: EtudiantService,
    private accountService: AccountService,
    private router: Router
    
  ) {}

  ngOnInit(): void {
    this.accountService
      .getAuthenticationState()
      .pipe(takeUntil(this.destroy$))
      .subscribe(account => (this.account = account));
    this.getEtudiants();
  }
  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
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