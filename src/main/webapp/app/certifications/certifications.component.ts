import { Component, OnInit } from '@angular/core';
import { CertificationsService } from './certifications.service';
import { Certifications } from './certifications.model';

@Component({
  selector: 'app-certifications',
  templateUrl: './certifications.component.html',
  styleUrls: ['./certifications.component.scss']
})
export class CertificationsComponent implements OnInit {

  certifications: Certifications[] = [];
  studentId: number = 1; 

  constructor(private certificationsService: CertificationsService) { }

  ngOnInit(): void {
    this.certificationsService.getValidatedCertifications(this.studentId).subscribe(data => {
      this.certifications = data;
    });
  }
}