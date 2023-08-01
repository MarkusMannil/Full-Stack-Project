package com.example.markus_00.Sectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class used mostly for adding sectors to database
 *
 * would remove otherwise, but I'll leave it in so that how I did it would be seen
 */
@RestController
@RequestMapping(path = "/api/v1/sector")
public class SectorController {


    private final SectorService service;

    @Autowired
    public SectorController(SectorService service) {
        this.service = service;
    }
    @PostMapping
    public void addNewSector(@RequestBody List<Sector> sectors){
        for (Sector sector:sectors) {
            service.addSector(sector);
        }
    }
}
