package com.un.wm.caos.dto;

public class BrokerageAccountDto {

    private int account_id;

    private String gsba_account_number;

    private String account_name;

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getGsba_account_number() {
        return gsba_account_number;
    }

    public void setGsba_account_number(String gsba_account_number) {
        this.gsba_account_number = gsba_account_number;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }
}
