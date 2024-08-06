import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Etudiant } from './etudiant.model';

@Injectable({
  providedIn: 'root'
})
export class EtudiantService {
  private baseUrl = 'http://localhost:8080/api/etudiants';

  constructor(private http: HttpClient) { }

  creerEtudiant(etudiant: Etudiant): Observable<Etudiant> {
    return this.http.post<Etudiant>(`${this.baseUrl}`, etudiant);
  }

  mettreAJourEtudiant(id: number, infoEtudiant: Etudiant): Observable<Etudiant> {
    return this.http.put<Etudiant>(`${this.baseUrl}/${id}`, infoEtudiant);
  }

  getEtudiant(id: number): Observable<Etudiant> {
    return this.http.get<Etudiant>(`${this.baseUrl}/${id}`);
  }

  getEtudiants(): Observable<Etudiant[]> {
    return this.http.get<Etudiant[]>(`${this.baseUrl}`);
  }

  supprimerEtudiant(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}
