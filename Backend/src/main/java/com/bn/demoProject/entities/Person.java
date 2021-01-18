package com.bn.demoProject.entities;

import javax.persistence.*;
@Entity
@Table(name="person")
public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "iban")
    private String iban;

    @Column(name = "name")
    private String name;

    @Column(name = "money")
    private Integer money;

    public Person() {
    }

    public Person(Long id, String iban, String name,Integer money) {
        this.iban = iban;
        this.name = name;
        this.id = id;
        this.money = money;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}