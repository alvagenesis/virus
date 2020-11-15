package com.mallplanet.api.virus.controller;

import com.mallplanet.api.virus.ResourceNotFoundException;
import com.mallplanet.api.virus.model.Virus;
import com.mallplanet.api.virus.model.VirusFamily;
import com.mallplanet.api.virus.repository.VirusFamilyRepository;
import com.mallplanet.api.virus.repository.VirusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class VirusFamilyController {

    @Autowired
    private VirusFamilyRepository virusFamilyRepository;

    @PostMapping("/virus/family")
    public VirusFamily createVirus(@RequestBody VirusFamily virusFamily) {
        return virusFamilyRepository.save(virusFamily);
    }

    @GetMapping("/virus/family")
    public List<VirusFamily> getVirus() {
        return virusFamilyRepository.findAll();
    }

    @PutMapping("/virus/family/{id}")
    public ResponseEntity< VirusFamily > updateVirus(
            @PathVariable(value = "id") Long virusFamilyId,
            @RequestBody VirusFamily virusFamilyDetails) throws ResourceNotFoundException {
        VirusFamily virusFamily = virusFamilyRepository.findById(virusFamilyId)
                .orElseThrow(() -> new ResourceNotFoundException("VirusFamily not found"));
        virusFamily.setName(virusFamilyDetails.getName());

        final VirusFamily updatedVirusFamily = virusFamilyRepository.save(virusFamily);
        return ResponseEntity.ok(updatedVirusFamily);
    }

    @DeleteMapping("/virus/family/{id}")
    public Map< String, Boolean > deleteVirusFamily(
            @PathVariable(value = "id") Long virusFamilyId) throws ResourceNotFoundException {
        VirusFamily virusFamily = virusFamilyRepository.findById(virusFamilyId)
                .orElseThrow(() -> new ResourceNotFoundException("VirusFamily not found "));

        virusFamilyRepository.delete(virusFamily);
        Map < String, Boolean > response = new HashMap< >();
        response.put("Virus family deleted", Boolean.TRUE);
        return response;
    }

}