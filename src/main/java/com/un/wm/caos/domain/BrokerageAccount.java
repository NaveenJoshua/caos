package com.un.wm.caos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
/*
* Testing Reset - Soft
*/
@Entity
public class BrokerageAccount implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="account_id")
    private int accountId;

    @Column(name="gsba_account_number")
    private String accountNumber;

    @Column(name="account_name")
    private String accountName;

    protected BrokerageAccount(){}

    @Override
    public boolean        equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BrokerageAccount)) return false;
        BrokerageAccount that =                       (BrokerageAccount) o;
        return getAccountId() == that.getAccountId() &&
                Objects.equals(getAccountNumber(), that.getAccountNumber()) &&
                Objects.equals(getAccountName(), that.getAccountName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountId(), getAccountNumber(), getAccountName());
    }

    public BrokerageAccount(int accountId, String accountNumber, String accountName) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
