package com.horus.ankata.core.domain.commons;
// Generated 25 oct. 2017 16:01:11 by Hibernate Tools 4.3.1


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
 * ComProfilsUsers generated by hbm2java
 */
@Entity
@Table(name="com_profils_users"
    ,catalog="ankata_db"
)
public class ComProfilsUsers  implements java.io.Serializable {


     private Long id;
     private ComProfils comProfils;
     private ComUsers comUsers;

    public ComProfilsUsers() {
    }

	
    public ComProfilsUsers(ComUsers comUsers) {
        this.comUsers = comUsers;
    }
    public ComProfilsUsers(ComProfils comProfils, ComUsers comUsers) {
       this.comProfils = comProfils;
       this.comUsers = comUsers;
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
    @JoinColumn(name="profil")
    public ComProfils getComProfils() {
        return this.comProfils;
    }
    
    public void setComProfils(ComProfils comProfils) {
        this.comProfils = comProfils;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user", nullable=false)
    public ComUsers getComUsers() {
        return this.comUsers;
    }
    
    public void setComUsers(ComUsers comUsers) {
        this.comUsers = comUsers;
    }




}


