package com.horus.ankata.core.domain.flotte;
// Generated 25 oct. 2017 16:01:11 by Hibernate Tools 4.3.1


import com.horus.ankata.core.domain.commons.ComPersonnes;

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
 * FltDdesInvsPers generated by hbm2java
 */
@Entity
@Table(name="flt_ddes_invs_pers"
    ,catalog="ankata_db"
)
public class FltDdesInvsPers  implements java.io.Serializable {


     private Long id;
     private ComPersonnes comPersonnes;
     private FltDdesInvs fltDdesInvs;
     private Double coutMo;
     private Date dateDebut;
     private Date dateFin;
     private String description;
     private Integer nbHeure;

    public FltDdesInvsPers() {
    }

    public FltDdesInvsPers(ComPersonnes comPersonnes, FltDdesInvs fltDdesInvs, Double coutMo, Date dateDebut, Date dateFin, String description, Integer nbHeure) {
       this.comPersonnes = comPersonnes;
       this.fltDdesInvs = fltDdesInvs;
       this.coutMo = coutMo;
       this.dateDebut = dateDebut;
       this.dateFin = dateFin;
       this.description = description;
       this.nbHeure = nbHeure;
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
    @JoinColumn(name="personne")
    public ComPersonnes getComPersonnes() {
        return this.comPersonnes;
    }
    
    public void setComPersonnes(ComPersonnes comPersonnes) {
        this.comPersonnes = comPersonnes;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="demande")
    public FltDdesInvs getFltDdesInvs() {
        return this.fltDdesInvs;
    }
    
    public void setFltDdesInvs(FltDdesInvs fltDdesInvs) {
        this.fltDdesInvs = fltDdesInvs;
    }

    
    @Column(name="cout_mo", precision=22, scale=0)
    public Double getCoutMo() {
        return this.coutMo;
    }
    
    public void setCoutMo(Double coutMo) {
        this.coutMo = coutMo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="date_debut", length=10)
    public Date getDateDebut() {
        return this.dateDebut;
    }
    
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="date_fin", length=10)
    public Date getDateFin() {
        return this.dateFin;
    }
    
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    
    @Column(name="description")
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="nb_heure")
    public Integer getNbHeure() {
        return this.nbHeure;
    }
    
    public void setNbHeure(Integer nbHeure) {
        this.nbHeure = nbHeure;
    }




}


