package com.example.markus_00.Web;

import com.example.markus_00.Sectors.Sector;
import jakarta.validation.constraints.*;

import java.util.Set;


/**
 * Class user data transfer object
 * needed separate class from user0 for validating user inputs
 */

public class UserDTO {

    // At least one sector must be selected
    @NotEmpty(message = "Select at least one sector")
    private Set<Sector> selectedSectors;
    // Name should consist of only letters and space
    @Pattern(regexp = "[A-Za-zÖÄÜÕŠŽöäõüžš ]+", message = "Name should only contain letters")
    // Name should include first and last names and each name should be at least 2 characters long
    @Pattern(regexp = "\\S{2,} (\\S{2,} ?)+",message = "Name should include first and last name")
    private String name;
    // Terms must be agreed with
    @AssertTrue(message = "Must agree to terms")
    private boolean terms;

    public UserDTO(Set<Sector> selectedSectors) {
        this.selectedSectors = selectedSectors;
    }

    public Set<Sector> getSelectedSectors() {
        return selectedSectors;
    }

    public void setSelectedSectors(Set<Sector> selectedSectors) {
        this.selectedSectors = selectedSectors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTerms() {
        return terms;
    }

    public void setTerms(boolean terms) {
        this.terms = terms;
    }

    @Override
    public String toString() {
        return "SectorDTO{" +
                "selectedSectors=" + selectedSectors +
                '}';
    }
}
