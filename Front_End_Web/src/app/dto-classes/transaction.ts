export class Transaction
{
    customerId:number = Number(sessionStorage.getItem("customerId"));
    fromAccount:number = Number(sessionStorage.getItem("accountNo"));
    toAccount:number;
    amount:number;
    password:string;
    methodtype:string;
}