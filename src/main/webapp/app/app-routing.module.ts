import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EtudiantComponent } from './etudiant/etudiant.component';

const routes: Routes = [
  { path: 'etudiants', component: EtudiantComponent },
  // autres routes
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
