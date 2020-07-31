package com.un.wm.caos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class BrokerageAccount implements Serializable {
    @Id
    @GeneratedValue
    private int account_id;

    @Column
    private String gsba_account_number;

    @Column
    private String account_name;

    public BrokerageAccount(int account_id, String gsba_account_number, String account_name) {
        this.account_id = account_id;
        this.gsba_account_number = gsba_account_number;
        this.account_name = account_name;
    }

    protected BrokerageAccount(){
    }

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

    @Override
    public String toString() {
        return "BrokerageAccount{" +
                "account_id=" + account_id +
                ", gsba_account_number='" + gsba_account_number + '\'' +
                ", account_name='" + account_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BrokerageAccount)) return false;
        BrokerageAccount that = (BrokerageAccount) o;
        return getAccount_id() == that.getAccount_id() &&
                Objects.equals(getGsba_account_number(), that.getGsba_account_number()) &&
                Objects.equals(getAccount_name(), that.getAccount_name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccount_id(), getGsba_account_number(), getAccount_name());
    }
}
