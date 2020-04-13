package com.fypRest.enitity;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "star")
    private int star;

    @Column(name="title")
    private int title;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "_donner_id")
    private Donner donner;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "_charity_house_id")
    private CharityHouse charityHouse;

    public Review()
    {
    }

    public Review(int star, int title, Donner donner, CharityHouse charityHouse)
    {
        this.star = star;
        this.title = title;
        this.donner = donner;
        this.charityHouse = charityHouse;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getStar()
    {
        return star;
    }

    public void setStar(int star)
    {
        this.star = star;
    }

    public int getTitle()
    {
        return title;
    }

    public void setTitle(int title)
    {
        this.title = title;
    }

    public Donner getDonner()
    {
        return donner;
    }

    public void setDonner(Donner donner)
    {
        this.donner = donner;
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
        return "Review{" +
                "id=" + id +
                ", star=" + star +
                ", title=" + title +
                ", donner=" + donner +
                ", charityHouse=" + charityHouse +
                '}';
    }
}
