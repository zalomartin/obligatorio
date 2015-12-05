package com.kedb.entities;

import com.kedb.exceptions.ApplicationKEDBException;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
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

@NamedQueries({
    @NamedQuery(name = "UserEntity.getAllUsers", query = "SELECT u FROM UserEntity u "),
    @NamedQuery(name = "UserEntity.findUserByName", query = "SELECT u FROM UserEntity u  WHERE upper(u.userName) = upper(:userName)")}
)
@Entity
@Table(name = "USERS")
@XmlRootElement
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final int MD5_PASSWORD_LENGTH = 16;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_NAME", nullable = false, unique = true)
    private String userName;

    @JoinColumn(name = "USER_ROLE", nullable = true, unique = false)
    private RoleEntity role;

    @Column(name = "USER_PWD", nullable = false)
    private String password;

    public UserEntity() {
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(obj instanceof UserEntity)) {
            return false;
        }
        UserEntity other = (UserEntity) obj;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.kedb.entities.UserEntity[ id=" + id + " ]";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws ApplicationKEDBException {
        this.password = encriptPassword(password);
    }

    //TODO: ver si se puede poner en un lugar mejor como Utilities o Authentication
    public String encriptPassword(String password) throws ApplicationKEDBException {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(password.getBytes());
            BigInteger hash = new BigInteger(1, md5.digest());
            return hash.toString(MD5_PASSWORD_LENGTH);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApplicationKEDBException("Error al generar clave");
        }
    }
}
