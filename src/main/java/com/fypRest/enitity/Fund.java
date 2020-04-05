package com.fypRest.enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="fund")
public class Fund
{
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="amount")
    private int amount;

    @Column(name="donner_bank")
    private String sender_bank;

    @Column(name="donner_card")
    private String sender_card;

    @Column(name="donner_account_no")
    private String sender_accountNo; // account is String because HBL account no contains the alphabets.

    @Column(name="date")
    private Date date;

    @Column(name="receiver_bank")
    private String receiver_bank;

    @Column(name="receiver_card")
    private String receiver_card;

    @Column(name="receiver_account_no")
    private String receiver_accountNo;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JsonIgnore
    @JoinColumn(name = "charity_id")
    private CharityHouse charityHouse;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JsonIgnore
    @JoinColumn(name = "donner_id")
    private Donner donner;

    public Fund()
    {
    }

    public CharityHouse getCharityHouse()
    {
        return charityHouse;
    }

    public void setCharityHouse(CharityHouse charityHouse)
    {
        this.charityHouse = charityHouse;
    }

    public Donner getDonner()
    {
        return donner;
    }

    public void setDonner(Donner donner)
    {
        this.donner = donner;
    }

    public Fund(int amount, String sender_bank, String sender_card, String sender_accountNo, Date date, String receiver_bank, String receiver_card, String receiver_accountNo)
    {
        this.amount = amount;
        this.sender_bank = sender_bank;
        this.sender_card = sender_card;
        this.sender_accountNo = sender_accountNo;
        this.date = date;
        this.receiver_bank = receiver_bank;
        this.receiver_card = receiver_card;
        this.receiver_accountNo = receiver_accountNo;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    public String getSender_bank()
    {
        return sender_bank;
    }

    public void setSender_bank(String sender_bank)
    {
        this.sender_bank = sender_bank;
    }

    public String getSender_card()
    {
        return sender_card;
    }

    public void setSender_card(String sender_card)
    {
        this.sender_card = sender_card;
    }

    public String getSender_accountNo()
    {
        return sender_accountNo;
    }

    public void setSender_accountNo(String sender_accountNo)
    {
        this.sender_accountNo = sender_accountNo;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getReceiver_bank()
    {
        return receiver_bank;
    }

    public void setReceiver_bank(String receiver_bank)
    {
        this.receiver_bank = receiver_bank;
    }

    public String getReceiver_card()
    {
        return receiver_card;
    }

    public void setReceiver_card(String receiver_card)
    {
        this.receiver_card = receiver_card;
    }

    public String getReceiver_accountNo()
    {
        return receiver_accountNo;
    }

    public void setReceiver_accountNo(String receiver_accountNo)
    {
        this.receiver_accountNo = receiver_accountNo;
    }

    @Override
    public String toString()
    {
        return "Fund{" +
                "id=" + id +
                ", amount=" + amount +
                ", sender_bank='" + sender_bank + '\'' +
                ", sender_card=" + sender_card +
                ", sender_accountNo='" + sender_accountNo + '\'' +
                ", date=" + date +
                ", receiver_bank='" + receiver_bank + '\'' +
                ", receiver_card=" + receiver_card +
                ", receiver_accountNo='" + receiver_accountNo + '\'' +
                '}';
    }
}
