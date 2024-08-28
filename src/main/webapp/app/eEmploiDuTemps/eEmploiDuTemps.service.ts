import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { IEmploi } from './eEmploiDuTemps.model';

@Injectable({ providedIn: 'root' })
export class EEmploiDuTempsService{
    url : string;
    httpClient: any;
  constructor(
    private http: HttpClient
){
    this.url = 'http://localhost:8080/api/emploi/';
  }
  getEtudiantEmploi(etudiantId: number): Observable<IEmploi[]>{
    return this.httpClient.get(this.url + etudiantId);
}
}


