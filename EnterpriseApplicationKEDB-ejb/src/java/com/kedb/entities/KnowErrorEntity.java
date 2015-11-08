package com.kedb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RodrigoL lalala
 */
@Entity
@Table(name = "know_error")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KnowError.findAll", query = "SELECT k FROM KnowError k"),
    @NamedQuery(name = "KnowError.findById", query = "SELECT k FROM KnowError k WHERE k.id = :id"),
    @NamedQuery(name = "KnowError.findByName", query = "SELECT k FROM KnowError k WHERE k.name = :name")})
public class KnowErrorEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)   
    @Size(min = 1, max = 250)
    @NotNull
    @Column(name = "name", nullable = true, unique = true)
    private String name;

    public KnowErrorEntity() {
    }

    public KnowErrorEntity(Long id) {
        this.id = id;
    }

    public KnowErrorEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kedb.entities.KnowError[ id=" + id + " ]";
    }
    
}
