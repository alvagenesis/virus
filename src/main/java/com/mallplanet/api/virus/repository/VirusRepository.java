package com.mallplanet.api.virus.repository;

import com.mallplanet.api.virus.model.Virus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VirusRepository extends JpaRepository<Virus, Long> {
}
