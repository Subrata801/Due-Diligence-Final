import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LanguageTemplateComponent } from './language-template/language-template.component';
import { LoanSchemeComponent } from './loan-scheme/loan-scheme.component';
import { LoginComponent } from './login/login.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';

const appRoutes: Routes = [
  //{ path: 'user', component: UserRegistrationComponent, outlet: 'appcontent'},
  { path: 'login', component: LoginComponent },
  {
    path: 'home', component: HomeComponent,
    children: [
      { path: 'user', component: UserRegistrationComponent, outlet: 'appcontent' }, 
      { path: 'loan-scheme', component: LoanSchemeComponent, outlet: 'appcontent' },
      { path: 'language-template', component: LanguageTemplateComponent, outlet: 'appcontent' },
    ]
  },
  { path: '', component: LoginComponent },
  // otherwise redirect to home
  //{ path: '**', redirectTo: '' }
];

@NgModule({
  imports: //[RouterModule.forRoot(routes,{ enableTracing: true })],
    [RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    )],
  exports: [RouterModule]
})
export class AppRoutingModule { }
