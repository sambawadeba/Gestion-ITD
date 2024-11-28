import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import SharedModule from 'app/shared/shared.module';
import { Cours } from './cours.model';
import { Account } from 'app/core/auth/account.model';
import { Subject, takeUntil } from 'rxjs';
import { CoursService } from 'app/cours/cours.service';
import { AccountService } from 'app/core/auth/account.service';
import _default from "lighthouse/core/audits/oopif-iframe-test-audit";
import id = _default.meta.id;

@Component({
  selector: 'jhi-cours',
  standalone: true,
  imports: [FormsModule, SharedModule, RouterModule],
  templateUrl: './cours.component.html',
  styleUrl: './cours.component.scss'
})
export class CoursComponent implements OnInit, OnDestroy {
  account: Account | null = null;
  cours: any;
  //cours: Cours = new Cours();
  editMode = false;
  private destroy$ = new Subject<void>();
  constructor(
    private courService: CoursService,
    private accountService: AccountService,
    private router: Router

  ){}
  ngOnInit(): void {
    this.accountService
      .getAuthenticationState()
      .pipe(takeUntil(this.destroy$))
      .subscribe((account: Account | null) => (this.account = account));
    // @ts-ignore
    this.getCours();
  }

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }

  activeTab: 'documents' | 'notes' = 'documents';
  subjects: string[] = ['Développement Web', 'Méthode Agile ', 'Réseau 5G & IOT', 'Anglais', 'Base de Données', 'Marketing Digital'];
  noteTitle: string = '';
  noteContent: string = '';

  setActiveTab(tab: 'documents' | 'notes') {
    this.activeTab = tab;
  }

  saveNote() {
    console.log('Note sauvegardée:', { title: this.noteTitle, content: this.noteContent });
    // Ici, vous pouvez ajouter la logique pour sauvegarder la note
    this.noteTitle = '';
    this.noteContent = '';
  }
  /*getCours(id: number): void{
    this.courService.getCours(id).subscribe(data => {
      this.cours = data;
    });

}
enregistrerFichier(): void{
  this.courService.enregistrerFichier(this.cours).subscribe(data => {
    // @ts-ignore
    this.getCours();
    this.cours = new Cours();
  });

}
modifierFichier(_cours: Cours): void{
  this.cours = { ...this.cours };
    this.editMode = true;
}
supprimerFichier(id: number): void{
  this.courService.supprimerFichier(id).subscribe(() => {
    this.getCours(id);
});
}*/
}
