package com.kedb.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gonzalo.martin
 */
@NamedQueries({
    @NamedQuery(name = "RoleEntity.findRolName", query = "SELECT e from RoleEntity e WHERE e.description=:description")}
)
@Entity
@Table(name = "ROLES")
@XmlRootElement
public class RoleEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ID")
    private Long id;    
    
    @Column(name = "DESCRIPTION", nullable = false, unique = true)
    private String description;

    public RoleEntity() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RoleEntity)) {
            return false;
        }
        RoleEntity other = (RoleEntity) obj;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
        
    @Override
    public String toString() {
        return "com.kedb.entities.RoleEntity[ id=" + id + " ]";
    }


    
    
    
}
