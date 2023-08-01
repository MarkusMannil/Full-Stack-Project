package com.example.markus_00.User;

import com.example.markus_00.Sectors.Sector;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Class for user0 table in database (read more in README)
 */
@Entity
@Table
public class User0 {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;

    private String name;
    @ManyToMany
    @JoinTable(
            name = "user_sectors",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "sector_id")
    )
    private Set<Sector> userSectors = new HashSet<>();
    private boolean terms;
    public User0() {
    }

    public User0(Long id, String name, Set<Sector> userSectors, boolean terms) {
        this.id = id;
        this.name = name;
        this.userSectors = userSectors;
        this.terms = terms;
    }

    public User0(String name, Set<Sector> userSectors, boolean terms) {
        this.name = name;
        this.userSectors = userSectors;
        this.terms = terms;
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
    public Set<Sector> getUserSectors() {
        return userSectors;
    }
    public void setUserSectors(Set<Sector> userSectors) {
        this.userSectors = userSectors;
    }
    public void addToUserSectors(Sector sector) {
        userSectors.add(sector);
    }
    public boolean isTerms() {
        return terms;
    }
    public void setTerms(boolean bool) {
        this.terms = bool;
    }

    @Override
    public String toString() {
        return "User0{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userSectors=" + userSectors +
                ", bool=" + terms +
                '}';
    }
}
