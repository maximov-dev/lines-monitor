import { Routes } from '@angular/router';
import { AppLayoutComponent } from './app-layout/containers/app-layout.component';

export const routes: Routes = [
  //   {
  //     path: '',
  //     redirectTo: '/',
  //     pathMatch: 'full',
  //   },
  {
    path: '',
    component: AppLayoutComponent,
    children: [],
  },
];
