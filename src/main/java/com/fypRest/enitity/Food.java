package com.fypRest.enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="food")
public class Food
{
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="quantity")
    private int quantity;

    @Column(name="expiry_date")
    private Date expiry_date;

    @Column(name="type")
    private String type;
    // private String image;

//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {CascadeType.DETACH,CascadeType.MERGE,
//                    CascadeType.PERSIST,CascadeType.REFRESH})
//    @JsonIgnore
//    @JoinTable(name = "food_donner",
//            joinColumns = @JoinColumn(name = "food_id"),
//            inverseJoinColumns = @JoinColumn(name = "donner_id"))
//    private List<Donner> donnerList;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JsonIgnore
    @JoinColumn(name = "charity_house_id")
    private CharityHouse charityHouse;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JsonIgnore
    @JoinColumn(name = "food_donner_id")
    private Donner donner;

    public Donner getDonner()
    {
        return donner;
    }

    public void setDonner(Donner donner)
    {
        this.donner = donner;
    }

    public Food()
    {
    }

    public Food(String name, int quantity, Date expiry_date, String type)
    {
        this.name = name;
        this.quantity = quantity;
        this.expiry_date = expiry_date;
        this.type = type;
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

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public Date getExpiry_date()
    {
        return expiry_date;
    }

    public void setExpiry_date(Date expiry_date)
    {
        this.expiry_date = expiry_date;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public CharityHouse getCharityHouse()
    {
        return charityHouse;
    }

    public void setCharityHouse(CharityHouse charityHouse)
    {
        this.charityHouse = charityHouse;
    }

    @Override
    public String toString()
    {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", expiry_date=" + expiry_date +
                ", type='" + type + '\'' +
                '}';
    }
}
