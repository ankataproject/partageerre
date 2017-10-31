package com.horus.ankata.core.domain.commons;
// Generated 25 oct. 2017 16:01:11 by Hibernate Tools 4.3.1


import com.horus.ankata.core.domain.flotte.FltTrajets;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ComLocalites generated by hbm2java
 */
@Entity
@Table(name="com_localites"
    ,catalog="ankata_db"
)
public class ComLocalites  implements java.io.Serializable {


     private String code;
     private ComPays comPays;
     private Float latitude;
     private Float longitude;
     private String nom;
     private Set<FltTrajets> fltTrajetsesForDepart = new HashSet<FltTrajets>(0);
     private Set<FltTrajets> fltTrajetsesForArrive = new HashSet<FltTrajets>(0);

    public ComLocalites() {
    }

	
    public ComLocalites(String code) {
        this.code = code;
    }
    public ComLocalites(String code, ComPays comPays, Float latitude, Float longitude, String nom, Set<FltTrajets> fltTrajetsesForDepart, Set<FltTrajets> fltTrajetsesForArrive) {
       this.code = code;
       this.comPays = comPays;
       this.latitude = latitude;
       this.longitude = longitude;
       this.nom = nom;
       this.fltTrajetsesForDepart = fltTrajetsesForDepart;
       this.fltTrajetsesForArrive = fltTrajetsesForArrive;
    }
   
     @Id 

    
    @Column(name="code", unique=true, nullable=false, length=5)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pays")
    public ComPays getComPays() {
        return this.comPays;
    }
    
    public void setComPays(ComPays comPays) {
        this.comPays = comPays;
    }

    
    @Column(name="latitude", precision=12, scale=0)
    public Float getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    
    @Column(name="longitude", precision=12, scale=0)
    public Float getLongitude() {
        return this.longitude;
    }
    
    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    
    @Column(name="nom", length=200)
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="comLocalitesByDepart")
    public Set<FltTrajets> getFltTrajetsesForDepart() {
        return this.fltTrajetsesForDepart;
    }
    
    public void setFltTrajetsesForDepart(Set<FltTrajets> fltTrajetsesForDepart) {
        this.fltTrajetsesForDepart = fltTrajetsesForDepart;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="comLocalitesByArrive")
    public Set<FltTrajets> getFltTrajetsesForArrive() {
        return this.fltTrajetsesForArrive;
    }
    
    public void setFltTrajetsesForArrive(Set<FltTrajets> fltTrajetsesForArrive) {
        this.fltTrajetsesForArrive = fltTrajetsesForArrive;
    }




}


