/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "KNOW_ERROR")
@XmlRootElement

@NamedQueries({
    @NamedQuery(name = "KnowErrorEntity.getKECategory", query = "SELECT k from KnowErrorEntity k WHERE upper(k.category)=upper(:category)"),
    @NamedQuery(name = "KnowErrorEntity.getAllKE", query = "SELECT k from KnowErrorEntity k"),
    @NamedQuery(name = "KnowErrorEntity.getKEKeyword", query = "SELECT k from KnowErrorEntity k WHERE "
            + "(upper(k.cause) LIKE CONCAT ('%',upper (:cause),'%') OR (upper(k.category) LIKE CONCAT ('%',upper (:category),'%') OR "
            + "(upper(k.solution) LIKE CONCAT ('%',upper (:solution),'%') OR (upper(k.workaround) LIKE CONCAT ('%',upper (:workaround),'%')))))")}
)

public class KnowErrorEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "KEDB_ID")
    private Long id;

    @Column(name = "CAUSE", nullable = false, unique = false)
    private String cause;
    @Column(name = "SOLUTION", nullable = false, unique = false)
    private String solution;
    @Column(name = "WORKAROUND", nullable = true, unique = false)
    private String workaround;
    @Column(name = "CATEGORY", nullable = false, unique = false)
    private String category;
    @JoinColumn(name = "AUTHOR", nullable = false, unique = false)
    private UserEntity author;
    

    public KnowErrorEntity() {
    }

    public KnowErrorEntity(Long id) {
        this.id = id;
    }

    public KnowErrorEntity(Long id, String cause, String solution, String workaround, String category, UserEntity author) {
        this.id = id;
        this.cause = category;
        this.solution = solution;
        this.workaround = workaround;
        this.category = category;
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWorkaround() {
        return workaround;
    }

    public void setWorkaround(String workaround) {
        this.workaround = workaround;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
    
    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KnowErrorEntity)) {
            return false;
        }
        KnowErrorEntity other = (KnowErrorEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "kedb.entities.KnowError[ id=" + id + " ]";
    }

}
