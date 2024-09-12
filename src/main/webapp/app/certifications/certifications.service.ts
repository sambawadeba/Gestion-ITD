import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Certifications} from './certifications.model';

@Injectable({
  providedIn: 'root'
})
export class CertificationsService {

  private apiUrl = '/api/certifications';

  constructor(private http: HttpClient) { }

  getValidatedCertifications(studentId: number): Observable<Certifications[]> {
    return this.http.get<Certifications[]>(`${this.apiUrl}/${studentId}`);
  }
}