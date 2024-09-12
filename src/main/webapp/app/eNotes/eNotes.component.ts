import { Component, OnInit } from '@angular/core';
import { eNotesService } from './eNotes.service';
import { eNotes } from './eNotes.model';

@Component({
  selector: 'app-notes',
  templateUrl: './eNotes.component.html',
  styleUrls: ['./eNotes.component.scss']
})
export class eNotesComponent implements OnInit {
  notes: eNotes[] = [];
  etudiantId: number;

  constructor(private eNotesService: eNotesService) {
    this.etudiantId =  0;
  }

  ngOnInit(): void {
    this.eNotesService.getNotes(this.etudiantId).subscribe(data => {
      this.notes = data;
    });
  }
  /*getNotes(): void {
    
    this.eNotesService.getNotes(this.etudiantId).subscribe(
      data => {
        this.notes = data;
      },
      error => {
        console.error('Erreur lors de la récupération des notes', error);
      }
    );
  }*/
}