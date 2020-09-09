import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from "@angular/common/http";
import {FormsModule} from  "@angular/forms";
import { ForgetPasswordComponent } from "./ForgetPassword";
import { SetPasswordComponent} from "./setPaasword";
import { InternetBankingComponent } from "./InternetBanking";
import { SessionExpiredComponent } from './session-expired/session-expired.component';
import { AccountStatementComponent } from './account-statement/account-statement.component';
import { AccountLockedComponent } from './account-locked/account-locked.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { AdminDashBoardComponent } from './admin-dash-board/admin-dash-board.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { ComplaintComponent } from './complaint/complaint.component';
import { ComplaintStatusComponent } from './complaint-status/complaint-status.component';
import { FundTransferComponent } from './fund-transfer/fund-transfer.component';
import { VisitorStatusComponent } from './visitor-status/visitor-status.component';
import { PreLoginComponent } from './pre-login/pre-login.component';
import { AccountSummaryComponent } from './account-summary/account-summary.component';
import { AccountTypeComponent } from './account-type/account-type.component';
import { AddBeneficiaryComponent } from './add-beneficiary/add-beneficiary.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { HeaderNavComponent } from './header-nav/header-nav.component';
import { UserNavBarComponent } from './user-nav-bar/user-nav-bar.component';
import { HeaderAppComponent } from './header-app/header-app.component';
import { AccountBalanceComponent } from './account-balance/account-balance.component';
import { AdminVerificationComponent } from './admin-verification/admin-verification.component';
import { TransactionsComponent } from './transactions/transactions.component';
import { LogOutComponent } from './log-out/log-out.component';
import { ComplaintApprovalComponent } from './complaint-approval/complaint-approval.component';
import { ContactRequestComponent } from './contact-request/contact-request.component';
import { TransactionInvoiceComponent } from './transaction-invoice/transaction-invoice.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ForgetPasswordComponent,
    SetPasswordComponent,
    InternetBankingComponent,
    SessionExpiredComponent,
    AccountStatementComponent,
    AccountLockedComponent,
    UserDashboardComponent,
    AdminDashBoardComponent,
    AdminLoginComponent,
    ChangePasswordComponent,
    ComplaintComponent,
    ComplaintStatusComponent,
    FundTransferComponent,
    VisitorStatusComponent,
    PreLoginComponent,
    AccountSummaryComponent,
    AccountTypeComponent,
    AddBeneficiaryComponent,
    UserProfileComponent,
    ContactUsComponent,
    HeaderNavComponent,
    UserNavBarComponent,
    HeaderAppComponent,
    AccountBalanceComponent,
    AdminVerificationComponent,
    TransactionsComponent,
    LogOutComponent,
    ComplaintApprovalComponent,
    ContactRequestComponent,
    TransactionInvoiceComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
