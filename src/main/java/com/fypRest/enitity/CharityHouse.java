package com.fypRest.enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="charity_house")
public class CharityHouse
{
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="email")
    private String email;

    @Column(name="no_of_members")
    private int  no_of_members;

    @Column(name="contact")
    private String contact;

    @Column(name="type")
    private String type;

    @Column(name="bank_name")
    private String bank_name;

    @Column(name="account_no")
    private String account_no;
    // private String image;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "charityHouse",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JsonIgnore
    private List<Fund> fundList;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "charityHouse",
            cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.REFRESH})
    @JsonIgnore
    private List<Food> foodList;

    public List<Food> getFoodList()
    {
        return foodList;
    }

    public void setFoodList(List<Food> foodList)
    {
        this.foodList = foodList;
    }

    public CharityHouse()
    {
    }

    public CharityHouse(String name, String address, String email, int no_of_members, String contact, String type, String bank_name, String account_no)
    {
        this.name = name;
        this.address = address;
        this.email = email;
        this.no_of_members = no_of_members;
        this.contact = contact;
        this.type = type;
        this.bank_name = bank_name;
        this.account_no = account_no;
    }

    public List<Fund> getFundList()
    {
        return fundList;
    }

    public void setFundList(List<Fund> fundList)
    {
        this.fundList = fundList;
    }
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getNo_of_members()
    {
        return no_of_members;
    }

    public void setNo_of_members(int no_of_members)
    {
        this.no_of_members = no_of_members;
    }

    public String getContact()
    {
        return contact;
    }

    public void setContact(String contact)
    {
        this.contact = contact;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getBank_name()
    {
        return bank_name;
    }

    public void setBank_name(String bank_name)
    {
        this.bank_name = bank_name;
    }

    public String getAccount_no()
    {
        return account_no;
    }

    public void setAccount_no(String account_no)
    {
        this.account_no = account_no;
    }

    @Override
    public String toString()
    {
        return "CharityHouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", no_of_members=" + no_of_members +
                ", contact='" + contact + '\'' +
                ", type='" + type + '\'' +
                ", bank_name='" + bank_name + '\'' +
                ", account_no='" + account_no + '\'' +
                '}';
    }
}
