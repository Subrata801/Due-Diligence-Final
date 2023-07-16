import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateHeaderComponent } from '../components/create-header/create-header.component';
import { HomeComponent } from '../components/home/home.component';
import { UserProfileComponent } from '../components/user-profile/user-profile.component';
import { ImportTemplateComponent } from '../components/import-template/import-template.component';
import { UploadTemplateComponent } from '../components/upload-template/upload-template.component';
import { ViewTemplatesComponent } from '../components/view-templates/view-templates.component';
import { LanguageTemplateComponent } from '../components/language-template/language-template.component';
import { LoanSchemeComponent } from '../components/loan-scheme/loan-scheme.component';
import { LoginComponent } from '../components/login/login.component';
import { UserLoginComponent } from '../components/user-login/user-login.component';
import { ForgotPasswordComponent } from '../components/forgot-password/forgot-password.component';
import { FirstTimeLoginComponent } from '../components/first-time-login/first-time-login.component';
import { DashboardComponent } from '../components/dashboard/dashboard.component';
import { SaasSubscriptionComponent } from '../components/saas-subscription/saas-subscription.component';
import { SearchSubscriptionsComponent } from '../components/search-subscriptions/search-subscriptions.component';
import { SearchUsersComponent } from '../components/search-users/search-users.component';
import { UserRegistrationComponent } from '../components/user-registration/user-registration.component';
import { ToastrModule } from 'ngx-toastr';
import { LoanSchemeVariantComponent } from '../components/loan-scheme-variant/loan-scheme-variant.component';
import { ClientConfigComponent } from '../components/client-config/client-config.component';
import { SearchClientComponent } from '../components/search-client/search-client.component';
import { NewClientComponent } from '../components/new-client/new-client.component';
import { v1TemplatesComponent } from '../components/v1-templates/v1-templatess.component';
import { EditClientComponent } from '../components/edit-client/edit-client.component';
import { EditTemplateComponent } from '../components/edit-template/edit-template.component';
import { DueDiligenceComponent } from '../components/due-diligence/due-diligence.component';
import { RiskScoreComponent } from '../components/risk-score/risk-score.component';
import { RiskCustomizationComponent } from '../components/risk-customization/risk-customization.component';
import { ClientMgmtDashboardComponent } from '../components/client-management-dashboard/client-management-dashboard.component';
import { createUnitComponent } from '../components/create-unit/create-unit.component';
import { searchUnitComponent } from '../components/search-unit/search-unit.component';
import { ManageEmployeesComponent } from '../components/manage-employees/manage-employees.component';
import { BranchUsersComponent } from '../components/branch-users/branch-users.component';
import { CreateBranchUsersComponent } from '../components/create-branch-users/create-branch-users.component';
import { BankServicesComponent } from '../components/bank-services/bank-services.component';
import { InitiateLoanComponent } from '../components/initiate-loan/initiate-loan.component';
import { AnyStageProcessingComponent } from '../components/any-stage-processing/any-stage-processing.component';
import { AnyStageProcessingComponentLevel2 } from '../components/any-stage-processing-level2/any-stage-processing-level2.component';
import { CloseLoanComponent } from '../components/close-loan/close-loan.component';
import { ModuleHeadersComponent } from '../components/module-headers/module-headers.component';
import { AspDueDiligenceComponent } from '../components/asp-due-diligence/asp-due-diligence.component';

import { createAuditFirmUserComponent } from '../components/create-audit-firm-user/create-audit-firm-user.component';
import { registerApplicantComponent } from '../components/register-applicant/register-applicant.component';
import { e2eUserDashboardComponent } from '../components/e2e-user-dashboard/e2e-user-dashboard.component';
import { initiateLoanApplicationComponent } from '../components/initiate-loan-application/initiate-loan-application.component';
import { e2eApplicationServicesComponent } from '../components/e2e-application-services/e2e-application-services.component';
import { initiateAuditComponent } from '../components/initiate-audit/initiate-audit.component';
import { e2eManagementDashboardComponent } from '../components/e2e-management-dashboard/e2e-management-dashboard.component';
import { cncUserDashboardComponent } from '../components/cnc-user-dashboard/cnc-user-dashboard.component';
import { cncApplicationServicesComponent } from '../components/cnc-application-services/cnc-application-services.component';
import { cncManagementDashboardComponent } from '../components/cnc-management-dashboard/cnc-management-dashboard.component';
import { substituteUserComponent } from '../components/substitute-user/substitute-user.component';
import { initiateDueDiligenceComponent } from '../components/initiate-due-diligence/initiate-due-diligence.component';
import { dueDiligencePageComponent } from '../components/due-diligence-page/due-diligence-page.component';
import { dueDiligenceNonCompliantComponent } from '../components/due-diligence-non-compliant/due-diligence-non-compliant.component';
import { dueDiligenceActionPointsComponent } from '../components/due-diligence-action-points/due-diligence-action-points.component';
import { e2eFormComponent } from '../components/e2e-form/e2e-form.component';
import { viewDueDiligenceComponent } from '../components/view-due-diligence/view-due-diligence.component';
import { e2eReportsComponent } from '../components/e2e-reports/e2e-reports.component';
import { cncReportsComponent } from '../components/cnc-reports/cnc-reports.component';
import { from } from 'rxjs';

const appRoutes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: "full" },
  {
    path: 'login', component: LoginComponent,
    children: [
      { path: '', redirectTo: 'user-login', pathMatch: "full" },
      { path: 'user-login', component: UserLoginComponent },
      { path: 'forgot-password', component: ForgotPasswordComponent }
    ]
  },
  { path: 'first-time-login/:username', component: FirstTimeLoginComponent },
  {
    path: 'home', component: HomeComponent,
    children: [
      { path: 'user-profile', component: UserProfileComponent, outlet: 'appcontent' },
      { path: 'dashboard', component: DashboardComponent, outlet: 'appcontent' },
      { path: 'search-users', component: SearchUsersComponent, outlet: 'appcontent' },
      { path: 'user/:userId', component: UserRegistrationComponent, outlet: 'appcontent' },
      { path: 'loan-scheme', component: LoanSchemeComponent, outlet: 'appcontent' },
      { path: 'loan-scheme-variants', component: LoanSchemeVariantComponent, outlet: 'appcontent' },
      { path: 'language-template', component: LanguageTemplateComponent, outlet: 'appcontent' },
      { path: 'header', component: CreateHeaderComponent, outlet: 'appcontent' },
      { path: 'saas-subscription/:subscriptionId', component: SaasSubscriptionComponent, outlet: 'appcontent' },
      { path: 'search-subscriptions', component: SearchSubscriptionsComponent, outlet: 'appcontent' },
      {
        path: 'import-template', component: ImportTemplateComponent, outlet: 'appcontent',
        children: [
          { path: 'upload-template', component: UploadTemplateComponent },
          { path: 'view-templates', component: ViewTemplatesComponent }
        ]
      },
    //  { path: 'client', component: ClientConfigComponent, outlet: 'appcontent' },
      //{ path: '', redirectTo: 'search-client', pathMatch: "full" },
      { path: 'v1-templatess', component: v1TemplatesComponent, outlet: 'appcontent' },
      { path: 'search-client', component: SearchClientComponent, outlet: 'appcontent' },
      { path: 'new-client/:clientTypeId/:clientName/:clientId/:action/:status', component: NewClientComponent, outlet: 'appcontent' },
      { path: 'v1-templates/:clientTypeId/:clientName/:clientId/:action/:status', component: v1TemplatesComponent, outlet: 'appcontent' },
      { path: 'edit-client', component: EditClientComponent, outlet: 'appcontent' },
      { path: 'edit-template/:ddId/:clientId/:clientName/:status/:clientTypeId/:moduleName/:templateStatus', component: EditTemplateComponent, outlet: 'appcontent' },
      { path: 'due-diligence/:headerKey/:clientId/:templateStatus', component: DueDiligenceComponent, outlet: 'appcontent' },
      { path: 'v1-templatess/:clientId', component: v1TemplatesComponent, outlet: 'appcontent' },
      //]
      //},
      //{ path: 'v1-templatess', component: v1TemplatesComponent, outlet: 'appcontent' },
      { path: 'risk-score', component: RiskScoreComponent, outlet: 'appcontent' },
      { path: 'risk-customization', component: RiskCustomizationComponent, outlet: 'appcontent' },
      // Client Management Routes
      { path: 'app-client-management-dashboard', component: ClientMgmtDashboardComponent, outlet: 'appcontent' },
      { path: 'create-unit/:unitType/:unitName', component: createUnitComponent, outlet: 'appcontent' },
      { path: 'search-unit', component: searchUnitComponent, outlet: 'appcontent' },
      { path: 'manage-employees', component: ManageEmployeesComponent, outlet: 'appcontent' },
      { path: 'branch-users/:clientGroupId', component: BranchUsersComponent, outlet: 'appcontent' },
      { path: 'create-branch-users/:clientGroupId', component: CreateBranchUsersComponent, outlet: 'appcontent' },
      { path: 'bank-services', component: BankServicesComponent, outlet: 'appcontent' },
      { path: 'initiate-loan', component: InitiateLoanComponent, outlet: 'appcontent' },
      { path: 'any-stage-processing', component: AnyStageProcessingComponent, outlet: 'appcontent' },
      { path: 'any-stage-processing-level2/:key1/:key3/:key4/:key5/:module', component: AnyStageProcessingComponentLevel2, outlet: 'appcontent' },
      { path: 'module-headers', component: ModuleHeadersComponent, outlet: 'appcontent' },
      { path: 'asp-due-diligence', component: AspDueDiligenceComponent, outlet: 'appcontent' },
      { path: 'close-loan', component: CloseLoanComponent, outlet: 'appcontent' },
      //
      { path: 'create-audit-firm-user/:employeeName/:userName', component: createAuditFirmUserComponent, outlet: 'appcontent' },
      { path: 'register-applicant', component: registerApplicantComponent, outlet: 'appcontent' },
      { path: 'e2e-user-dashboard', component: e2eUserDashboardComponent, outlet: 'appcontent' },
      { path: 'initiate-loan-application', component: initiateLoanApplicationComponent, outlet: 'appcontent' },
      { path: 'e2e-application-services', component: e2eApplicationServicesComponent, outlet: 'appcontent' },
      { path: 'initiate-audit', component: initiateAuditComponent, outlet: 'appcontent' },
      { path: 'e2e-management-dashboard', component: e2eManagementDashboardComponent, outlet: 'appcontent' },
      { path: 'cnc-user-dashboard', component: cncUserDashboardComponent, outlet: 'appcontent' },
      { path: 'cnc-application-services', component: cncApplicationServicesComponent, outlet: 'appcontent' },
      { path: 'cnc-management-dashboard', component: cncManagementDashboardComponent, outlet: 'appcontent' },
      { path: 'substitute-user', component: substituteUserComponent, outlet: 'appcontent' },
      { path: 'initiate-due-diligence/:e2e', component: initiateDueDiligenceComponent, outlet: 'appcontent' },
      { path: 'due-diligence-page/:headerKey', component: dueDiligencePageComponent, outlet: 'appcontent' },
      { path: 'due-diligence-non-compliant/:e2e', component: dueDiligenceNonCompliantComponent, outlet: 'appcontent' },
      { path: 'due-diligence-action-points', component: dueDiligenceActionPointsComponent, outlet: 'appcontent' },
      { path: 'view-due-diligence/:moduleName/:loanAppId', component: viewDueDiligenceComponent, outlet: 'appcontent' },
      { path: 'e2e-form', component: e2eFormComponent, outlet: 'appcontent' },
      { path: 'e2e-reports', component: e2eReportsComponent, outlet: 'appcontent' },
      { path: 'cnc-reports', component: cncReportsComponent, outlet: 'appcontent' }
    ]
  }
];

@NgModule({
  imports: //[RouterModule.forRoot(routes,{ enableTracing: true })],
    [
      RouterModule.forRoot(
        appRoutes, {onSameUrlNavigation: 'reload'}
       // , { enableTracing: true } // <-- debugging purposes only
      )],
  exports: [RouterModule]
})
export class AppRoutingModule { }
