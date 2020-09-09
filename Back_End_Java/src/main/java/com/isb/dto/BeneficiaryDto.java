package com.isb.dto;

public class BeneficiaryDto {

private String beneficiaryNickName;
private String beneficiaryName;
private long beneficiaryAccountNo;

public String getBeneficiaryNickName() {
    return beneficiaryNickName;
}
public void setBeneficiaryNickName(String beneficiaryNickName) {
    this.beneficiaryNickName = beneficiaryNickName;
}
public String getBeneficiaryName() {
    return beneficiaryName;
}
public void setBeneficiaryName(String beneficiaryName) {
    this.beneficiaryName = beneficiaryName;
}
public long getBeneficiaryAccountNo() {
    return beneficiaryAccountNo;
}
public void setBeneficiaryAccountNo(long beneficiaryAccountNo) {
    this.beneficiaryAccountNo = beneficiaryAccountNo;
}
}