import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import SharedModule from 'app/shared/shared.module';
import { Cour } from './cour.model';
import { Account } from 'app/core/auth/account.model';
import { Subject, takeUntil } from 'rxjs';
import { CoursService } from 'app/cours.service';
import { AccountService } from 'app/core/auth/account.service';

@Component({
  selector: 'jhi-cours',
  standalone: true,
  imports: [FormsModule, SharedModule, RouterModule],
  templateUrl: './cours.component.html',
  styleUrl: './cours.component.scss'
})
export class CoursComponent implements OnInit, OnDestroy {
  account: Account | null = null;
  cours: Cour[] = [];
  cour: Cour = new Cour();
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
    this.getCours();
  }
 
  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }
  getCours(): void{
    this.courService.getCours().subscribe(data => {
      this.cours = data;
    });

}
enregistrerFichier(): void{
  this.courService.enregistrerFichier(this.cour).subscribe(data => {
    this.getCours();
    this.cour = new Cour();
  });

}
modifierFichier(_cour: Cour): void{
  this.cour = { ...this.cour };
    this.editMode = true;
}
supprimerFichier(id: number): void{
  this.courService.supprimerFichier(id).subscribe(() => {
    this.getCours();
});
}
}