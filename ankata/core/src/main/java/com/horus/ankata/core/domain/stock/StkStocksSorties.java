package com.horus.ankata.core.domain.stock;
// Generated 25 oct. 2017 16:01:11 by Hibernate Tools 4.3.1


import com.horus.ankata.core.domain.commons.ComClients;

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
 * StkStocksSorties generated by hbm2java
 */
@Entity
@Table(name="stk_stocks_sorties"
    ,catalog="ankata_db"
)
public class StkStocksSorties  implements java.io.Serializable {


     private Long id;
     private ComClients comClients;
     private StkStocks stkStocks;
     private String article;
     private Date dateSortie;
     private String emporterPar;
     private Double puv;
     private Double qteSortie;

    public StkStocksSorties() {
    }

    public StkStocksSorties(ComClients comClients, StkStocks stkStocks, String article, Date dateSortie, String emporterPar, Double puv, Double qteSortie) {
       this.comClients = comClients;
       this.stkStocks = stkStocks;
       this.article = article;
       this.dateSortie = dateSortie;
       this.emporterPar = emporterPar;
       this.puv = puv;
       this.qteSortie = qteSortie;
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
    @JoinColumn(name="client")
    public ComClients getComClients() {
        return this.comClients;
    }
    
    public void setComClients(ComClients comClients) {
        this.comClients = comClients;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="stock")
    public StkStocks getStkStocks() {
        return this.stkStocks;
    }
    
    public void setStkStocks(StkStocks stkStocks) {
        this.stkStocks = stkStocks;
    }

    
    @Column(name="article", length=500)
    public String getArticle() {
        return this.article;
    }
    
    public void setArticle(String article) {
        this.article = article;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="date_sortie", length=10)
    public Date getDateSortie() {
        return this.dateSortie;
    }
    
    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    
    @Column(name="emporter_par", length=200)
    public String getEmporterPar() {
        return this.emporterPar;
    }
    
    public void setEmporterPar(String emporterPar) {
        this.emporterPar = emporterPar;
    }

    
    @Column(name="puv", precision=22, scale=0)
    public Double getPuv() {
        return this.puv;
    }
    
    public void setPuv(Double puv) {
        this.puv = puv;
    }

    
    @Column(name="qte_sortie", precision=22, scale=0)
    public Double getQteSortie() {
        return this.qteSortie;
    }
    
    public void setQteSortie(Double qteSortie) {
        this.qteSortie = qteSortie;
    }




}


