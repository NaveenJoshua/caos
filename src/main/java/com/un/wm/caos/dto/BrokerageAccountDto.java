package com.un.wm.caos.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BrokerageAccountDto {
    @JsonIgnore
    private int accountId;

    private String accountNumber;

    private String accountName;

    public int getAccountId() {
        return accountId;
    }

    /*

    Mixedreset

    WHY DONE WE COMMIT SOME CHANGES HERE
    */
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
