package com.horus.ankata.core.domain.commons;
// Generated 25 oct. 2017 16:01:11 by Hibernate Tools 4.3.1


import com.horus.ankata.core.domain.achat.*;
import com.horus.ankata.core.domain.vente.VteBonsEncaissements;
import com.horus.ankata.core.domain.vente.VteDevis;
import com.horus.ankata.core.domain.vente.VteFactures;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ComTypesPayements generated by hbm2java
 */
@Entity
@Table(name="com_types_payements"
    ,catalog="ankata_db"
)
public class ComTypesPayements  implements java.io.Serializable {


     private String code;
     private String libelle;
     private Set<VteFactures> vteFactureses = new HashSet<VteFactures>(0);
     private Set<VteDevis> vteDevises = new HashSet<VteDevis>(0);
     private Set<AchBonsDecaissements> achBonsDecaissementses = new HashSet<AchBonsDecaissements>(0);
     private Set<VteBonsEncaissements> vteBonsEncaissementses = new HashSet<VteBonsEncaissements>(0);
     private Set<AchFactures> achFactureses = new HashSet<AchFactures>(0);

    public ComTypesPayements() {
    }

	
    public ComTypesPayements(String code) {
        this.code = code;
    }
    public ComTypesPayements(String code, String libelle, Set<VteFactures> vteFactureses, Set<VteDevis> vteDevises, Set<AchBonsDecaissements> achBonsDecaissementses, Set<VteBonsEncaissements> vteBonsEncaissementses, Set<AchFactures> achFactureses) {
       this.code = code;
       this.libelle = libelle;
       this.vteFactureses = vteFactureses;
       this.vteDevises = vteDevises;
       this.achBonsDecaissementses = achBonsDecaissementses;
       this.vteBonsEncaissementses = vteBonsEncaissementses;
       this.achFactureses = achFactureses;
    }
   
     @Id 

    
    @Column(name="code", unique=true, nullable=false, length=5)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    
    @Column(name="libelle", length=45)
    public String getLibelle() {
        return this.libelle;
    }
    
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="comTypesPayements")
    public Set<VteFactures> getVteFactureses() {
        return this.vteFactureses;
    }
    
    public void setVteFactureses(Set<VteFactures> vteFactureses) {
        this.vteFactureses = vteFactureses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="comTypesPayements")
    public Set<VteDevis> getVteDevises() {
        return this.vteDevises;
    }
    
    public void setVteDevises(Set<VteDevis> vteDevises) {
        this.vteDevises = vteDevises;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="comTypesPayements")
    public Set<AchBonsDecaissements> getAchBonsDecaissementses() {
        return this.achBonsDecaissementses;
    }
    
    public void setAchBonsDecaissementses(Set<AchBonsDecaissements> achBonsDecaissementses) {
        this.achBonsDecaissementses = achBonsDecaissementses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="comTypesPayements")
    public Set<VteBonsEncaissements> getVteBonsEncaissementses() {
        return this.vteBonsEncaissementses;
    }
    
    public void setVteBonsEncaissementses(Set<VteBonsEncaissements> vteBonsEncaissementses) {
        this.vteBonsEncaissementses = vteBonsEncaissementses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="comTypesPayements")
    public Set<AchFactures> getAchFactureses() {
        return this.achFactureses;
    }
    
    public void setAchFactureses(Set<AchFactures> achFactureses) {
        this.achFactureses = achFactureses;
    }




}

