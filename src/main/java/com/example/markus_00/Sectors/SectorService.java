package com.example.markus_00.Sectors;

import com.example.markus_00.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * Class for frontend to backend communication
 */
@Service
public class SectorService {
    private final SectorRepository sectorRepository;


    @Autowired
    public SectorService(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }


    @GetMapping
    public List<Sector> getSectors(){
        return sectorRepository.findAll();
    }

    public void addSector(Sector sector){
        sectorRepository.save(sector);
    }

}
