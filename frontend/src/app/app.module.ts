import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './routing/app-routing.module';
import { AppComponent } from './app.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module';
import { SearchUsersComponent } from './components/search-users/search-users.component';
import { UserRegistrationComponent } from './components/user-registration/user-registration.component';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatButtonModule} from '@angular/material/button';
import { MatFormFieldModule} from '@angular/material/form-field';
import { MatNativeDateModule} from '@angular/material/core';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatTabsModule } from '@angular/material/tabs';
import { MatTableModule } from '@angular/material/table';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { UserLoginComponent } from './components/user-login/user-login.component';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { FirstTimeLoginComponent } from './components/first-time-login/first-time-login.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { LoanSchemeComponent } from './components/loan-scheme/loan-scheme.component';
import { LanguageTemplateComponent } from './components/language-template/language-template.component';
import { HttpClientModule } from '@angular/common/http';
import { AuthInterceptorProviders } from './services/auth-service/auth.interceptor';
import { CreateHeaderComponent } from './components/create-header/create-header.component';
import { SaasSubscriptionComponent } from './components/saas-subscription/saas-subscription.component';
import { SearchSubscriptionsComponent } from './components/search-subscriptions/search-subscriptions.component';
import { ImportTemplateComponent } from './components/import-template/import-template.component';
import { UploadTemplateComponent } from './components/upload-template/upload-template.component';
import { ViewTemplatesComponent } from './components/view-templates/view-templates.component';
import { ConfirmationDialogComponent } from './components/confirmation-dialog/confirmation-dialog.component';
import { createNewVersionDialogComponent } from './components/create-new-version-dialog/create-new-version-dialog.component';
import { CommonModule } from '@angular/common';
import { ToastrModule } from 'ngx-toastr';
import { LoanSchemeVariantComponent } from './components/loan-scheme-variant/loan-scheme-variant.component';
import { ClientConfigComponent } from './components/client-config/client-config.component';
import { SearchClientComponent } from './components/search-client/search-client.component';
import { NewClientComponent } from './components/new-client/new-client.component';
import { v1TemplatesComponent } from './components/v1-templates/v1-templatess.component';
import { EditClientComponent } from './components/edit-client/edit-client.component';
import { EditTemplateComponent } from './components/edit-template/edit-template.component';
import { DueDiligenceComponent } from './components/due-diligence/due-diligence.component';
import { RiskScoreComponent } from './components/risk-score/risk-score.component';
import { RiskCustomizationComponent } from './components/risk-customization/risk-customization.component';
import { ClientMgmtDashboardComponent } from './components/client-management-dashboard/client-management-dashboard.component';
import { createUnitComponent } from './components/create-unit/create-unit.component';
import { searchUnitComponent } from './components/search-unit/search-unit.component';
import { ManageEmployeesComponent } from './components/manage-employees/manage-employees.component';
import { BranchUsersComponent } from './components/branch-users/branch-users.component';
import { CreateBranchUsersComponent } from './components/create-branch-users/create-branch-users.component';
import { BankServicesComponent } from './components/bank-services/bank-services.component';
import { InitiateLoanComponent } from './components/initiate-loan/initiate-loan.component';
import { AnyStageProcessingComponent } from './components/any-stage-processing/any-stage-processing.component';
import { AnyStageProcessingComponentLevel2 } from './components/any-stage-processing-level2/any-stage-processing-level2.component';
import { CloseLoanComponent } from './components/close-loan/close-loan.component';
import { ModuleHeadersComponent } from './components/module-headers/module-headers.component';
import { AspDueDiligenceComponent } from './components/asp-due-diligence/asp-due-diligence.component';
import { preventCopyPaste } from './components/preventCopyPaste.directive';

import { createAuditFirmUserComponent } from './components/create-audit-firm-user/create-audit-firm-user.component';
import { registerApplicantComponent } from './components/register-applicant/register-applicant.component';
import { e2eUserDashboardComponent } from './components/e2e-user-dashboard/e2e-user-dashboard.component';
import { initiateLoanApplicationComponent } from './components/initiate-loan-application/initiate-loan-application.component';
import { e2eApplicationServicesComponent } from './components/e2e-application-services/e2e-application-services.component';
import { initiateAuditComponent } from './components/initiate-audit/initiate-audit.component';
import { e2eManagementDashboardComponent } from './components/e2e-management-dashboard/e2e-management-dashboard.component';
import { cncUserDashboardComponent } from './components/cnc-user-dashboard/cnc-user-dashboard.component';
import { cncApplicationServicesComponent } from './components/cnc-application-services/cnc-application-services.component';
import { cncManagementDashboardComponent } from './components/cnc-management-dashboard/cnc-management-dashboard.component';
import { substituteUserComponent } from './components/substitute-user/substitute-user.component';
import { initiateDueDiligenceComponent } from './components/initiate-due-diligence/initiate-due-diligence.component';
import { dueDiligencePageComponent } from './components/due-diligence-page/due-diligence-page.component';
import { dueDiligenceNonCompliantComponent } from './components/due-diligence-non-compliant/due-diligence-non-compliant.component';
import { dueDiligenceActionPointsComponent } from './components/due-diligence-action-points/due-diligence-action-points.component';
import { viewDueDiligenceComponent } from './components/view-due-diligence/view-due-diligence.component';
import { e2eFormComponent } from './components/e2e-form/e2e-form.component';
import { e2eReportsComponent } from './components/e2e-reports/e2e-reports.component';
import { cncReportsComponent } from './components/cnc-reports/cnc-reports.component';

@NgModule({
  declarations: [
    AppComponent,
    SearchUsersComponent,
    UserRegistrationComponent,
    HomeComponent,
    UserProfileComponent,
    LoginComponent,
    UserLoginComponent,
    ForgotPasswordComponent,
    FirstTimeLoginComponent,
    DashboardComponent,
    LoanSchemeComponent,
    LanguageTemplateComponent,
    CreateHeaderComponent,
    SearchSubscriptionsComponent,
    SaasSubscriptionComponent,
    ImportTemplateComponent,
    UploadTemplateComponent,
    ViewTemplatesComponent,
    ConfirmationDialogComponent,
    createNewVersionDialogComponent,
    LoanSchemeVariantComponent,
    ClientConfigComponent,
    SearchClientComponent,
    NewClientComponent,
    v1TemplatesComponent,
    EditClientComponent,
    EditTemplateComponent,
    DueDiligenceComponent,
    RiskScoreComponent,
    RiskCustomizationComponent,
    ClientMgmtDashboardComponent,
    createUnitComponent,
    searchUnitComponent,
    ManageEmployeesComponent,
    BranchUsersComponent,
    CreateBranchUsersComponent,
    BankServicesComponent,
    InitiateLoanComponent,
    AnyStageProcessingComponent,
    AnyStageProcessingComponentLevel2,
    CloseLoanComponent,
    ModuleHeadersComponent,
    AspDueDiligenceComponent,
    preventCopyPaste,
    createAuditFirmUserComponent,
    registerApplicantComponent,
    e2eUserDashboardComponent,
    initiateLoanApplicationComponent,
    e2eApplicationServicesComponent,
    initiateAuditComponent,
    e2eManagementDashboardComponent,
    cncUserDashboardComponent,
    cncApplicationServicesComponent,
    cncManagementDashboardComponent,
    substituteUserComponent,
    initiateDueDiligenceComponent,
    dueDiligencePageComponent,
    dueDiligenceNonCompliantComponent,
    dueDiligenceActionPointsComponent,
    viewDueDiligenceComponent,
    e2eFormComponent,
    e2eReportsComponent,
    cncReportsComponent
  ],
  imports: [ 
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    ReactiveFormsModule,
    HttpClientModule,
    CommonModule,
    MatDatepickerModule,
    MatButtonModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatExpansionModule,
    MatTabsModule,
    MatAutocompleteModule,
    MatSlideToggleModule,
    MatCheckboxModule,
    ToastrModule.forRoot(),
  ],
  providers: [AuthInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
