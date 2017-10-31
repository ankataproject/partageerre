package com.horus.ankata.core.domain.flotte;
// Generated 25 oct. 2017 16:01:11 by Hibernate Tools 4.3.1


import com.horus.ankata.core.domain.commons.ComPersonnes;

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

/**
 * FltAssurancesComp generated by hbm2java
 */
@Entity
@Table(name="flt_assurances_comp"
    ,catalog="ankata_db"
)
public class FltAssurancesComp  implements java.io.Serializable {


     private Long id;
     private ComPersonnes comPersonnes;
     private String contactNom;
     private String contactTel;
     private Set<FltAssurances> fltAssuranceses = new HashSet<FltAssurances>(0);

    public FltAssurancesComp() {
    }

    public FltAssurancesComp(ComPersonnes comPersonnes, String contactNom, String contactTel, Set<FltAssurances> fltAssuranceses) {
       this.comPersonnes = comPersonnes;
       this.contactNom = contactNom;
       this.contactTel = contactTel;
       this.fltAssuranceses = fltAssuranceses;
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

    
    @Column(name="contact_nom", length=200)
    public String getContactNom() {
        return this.contactNom;
    }
    
    public void setContactNom(String contactNom) {
        this.contactNom = contactNom;
    }

    
    @Column(name="contact_tel", length=20)
    public String getContactTel() {
        return this.contactTel;
    }
    
    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="fltAssurancesComp")
    public Set<FltAssurances> getFltAssuranceses() {
        return this.fltAssuranceses;
    }
    
    public void setFltAssuranceses(Set<FltAssurances> fltAssuranceses) {
        this.fltAssuranceses = fltAssuranceses;
    }




}


