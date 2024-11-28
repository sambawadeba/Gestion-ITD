import { Component, OnInit } from '@angular/core';
import { eNotesService } from './eNotes.service';
import { eNotes } from './eNotes.model';
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-notes',
  standalone: true,
  templateUrl: './eNotes.component.html',
  imports: [
    NgForOf
  ],
  styleUrls: ['./eNotes.component.scss']
})
export class eNotesComponent implements OnInit {
  notes: eNotes[] = [];

  ngOnInit(): void {

  }
  modules = [
    { name: "Mathématiques", assignment1: 15, assignment2: 17, exam: 16 },
    { name: "Physique", assignment1: 14, assignment2: 16, exam: 15 },
    { name: "Informatique", assignment1: 18, assignment2: 19, exam: 17 },
    { name: "Anglais", assignment1: 13, assignment2: 15, exam: 14 },
  ];

  calculateAverage(module: any): string {
    const average = (module.assignment1 + module.assignment2 + module.exam) / 3;
    return average.toFixed(2);
  }
  /*getNotes(): void {

    this.eNotesService.getNotes(this.etudiantId).subscribe(
      data => {
        this.notes = data;
      },
      error => {
        console.error('Erreur lors de la récupération des notes', error);
      }
      }*/
}
