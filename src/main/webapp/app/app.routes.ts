import { Routes } from '@angular/router';

import { Authority } from 'app/config/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { errorRoute } from './layouts/error/error.route';

import HomeComponent from './home/home.component';
import NavbarComponent from './layouts/navbar/navbar.component';
import LoginComponent from './login/login.component';
import { EtudiantComponent } from './etudiant/etudiant.component';
import { EEmploiDuTempsComponent } from './eEmploiDuTemps/eEmploiDuTemps.component';
import{ eNotesComponent } from'./eNotes/eNotes.component';
import { CertificationsComponent } from './certifications/certifications.component';
import { CoursComponent} from "./cours/cours.component";


const routes: Routes = [
  { path: 'certifications',
    component: CertificationsComponent,
    title: 'certifications',
   },
  { path: 'eNotes',
    component: eNotesComponent,
    title: 'ENotes',
   },

  { path: 'eEmploiDuTemps',
    component: EEmploiDuTempsComponent,
    title: 'EEploiDuTemps',
   },

  {
    path: 'etudiant',
    component: EtudiantComponent,
    title: 'Etudiant',
  },
  {
    path:'cours',
    component:CoursComponent,
    title: 'Cours'
  },
  /*{
    path: 'professeur',
    component: ProfesseurComponent,
    title: 'Professeur',
  },*/

  {
    path: '',
    component: HomeComponent,
    title: 'home.title',
  },
  {
    path: '',
    component: NavbarComponent,
    outlet: 'navbar',
  },
  {
    path: 'admin',
    data: {
      authorities: [Authority.ADMIN],
    },
    canActivate: [UserRouteAccessService],
    loadChildren: () => import('./admin/admin.routes'),
  },
  {
    path: 'account',
    loadChildren: () => import('./account/account.route'),
  },
  {
    path: 'login',
    component: LoginComponent,
    title: 'login.title',
  },
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full',
  },
  {
    path: '',
    loadChildren: () => import(`./entities/entity.routes`),
  },
  ...errorRoute,
];

export default routes;
