package com.mallplanet.api.virus.controller;

import com.mallplanet.api.virus.ResourceNotFoundException;
import com.mallplanet.api.virus.model.Virus;
import com.mallplanet.api.virus.repository.VirusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class VirusController {

    @Autowired
    private VirusRepository virusRepository;

    @PostMapping("/virus")
    public Virus createVirus(@RequestBody Virus virus) {
        return virusRepository.save(virus);
    }

    @GetMapping("/virus")
    public List<Virus> getVirus() {
        return virusRepository.findAll();
    }

    @PutMapping("/virus/{id}")
    public ResponseEntity< Virus > updateVirus(
            @PathVariable(value = "id") Long virusFamilyId,
            @RequestBody Virus virusDetails) throws ResourceNotFoundException {
        Virus virus = virusRepository.findById(virusFamilyId)
                .orElseThrow(() -> new ResourceNotFoundException("Virus not found"));
        virus.setName(virusDetails.getName());

        final Virus updatedVirus = virusRepository.save(virus);
        return ResponseEntity.ok(updatedVirus);
    }

    @DeleteMapping("/virus/{id}")
    public Map< String, Boolean > deleteVirus(
            @PathVariable(value = "id") Long virusFamilyId) throws ResourceNotFoundException {
        Virus instructor = virusRepository.findById(virusFamilyId)
                .orElseThrow(() -> new ResourceNotFoundException("Virus not found "));

        virusRepository.delete(instructor);
        Map < String, Boolean > response = new HashMap< >();
        response.put("Virus deleted", Boolean.TRUE);
        return response;
    }

}