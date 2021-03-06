package com.horus.ankata.core.domain.flotte;
// Generated 25 oct. 2017 16:01:11 by Hibernate Tools 4.3.1


import com.horus.ankata.core.domain.commons.ComPersonnes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * FltConducteurs generated by hbm2java
 */
@Entity
@Table(name="flt_conducteurs"
    ,catalog="ankata_db"
)
public class FltConducteurs  implements java.io.Serializable {


     private Long id;
     private ComPersonnes comPersonnes;
     private Date datevalPermis;
     private String matricule;
     private String numPermis;
     private String statut;
     private String typePermis;
     private Set<FltMissionsConducteurs> fltMissionsConducteurses = new HashSet<FltMissionsConducteurs>(0);
     private Set<FltVehicules> fltVehiculeses = new HashSet<FltVehicules>(0);

    public FltConducteurs() {
    }

    public FltConducteurs(ComPersonnes comPersonnes, Date datevalPermis, String matricule, String numPermis, String statut, String typePermis, Set<FltMissionsConducteurs> fltMissionsConducteurses, Set<FltVehicules> fltVehiculeses) {
       this.comPersonnes = comPersonnes;
       this.datevalPermis = datevalPermis;
       this.matricule = matricule;
       this.numPermis = numPermis;
       this.statut = statut;
       this.typePermis = typePermis;
       this.fltMissionsConducteurses = fltMissionsConducteurses;
       this.fltVehiculeses = fltVehiculeses;
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

    @Temporal(TemporalType.DATE)
    @Column(name="dateval_permis", length=10)
    public Date getDatevalPermis() {
        return this.datevalPermis;
    }
    
    public void setDatevalPermis(Date datevalPermis) {
        this.datevalPermis = datevalPermis;
    }

    
    @Column(name="matricule", length=250)
    public String getMatricule() {
        return this.matricule;
    }
    
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    
    @Column(name="num_permis", length=20)
    public String getNumPermis() {
        return this.numPermis;
    }
    
    public void setNumPermis(String numPermis) {
        this.numPermis = numPermis;
    }

    
    @Column(name="statut", length=2)
    public String getStatut() {
        return this.statut;
    }
    
    public void setStatut(String statut) {
        this.statut = statut;
    }

    
    @Column(name="type_permis", length=2)
    public String getTypePermis() {
        return this.typePermis;
    }
    
    public void setTypePermis(String typePermis) {
        this.typePermis = typePermis;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="fltConducteurs")
    public Set<FltMissionsConducteurs> getFltMissionsConducteurses() {
        return this.fltMissionsConducteurses;
    }
    
    public void setFltMissionsConducteurses(Set<FltMissionsConducteurs> fltMissionsConducteurses) {
        this.fltMissionsConducteurses = fltMissionsConducteurses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="fltConducteurs")
    public Set<FltVehicules> getFltVehiculeses() {
        return this.fltVehiculeses;
    }
    
    public void setFltVehiculeses(Set<FltVehicules> fltVehiculeses) {
        this.fltVehiculeses = fltVehiculeses;
    }




}


