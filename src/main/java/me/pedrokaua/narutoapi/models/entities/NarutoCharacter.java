package me.pedrokaua.narutoapi.models.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document(value = "characters")
public class NarutoCharacter {

    private String id;

    private String name;

    private Integer age;

    private Character gender;

    private String clan;

    private String rank;

    public NarutoCharacter(){}

    public NarutoCharacter(String name, Integer age, Character gender, String clan, String rank) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.clan = clan;
        this.rank = rank;
    }

    public NarutoCharacter(String id, Integer age, String name, Character gender, String clan, String rank) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.clan = clan;
        this.rank = rank;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
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
