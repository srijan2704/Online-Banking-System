export class AddBeneficiary
{
    customerId:number;
    beneficiaryName:string;
    beneficiaryNickName:string;
    beneficiaryAccountNo:string;
    constructor(customerId,beneficiaryName,beneficiaryNickName,beneficiaryAccountNo)
    {
        this.customerId = customerId;
        this.beneficiaryAccountNo = beneficiaryAccountNo;
        this.beneficiaryName = beneficiaryName;
        this.beneficiaryNickName = beneficiaryNickName;
    }
}