package com.example.SprinBootHello.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Account
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private long accnum;
    private String accname;
    private int balance;
    private String dob;
    private String actype;
    private double fee;
    private Date created;
    private Date updated;
    public Account(){}


    public int getId(){return id;}
    public long getAccnum() {return accnum;}

    public void setAccnum(long accnum) {this.accnum = accnum;}

    public String getAccname() {return accname;}

    public void setAccname(String accname) {this.accname = accname;}
    public int getBalance() {return balance;}

    public void setBalance(int balance) {this.balance = balance;}

    public String getDob() {return dob;}

    public void setDob(String dob) {this.dob = dob;}

    public String getActype() {return actype;}

    public void setActype(String actype) {this.actype = actype;}

    public double getFee() {return fee;}

    public void setFee(double fee) {this.fee = fee;}

    public Date getCreated() {return created;}

    public void setCreated(Date created) {this.created = created;}

    public Date getUpdated() {return updated;}

    public void setUpdated(Date updated) {this.updated = updated;}

    @Override
    public String toString() {
        return "Account{" +
                "acnum=" + accnum +
                ", acname='" + accname + '\'' +
                ", dob='" + dob + '\'' +
                ", actype='" + actype + '\'' +
                ", fee=" + fee +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                '}';
    }
}
