import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { eNotes } from './eNotes.model';

@Injectable({
  providedIn: 'root'
})
export class eNotesService {
  private apiUrl = 'http://localhost:8080/api/etudiants'; 

  constructor(private http: HttpClient) { }

  
  getNotes(etudiantId: number): Observable<eNotes[]> {
    return this.http.get<eNotes[]>(`${this.apiUrl}/${etudiantId}/notes`);
  }
 eNotes: eNotes[] = [
    
        {
          "id": 1,
          "module": "Mathématiques",
          "note": 15.5
        },
        {
          "id": 2,
          "module": "Physique",
          "note": 14.0
        },
        {
          "id": 3,
          "module": "Informatique",
          "note": 18.0
        },
        {
          "id": 4,
          "module": "Chimie",
          "note": 12.5
        },
        {
          "id": 5,
          "module": "Littérature",
          "note": 16.0
        }
]

}