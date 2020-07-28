package com.api.user.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "EMAIL", nullable = false)
    private String email;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "CREATE_DATE")
    private Date createDate;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "MODIFIED_DATE")
    private Date modifiedDate;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "LAST_LOGIN")
    private Date lastLogin;
    @Column(name = "ACTIVE")
    private boolean isActive;

    public User() {
    }

    public User(final String name, final String email, final String password, final boolean isActive) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
    }

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(final Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getLastLogin() {
        return this.lastLogin;
    }

    public void setLastLogin(final Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(final boolean active) {
        isActive = active;
    }
}
