package com.fypRest.enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="donner")
public class Donner
{
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="address")
    private String address;

    @Column(name="contact")
    private String contact;
    // image

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "donner",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JsonIgnore
    private List<Fund> fundList;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "donner",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JsonIgnore
    private List<Food> foodList;
//
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fund_id")
//    private Fund fund;
//
//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {CascadeType.DETACH,CascadeType.MERGE,
//                    CascadeType.PERSIST,CascadeType.REFRESH})
//    @JoinTable(name = "food_donner",
//            joinColumns = @JoinColumn(name = "donner_id"),
//            inverseJoinColumns = @JoinColumn(name = "food_id"))
//    @JsonIgnore
//    private List<Food> foodList;

    public Donner()
    {
    }

    public Donner(String name, String email, String address, String contact)
    {
        this.name = name;
        this.email = email;
        this.address = address;
        this.contact = contact;
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getContact()
    {
        return contact;
    }

    public void setContact(String contact)
    {
        this.contact = contact;
    }

    public List<Food> getFoodList()
    {
        return foodList;
    }

    public void setFoodList(List<Food> foodList)
    {
        this.foodList = foodList;
    }

    @Override
    public String toString()
    {
        return "Donner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
