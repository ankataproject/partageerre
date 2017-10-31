package com.horus.ankata.core.domain.commons;
// Generated 25 oct. 2017 16:01:11 by Hibernate Tools 4.3.1


import com.horus.ankata.core.domain.achat.*;
import com.horus.ankata.core.domain.stock.StkArticles;
import com.horus.ankata.core.domain.stock.StkBonsSortiesLignes;
import com.horus.ankata.core.domain.stock.StkStocks;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ComUnites generated by hbm2java
 */
@Entity
@Table(name="com_unites"
    ,catalog="ankata_db"
)
public class ComUnites  implements java.io.Serializable {


     private String code;
     private String libelle;
     private Set<AchDevisLignes> achDevisLigneses = new HashSet<AchDevisLignes>(0);
     private Set<StkBonsSortiesLignes> stkBonsSortiesLigneses = new HashSet<StkBonsSortiesLignes>(0);
     private Set<StkArticles> stkArticleses = new HashSet<StkArticles>(0);
     private Set<StkStocks> stkStockses = new HashSet<StkStocks>(0);
     private Set<AchBonsCommandesLignes> achBonsCommandesLigneses = new HashSet<AchBonsCommandesLignes>(0);
     private Set<AchBonsLivraisonsLignes> achBonsLivraisonsLigneses = new HashSet<AchBonsLivraisonsLignes>(0);

    public ComUnites() {
    }

	
    public ComUnites(String code) {
        this.code = code;
    }
    public ComUnites(String code, String libelle, Set<AchDevisLignes> achDevisLigneses, Set<StkBonsSortiesLignes> stkBonsSortiesLigneses, Set<StkArticles> stkArticleses, Set<StkStocks> stkStockses, Set<AchBonsCommandesLignes> achBonsCommandesLigneses, Set<AchBonsLivraisonsLignes> achBonsLivraisonsLigneses) {
       this.code = code;
       this.libelle = libelle;
       this.achDevisLigneses = achDevisLigneses;
       this.stkBonsSortiesLigneses = stkBonsSortiesLigneses;
       this.stkArticleses = stkArticleses;
       this.stkStockses = stkStockses;
       this.achBonsCommandesLigneses = achBonsCommandesLigneses;
       this.achBonsLivraisonsLigneses = achBonsLivraisonsLigneses;
    }
   
     @Id 

    
    @Column(name="code", unique=true, nullable=false, length=20)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    
    @Column(name="libelle", length=200)
    public String getLibelle() {
        return this.libelle;
    }
    
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="comUnites")
    public Set<AchDevisLignes> getAchDevisLigneses() {
        return this.achDevisLigneses;
    }
    
    public void setAchDevisLigneses(Set<AchDevisLignes> achDevisLigneses) {
        this.achDevisLigneses = achDevisLigneses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="comUnites")
    public Set<StkBonsSortiesLignes> getStkBonsSortiesLigneses() {
        return this.stkBonsSortiesLigneses;
    }
    
    public void setStkBonsSortiesLigneses(Set<StkBonsSortiesLignes> stkBonsSortiesLigneses) {
        this.stkBonsSortiesLigneses = stkBonsSortiesLigneses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="comUnites")
    public Set<StkArticles> getStkArticleses() {
        return this.stkArticleses;
    }
    
    public void setStkArticleses(Set<StkArticles> stkArticleses) {
        this.stkArticleses = stkArticleses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="comUnites")
    public Set<StkStocks> getStkStockses() {
        return this.stkStockses;
    }
    
    public void setStkStockses(Set<StkStocks> stkStockses) {
        this.stkStockses = stkStockses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="comUnites")
    public Set<AchBonsCommandesLignes> getAchBonsCommandesLigneses() {
        return this.achBonsCommandesLigneses;
    }
    
    public void setAchBonsCommandesLigneses(Set<AchBonsCommandesLignes> achBonsCommandesLigneses) {
        this.achBonsCommandesLigneses = achBonsCommandesLigneses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="comUnites")
    public Set<AchBonsLivraisonsLignes> getAchBonsLivraisonsLigneses() {
        return this.achBonsLivraisonsLigneses;
    }
    
    public void setAchBonsLivraisonsLigneses(Set<AchBonsLivraisonsLignes> achBonsLivraisonsLigneses) {
        this.achBonsLivraisonsLigneses = achBonsLivraisonsLigneses;
    }




}

