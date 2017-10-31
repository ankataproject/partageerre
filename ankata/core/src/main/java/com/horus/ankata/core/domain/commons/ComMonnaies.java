package com.horus.ankata.core.domain.commons;
// Generated 25 oct. 2017 16:01:11 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ComMonnaies generated by hbm2java
 */
@Entity
@Table(name="com_monnaies"
    ,catalog="ankata_db"
)
public class ComMonnaies  implements java.io.Serializable {


     private String code;
     private String libelle;
     private Double taux;
     private Set<ComPays> comPayses = new HashSet<ComPays>(0);

    public ComMonnaies() {
    }

	
    public ComMonnaies(String code) {
        this.code = code;
    }
    public ComMonnaies(String code, String libelle, Double taux, Set<ComPays> comPayses) {
       this.code = code;
       this.libelle = libelle;
       this.taux = taux;
       this.comPayses = comPayses;
    }
   
     @Id 

    
    @Column(name="code", unique=true, nullable=false, length=5)
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

    
    @Column(name="taux", precision=22, scale=0)
    public Double getTaux() {
        return this.taux;
    }
    
    public void setTaux(Double taux) {
        this.taux = taux;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="comMonnaies")
    public Set<ComPays> getComPayses() {
        return this.comPayses;
    }
    
    public void setComPayses(Set<ComPays> comPayses) {
        this.comPayses = comPayses;
    }




}


