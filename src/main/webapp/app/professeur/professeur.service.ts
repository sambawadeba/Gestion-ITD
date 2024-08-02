import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Professeur } from './professeur.model';

@Injectable({
  providedIn: 'root',
})
export class ProfesseurService {
  private apiUrl = 'http://localhost:8080/api/professeurs';

  constructor(private http: HttpClient) {}

  getAllProfesseurs(): Observable<Professeur[]> {
    return this.http.get<Professeur[]>(this.apiUrl);
  }

  getProfesseurById(id: number): Observable<Professeur> {
    return this.http.get<Professeur>(`${this.apiUrl}/${id}`);
  }

  creerProfesseur(professeur: Professeur): Observable<Professeur> {
    return this.http.post<Professeur>(this.apiUrl, professeur);
  }

  ajouteProfesseur(id: number, professeur: Professeur): Observable<Professeur> {
    return this.http.put<Professeur>(`${this.apiUrl}/${id}`, professeur);
  }

  supprimeProfesseur(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
