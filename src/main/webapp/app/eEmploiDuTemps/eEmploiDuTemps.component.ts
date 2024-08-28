import { Component, OnDestroy, OnInit} from '@angular/core';
import { EEmploiDuTempsService } from './eEmploiDuTemps.service';
import { IEmploi } from './eEmploiDuTemps.model';
import { Router} from '@angular/router';
import { AccountService } from 'app/core/auth/account.service';
export interface schedules {
  libelle: string;
  Prof: string;
  Horaires: number;
  jour: string;
  Heures: number;
  Termine: boolean;
}

@Component({
  selector: 'jhi-eEmploiDuTemps',
  templateUrl: './eEmploiDuTemps.component.html',
  styleUrls: ['./eEmploiDuTemps.component.scss'] 
})
export class EEmploiDuTempsComponent implements OnInit, OnDestroy {
  schedules: IEmploi[] = [];
    destroy$: any;
 

  constructor(
    private eEmploiDuTempsService: EEmploiDuTempsService,
    private accountService : AccountService,
    private router : Router,
) {}
ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }

  ngOnInit(): void {
    const etudiantId = 1050; 
    
    this.eEmploiDuTempsService.getEtudiantEmploi(etudiantId).subscribe((data: IEmploi[]) => {
      this.schedules = data;
    });
    
  }
}
