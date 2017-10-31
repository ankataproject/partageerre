package com.horus.ankata.core.domain.commons;
// Generated 25 oct. 2017 16:01:11 by Hibernate Tools 4.3.1


import com.horus.ankata.core.domain.flotte.FltParcs;
import com.horus.ankata.core.domain.stock.StkBonsSorties;

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
 * ComStructures generated by hbm2java
 */
@Entity
@Table(name="com_structures"
    ,catalog="ankata_db"
)
public class ComStructures  implements java.io.Serializable {


     private Long id;
     private ComPays comPays;
     private ComStructures comStructures;
     private String code;
     private Date dc;
     private Date du;
     private String etat;
     private String libelle;
     private Integer niveau;
     private String typeStruc;
     private Long ucid;
     private Long uuid;
     private Set<ComPersonnes> comPersonneses = new HashSet<ComPersonnes>(0);
     private Set<FltParcs> fltParcses = new HashSet<FltParcs>(0);
     private Set<StkBonsSorties> stkBonsSortieses = new HashSet<StkBonsSorties>(0);
     private Set<ComStructures> comStructureses = new HashSet<ComStructures>(0);

    public ComStructures() {
    }

	
    public ComStructures(String code) {
        this.code = code;
    }
    public ComStructures(ComPays comPays, ComStructures comStructures, String code, Date dc, Date du, String etat, String libelle, Integer niveau, String typeStruc, Long ucid, Long uuid, Set<ComPersonnes> comPersonneses, Set<FltParcs> fltParcses, Set<StkBonsSorties> stkBonsSortieses, Set<ComStructures> comStructureses) {
       this.comPays = comPays;
       this.comStructures = comStructures;
       this.code = code;
       this.dc = dc;
       this.du = du;
       this.etat = etat;
       this.libelle = libelle;
       this.niveau = niveau;
       this.typeStruc = typeStruc;
       this.ucid = ucid;
       this.uuid = uuid;
       this.comPersonneses = comPersonneses;
       this.fltParcses = fltParcses;
       this.stkBonsSortieses = stkBonsSortieses;
       this.comStructureses = comStructureses;
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
    @JoinColumn(name="pays")
    public ComPays getComPays() {
        return this.comPays;
    }
    
    public void setComPays(ComPays comPays) {
        this.comPays = comPays;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="parent")
    public ComStructures getComStructures() {
        return this.comStructures;
    }
    
    public void setComStructures(ComStructures comStructures) {
        this.comStructures = comStructures;
    }

    
    @Column(name="code", nullable=false, length=250)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dc", length=19)
    public Date getDc() {
        return this.dc;
    }
    
    public void setDc(Date dc) {
        this.dc = dc;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="du", length=19)
    public Date getDu() {
        return this.du;
    }
    
    public void setDu(Date du) {
        this.du = du;
    }

    
    @Column(name="etat", length=2)
    public String getEtat() {
        return this.etat;
    }
    
    public void setEtat(String etat) {
        this.etat = etat;
    }

    
    @Column(name="libelle")
    public String getLibelle() {
        return this.libelle;
    }
    
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    
    @Column(name="niveau")
    public Integer getNiveau() {
        return this.niveau;
    }
    
    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    
    @Column(name="type_struc", length=5)
    public String getTypeStruc() {
        return this.typeStruc;
    }
    
    public void setTypeStruc(String typeStruc) {
        this.typeStruc = typeStruc;
    }

    
    @Column(name="ucid")
    public Long getUcid() {
        return this.ucid;
    }
    
    public void setUcid(Long ucid) {
        this.ucid = ucid;
    }

    
    @Column(name="uuid")
    public Long getUuid() {
        return this.uuid;
    }
    
    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="comStructures")
    public Set<ComPersonnes> getComPersonneses() {
        return this.comPersonneses;
    }
    
    public void setComPersonneses(Set<ComPersonnes> comPersonneses) {
        this.comPersonneses = comPersonneses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="comStructures")
    public Set<FltParcs> getFltParcses() {
        return this.fltParcses;
    }
    
    public void setFltParcses(Set<FltParcs> fltParcses) {
        this.fltParcses = fltParcses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="comStructures")
    public Set<StkBonsSorties> getStkBonsSortieses() {
        return this.stkBonsSortieses;
    }
    
    public void setStkBonsSortieses(Set<StkBonsSorties> stkBonsSortieses) {
        this.stkBonsSortieses = stkBonsSortieses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="comStructures")
    public Set<ComStructures> getComStructureses() {
        return this.comStructureses;
    }
    
    public void setComStructureses(Set<ComStructures> comStructureses) {
        this.comStructureses = comStructureses;
    }




}

