package com.example.markus_00.Sectors;

import com.example.markus_00.User.User0;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Class for connecting database and SectorService
 */
@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {
}
