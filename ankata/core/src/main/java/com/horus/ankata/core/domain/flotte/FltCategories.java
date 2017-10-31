package com.horus.ankata.core.domain.flotte;
// Generated 25 oct. 2017 16:01:11 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FltCategories generated by hbm2java
 */
@Entity
@Table(name="flt_categories"
    ,catalog="ankata_db"
)
public class FltCategories  implements java.io.Serializable {


     private Long id;
     private String code;
     private String icone;
     private String libelle;
     private String statut;

    public FltCategories() {
    }

    public FltCategories(String code, String icone, String libelle, String statut) {
       this.code = code;
       this.icone = icone;
       this.libelle = libelle;
       this.statut = statut;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    
    @Column(name="code", length=20)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    
    @Column(name="icone", length=100)
    public String getIcone() {
        return this.icone;
    }
    
    public void setIcone(String icone) {
        this.icone = icone;
    }

    
    @Column(name="libelle", length=250)
    public String getLibelle() {
        return this.libelle;
    }
    
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    
    @Column(name="statut", length=2)
    public String getStatut() {
        return this.statut;
    }
    
    public void setStatut(String statut) {
        this.statut = statut;
    }




}

