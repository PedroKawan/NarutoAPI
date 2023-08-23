package me.pedrokaua.narutoapi.models.entities;


import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity(name = "tb_character")
public class NarutoCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    private Integer age;

    private Character gender;

    private String clan;

    private String occupation;

    public NarutoCharacter(){}

    public NarutoCharacter(String name, Integer age, Character gender, String clan, String occupation) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.clan = clan;
        this.occupation = occupation;
    }

    public NarutoCharacter(UUID id, Integer age, String name, Character gender, String clan, String occupation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.clan = clan;
        this.occupation = occupation;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String rank) {
        this.occupation = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NarutoCharacter that = (NarutoCharacter) o;

        if (this.id != null && that.id != null) {
            return Objects.equals(id, that.id);
        }
            return this.name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
