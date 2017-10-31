package com.horus.ankata.core.domain.achat;
// Generated 25 oct. 2017 16:01:11 by Hibernate Tools 4.3.1


import com.horus.ankata.core.domain.commons.ComUnites;
import com.horus.ankata.core.domain.stock.StkArticles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AchDevisLignes generated by hbm2java
 */
@Entity
@Table(name="ach_devis_lignes"
    ,catalog="ankata_db"
)
public class AchDevisLignes  implements java.io.Serializable {


     private Long id;
     private AchDevis achDevis;
     private ComUnites comUnites;
     private StkArticles stkArticles;
     private String designation;
     private Double moutantHt;
     private Double pu;
     private Double qte;

    public AchDevisLignes() {
    }

    public AchDevisLignes(AchDevis achDevis, ComUnites comUnites, StkArticles stkArticles, String designation, Double moutantHt, Double pu, Double qte) {
       this.achDevis = achDevis;
       this.comUnites = comUnites;
       this.stkArticles = stkArticles;
       this.designation = designation;
       this.moutantHt = moutantHt;
       this.pu = pu;
       this.qte = qte;
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
    @JoinColumn(name="devis")
    public AchDevis getAchDevis() {
        return this.achDevis;
    }
    
    public void setAchDevis(AchDevis achDevis) {
        this.achDevis = achDevis;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="unite")
    public ComUnites getComUnites() {
        return this.comUnites;
    }
    
    public void setComUnites(ComUnites comUnites) {
        this.comUnites = comUnites;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="article")
    public StkArticles getStkArticles() {
        return this.stkArticles;
    }
    
    public void setStkArticles(StkArticles stkArticles) {
        this.stkArticles = stkArticles;
    }

    
    @Column(name="designation", length=300)
    public String getDesignation() {
        return this.designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    
    @Column(name="moutant_ht", precision=22, scale=0)
    public Double getMoutantHt() {
        return this.moutantHt;
    }
    
    public void setMoutantHt(Double moutantHt) {
        this.moutantHt = moutantHt;
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




}

