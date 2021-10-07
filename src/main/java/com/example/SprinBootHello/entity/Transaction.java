package com.example.SprinBootHello.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tid;
    private long accnum;
    private Float amount;
    private String trtype;
    private Date trdate;
    private String status;
    private Date created;
    private Date updated;
    public Transaction(){}
    public Transaction(int tid, long accnum, Float amount, String trtype, Date trdate, String status,
                       Date created, Date updated) {
        this.tid = tid;
        this.accnum = accnum;
        this.amount = amount;
        this.trtype = trtype;
        this.trdate = trdate;
        this.status = status;
        this.created = created;
        this.updated = updated;
    }

    public int getTid() {return tid;}

    public long getAccnum() {return accnum;}

    public void setAccnum(long accnum) {this.accnum = accnum;}

    public Float getAmount() {return amount;}

    public void setAmount(Float amount) {this.amount = amount;}

    public String getTrtype() {return trtype;}

    public void setTrtype(String trtype) {this.trtype = trtype;}

    public Date getTrdate() {return trdate;}

    public void setTrdate(Date trdate) {this.trdate = trdate;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    public Date getCreated() {return created;}

    public void setCreated(Date created) {this.created = created;}

    public Date getUpdated() {return updated;}

    public void setUpdated(Date updated) {this.updated = updated;}

    @Override
    public String toString() {
        return "Transaction{" +
                "tid=" + tid +
                ", accnum=" + accnum +
                ", amount=" + amount +
                ", trtype='" + trtype + '\'' +
                ", trdate='" + trdate + '\'' +
                ", status='" + status + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                '}';
    }

}
