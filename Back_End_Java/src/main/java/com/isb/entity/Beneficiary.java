package com.isb.entity;

import javax.persistence.*;

@Entity
@Table(name = "TB1_BENEFICIARY")

public class Beneficiary {

@Id
@SequenceGenerator(name = "seq_beneficiary", initialValue = 50001, allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_beneficiary")
@Column(name = "BENEFICIARY_ID")
private long beneficiaryId;

@Column(name = "BENEFICIARY_NAME")
private String beneficiaryName;

@Column(name = "BENEFICIARY_NICK_NAME")
private String beneficiaryNickName;

//@ManyToOne(fetch=FetchType.LAZY)
//@JoinColumn(name="account_no")
@Column(name="BENEFICIARY_ACCOUNT_NO")
private long beneficiaryAccountNo;

// @ManyToOne
// @JoinColumn(name="CUSTOMER_ID")
@Column(name = "CUSTOMER_ID")
private long customerId;



public Beneficiary() {
}

public long getBeneficiaryId() {
    return this.beneficiaryId;
}

public void setBeneficiaryId(long beneficiaryId) {
    this.beneficiaryId = beneficiaryId;
}

public String getBeneficiaryName() {
    return this.beneficiaryName;
}

public void setBeneficiaryName(String beneficiaryName) {
    this.beneficiaryName = beneficiaryName;
}

public String getBeneficiaryNickName() {
    return this.beneficiaryNickName;
}

public void setBeneficiaryNickName(String beneficiaryNickName) {
    this.beneficiaryNickName = beneficiaryNickName;
}

public long getBeneficiaryAccountNo() {
    return beneficiaryAccountNo;
}

public void setBeneficiaryAccountNo(long beneficiaryAccountNo) {
    this.beneficiaryAccountNo = beneficiaryAccountNo;
}

public long getCustomerId() {
    return customerId;
}

public void setCustomerId(long customerId) {
    this.customerId = customerId;
}

@Override
public String toString() {
    return "Beneficiary [beneficiaryId=" + beneficiaryId + ", beneficiaryAccountNo=" + beneficiaryAccountNo
            + ", beneficiaryName=" + beneficiaryName + ", beneficiaryNickName=" + beneficiaryNickName
            + ", customerId=" + customerId + "]";
}
}