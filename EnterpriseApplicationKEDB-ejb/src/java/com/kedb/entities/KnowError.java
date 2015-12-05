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

@Entity
@Table(name = "KNOW_ERROR")
@XmlRootElement

@NamedQueries({
    @NamedQuery(name = "KnowError.getKECategory", query = "SELECT k from KnowError k WHERE upper(k.category)=upper(:category)"),
    @NamedQuery(name = "KnowError.getAllKE", query = "SELECT k from KnowError k"),
    @NamedQuery(name = "KnowError.getKEKeyword", query = "SELECT k from KnowError k WHERE "
            + "(upper(k.cause) LIKE CONCAT ('%',upper (:cause),'%') OR (upper(k.category) LIKE CONCAT ('%',upper (:category),'%') OR "
            + "(upper(k.solution) LIKE CONCAT ('%',upper (:solution),'%') OR (upper(k.workaround) LIKE CONCAT ('%',upper (:workaround),'%')))))")}
)

public class KnowError implements Serializable {

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

    public KnowError() {
    }

    public KnowError(Long id) {
        this.id = id;
    }

    public KnowError(Long id, String cause, String solution, String workaround, String category) {
        this.id = id;
        this.cause = category;
        this.solution = solution;
        this.workaround = workaround;
        this.category = category;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KnowError)) {
            return false;
        }
        KnowError other = (KnowError) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "kedb.entities.KnowError[ id=" + id + " ]";
    }

}
