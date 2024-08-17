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
/*import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module'; // Import du module de routage
import { AppComponent } from './app.component';
import { EtudiantComponent } from './etudiant/etudiant.component';
import { FormsModule } from '@angular/forms'; // Import pour ngModel
import {LoginComponent} from './login/login.component';

@NgModule({
  declarations: [AppComponent, EtudiantComponent,
    LoginComponent
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
*/
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'; 
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module'; 
import { AppComponent } from './app.component';
import { EtudiantComponent } from './etudiant/etudiant.component';
import { LoginComponent } from './login/login.component'; 

@NgModule({
  declarations: [
    AppComponent,
    EtudiantComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    FormsModule,
    ReactiveFormsModule, 
    HttpClientModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
