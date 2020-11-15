package com.mallplanet.api.virus.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class VirusFamily {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @JoinColumn( name = "vvf_fid", referencedColumnName = "id")
    @OneToMany(cascade = {
            CascadeType.ALL
    })
    private List< Virus > viruses;

    public VirusFamily(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Virus> getViruses() {
        return viruses;
    }

    public void setViruses(List<Virus> viruses) {
        this.viruses = viruses;
    }

    @Override
    public String toString() {
        return "VirusFamily{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
