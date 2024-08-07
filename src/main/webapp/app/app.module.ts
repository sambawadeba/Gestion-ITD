/*import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import AppComponent from './app.component';
import { EtudiantComponent } from './etudiant/etudiant.component';

@NgModule({
  declarations: [AppComponent, EtudiantComponent],
  imports: [BrowserModule, FormsModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
*/
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module'; // Import du module de routage
import { AppComponent } from './app.component';
import { EtudiantComponent } from './etudiant/etudiant.component';
import { FormsModule } from '@angular/forms'; // Import pour ngModel

@NgModule({
  declarations: [
    AppComponent,
    EtudiantComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, // Inclusion du module de routage
    FormsModule // Inclusion pour ngModel
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

