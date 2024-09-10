import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cour } from '../models/cour.model';

@Injectable({
  providedIn: 'root'
})
export class CoursService {
  private urlBase = '/api/cours';

  constructor(private http: HttpClient) {}

  enregistrerFichier(cour: Cour): Observable<Cour> {
      return this.http.post<Cour>(`${this. urlBase}`, Cour);
    }

  getCours(id: number): Observable<Cour> {
    return this.http.get<Cour>(`${this.urlBase}/${id}`);
  }
  getTousLesCours(): Observable<Cour[]> {
    return this.http.get<Cour[]>(`${this.urlBase}`);
  }
  modifierFichier(id: number, infoCours: Cour): Observable<Cour> {
    return this.http.put<Cour>(`${this.urlBase}/${id}`, infoCours);
  }
  supprimerFichier(id: number): Observable<any> {
    return this.http.delete(`${this.urlBase}/${id}`);
  }

}