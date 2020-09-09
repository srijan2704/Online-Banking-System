import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { ForgetPasswordComponent } from "./ForgetPassword";
import { SetPasswordComponent } from "./setPaasword";
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
import { AccountBalanceComponent } from './account-balance/account-balance.component';
import { componentFactoryName } from '@angular/compiler';
import { AdminVerificationComponent } from './admin-verification/admin-verification.component';
import { TransactionsComponent } from './transactions/transactions.component';
import { LogOutComponent } from './log-out/log-out.component';
import {ComplaintApprovalComponent} from './complaint-approval/complaint-approval.component';
import {ContactRequestComponent} from './contact-request/contact-request.component';
import {TransactionInvoiceComponent} from './transaction-invoice/transaction-invoice.component';

const routes: Routes = [
{
  path:'',component:HomeComponent
},
{
  path:'homeLink',component:HomeComponent
  
},
{
  path:'loginLink',component:LoginComponent
},
{
  path: 'registerLink',component:RegisterComponent
},
{
path:'forgetPasswordLink',component:ForgetPasswordComponent
},
{
  path:'setPaaswordLink',component:SetPasswordComponent
},
{
  path:'internetBankingLink',component:InternetBankingComponent
},
{
  path:'sessionTimeout',component:SessionExpiredComponent
},
{
  path:'accountLocked',component:AccountLockedComponent
},
{
  path:'adminLogin',component:AdminLoginComponent
},
{
  path:'CMS',component:ComplaintComponent
},
{
  path:'complaintStatus',component:ComplaintStatusComponent
},
{
  path:'visitorStatusLink',component:VisitorStatusComponent
},
{
  path:'logout',component:LogOutComponent
},
{
  path:'preLogin',component:PreLoginComponent
},
{
  path:'accountType',component:AccountTypeComponent
},
{
  path:'contactUs',component:ContactUsComponent
},
{
  path:'complaintStatus',component:ComplaintStatusComponent
},
{
  path:'userDashboard',component:UserDashboardComponent,
  children:[
    {
      path: 'accountSummary', component:AccountSummaryComponent
    },
    {
      path: 'accountStatement',component:AccountStatementComponent
    },
    {
      path:'userProfile',component:UserProfileComponent
    },
    {
      path:'fundTransfer',component:FundTransferComponent
    },
    {
      path:'addBeneficiary',component:AddBeneficiaryComponent
    },
    {
      path:'changePassword',component:ChangePasswordComponent
    },
    {
      path:'accountBalance',component:AccountBalanceComponent
    },
    {
      path:'transactions',component:TransactionsComponent
    },
    {
      path:'invoice',component:TransactionInvoiceComponent
    }
  ]
},
{
  path:'adminPortal',component:AdminDashBoardComponent,
  children:[
    {
      path:'adminVerification',component:AdminVerificationComponent
    },
    {
      path:'complaintApprove',component:ComplaintApprovalComponent
    },
    {
      path:'contactRequest',component:ContactRequestComponent
    }
  ]
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
