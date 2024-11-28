import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Cours} from "./cours.model";


@Injectable({
  providedIn: 'root'
})
export class CoursService {
  private urlBase = '/api/cours';

  constructor(private http: HttpClient) {}

  enregistrerFichier(cour: Cours): Observable<Cours> {
      return this.http.post<Cours>(`${this. urlBase}`, Cours);
    }

  getCours(id: number): Observable<Cours> {
    return this.http.get<Cours>(`${this.urlBase}/${id}`);
  }
  getTousLesCours(): Observable<Cours[]> {
    return this.http.get<Cours[]>(`${this.urlBase}`);
  }
  modifierFichier(id: number, infoCours: Cours): Observable<Cours> {
    return this.http.put<Cours>(`${this.urlBase}/${id}`, infoCours);
  }
  supprimerFichier(id: number): Observable<any> {
    return this.http.delete(`${this.urlBase}/${id}`);
  }

}
