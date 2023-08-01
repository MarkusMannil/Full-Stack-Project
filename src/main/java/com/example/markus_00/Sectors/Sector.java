package com.example.markus_00.Sectors;

import com.example.markus_00.User.User0;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
/**
 * Class for sector table in database (read more in README)
 */

@Entity
@Table
public class Sector {

    @Id
    private Long id;
    private String name;
    private int level;
    private int parent;

    @JsonIgnore
    @ManyToMany(mappedBy = "userSectors")
    private Set<User0> Users = new HashSet<>();

    public Sector(Long id, String name, int level, int parent) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.parent = parent;
    }

    public Sector(String name, int level, int parent) {
        this.name = name;
        this.level = level;
        this.parent = parent;
    }

    public Sector() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    /**
     * Function for getting correct offset
     * @return offset per level and name
     */
    public String offsetAndName() {
        return "&nbsp;".repeat(4 * (level - 1)) + name;
    }

    @Override
    public String toString() {
        return "Sector{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
