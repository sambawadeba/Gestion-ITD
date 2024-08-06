import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Professeur } from './professeur.model';

@Injectable({
  providedIn: 'root'
})
export class ProfesseurService {
  private apiUrl = 'http://localhost:8080/api/professeurs'; 

  constructor(private http: HttpClient) {}

  getAll(): Observable<Professeur[]> {
    return this.http.get<Professeur[]>(this.apiUrl);
  }

  creer(professeur: Professeur): Observable<Professeur> {
    return this.http.post<Professeur>(this.apiUrl, professeur);
  }

  mettreAJour(professeur: Professeur): Observable<Professeur> {
    return this.http.put<Professeur>(`${this.apiUrl}/${professeur.id}`, professeur);
  }

  supprimer(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  getById(id: number): Observable<Professeur> {
    return this.http.get<Professeur>(`${this.apiUrl}/${id}`);
  }
}
