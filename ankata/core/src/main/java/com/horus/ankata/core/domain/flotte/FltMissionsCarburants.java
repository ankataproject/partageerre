package com.horus.ankata.core.domain.flotte;
// Generated 25 oct. 2017 16:01:11 by Hibernate Tools 4.3.1


import com.horus.ankata.core.domain.commons.ComFournisseurs;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * FltMissionsCarburants generated by hbm2java
 */
@Entity
@Table(name="flt_missions_carburants"
    ,catalog="ankata_db"
)
public class FltMissionsCarburants  implements java.io.Serializable {


     private Long id;
     private ComFournisseurs comFournisseurs;
     private FltMissions fltMissions;
     private Date dateAch;
     private Double montant;
     private String numBon;
     private Double pu;
     private Double qte;
     private String station;

    public FltMissionsCarburants() {
    }

    public FltMissionsCarburants(ComFournisseurs comFournisseurs, FltMissions fltMissions, Date dateAch, Double montant, String numBon, Double pu, Double qte, String station) {
       this.comFournisseurs = comFournisseurs;
       this.fltMissions = fltMissions;
       this.dateAch = dateAch;
       this.montant = montant;
       this.numBon = numBon;
       this.pu = pu;
       this.qte = qte;
       this.station = station;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fournisseur")
    public ComFournisseurs getComFournisseurs() {
        return this.comFournisseurs;
    }
    
    public void setComFournisseurs(ComFournisseurs comFournisseurs) {
        this.comFournisseurs = comFournisseurs;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="mission")
    public FltMissions getFltMissions() {
        return this.fltMissions;
    }
    
    public void setFltMissions(FltMissions fltMissions) {
        this.fltMissions = fltMissions;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="date_ach", length=10)
    public Date getDateAch() {
        return this.dateAch;
    }
    
    public void setDateAch(Date dateAch) {
        this.dateAch = dateAch;
    }

    
    @Column(name="montant", precision=22, scale=0)
    public Double getMontant() {
        return this.montant;
    }
    
    public void setMontant(Double montant) {
        this.montant = montant;
    }

    
    @Column(name="num_bon", length=20)
    public String getNumBon() {
        return this.numBon;
    }
    
    public void setNumBon(String numBon) {
        this.numBon = numBon;
    }

    
    @Column(name="pu", precision=22, scale=0)
    public Double getPu() {
        return this.pu;
    }
    
    public void setPu(Double pu) {
        this.pu = pu;
    }

    
    @Column(name="qte", precision=22, scale=0)
    public Double getQte() {
        return this.qte;
    }
    
    public void setQte(Double qte) {
        this.qte = qte;
    }

    
    @Column(name="station", length=200)
    public String getStation() {
        return this.station;
    }
    
    public void setStation(String station) {
        this.station = station;
    }




}


