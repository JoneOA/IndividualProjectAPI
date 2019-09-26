package com.QA.model;

import javax.persistence.*;

@Entity
@Table(name="inventory")
public class Inventory {

    @Id
    private Long id;
    private String name;
    private String type;
    private int HP;
    private int Attack;
    private int Defence;
    private int spAttack;
    private int spDefence;
    private int speed;

    public Inventory() {}

    public Inventory(Long id, String name, String type, int HP, int Attack, int Defence, int spAttack, int spDefence, int speed) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.HP = HP;
        this.Attack = Attack;
        this.Defence = Defence;
        this.spAttack = spAttack;
        this.spDefence = spDefence;
        this.speed = speed;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAttack() {
        return Attack;
    }

    public void setAttack(int attack) {
        Attack = attack;
    }

    public int getDefence() {
        return Defence;
    }

    public void setDefence(int defence) {
        Defence = defence;
    }

    public int getSpAttack() {
        return spAttack;
    }

    public void setSpAttack(int spAttack) {
        this.spAttack = spAttack;
    }

    public int getSpDefence() {
        return spDefence;
    }

    public void setSpDefence(int spDefence) {
        this.spDefence = spDefence;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void updateAll(Inventory pokemon){
        this.id = pokemon.getId();
        this.name = pokemon.getName();
        this.type = pokemon.getType();
        this.HP = pokemon.getHP();
        this.Attack = pokemon.getAttack();
        this.Defence = pokemon.getDefence();
        this.spAttack = pokemon.getSpAttack();
        this.spDefence = pokemon.getSpDefence();
        this.speed = pokemon.getSpeed();
    }

}

