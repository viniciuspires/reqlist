/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.reqlist.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.reqlist.enumerated.RoleEnum;

/**
 * 
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@Entity
@Table(name = "profile")
public class Profile implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    @JsonIgnore
    protected ProfileKey profileKey;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;
    
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    
    @JoinColumn(name = "project_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Project project;

    public Profile() {
    }

    public Profile(ProfileKey perfilPK) {
        this.profileKey = perfilPK;
    }

    public Profile(ProfileKey profileKey, RoleEnum role) {
        this.profileKey = profileKey;
        this.role = role;
    }

    public Profile(Long userId, Long projectId) {
        this.profileKey = new ProfileKey(userId, projectId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profileKey != null ? profileKey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.profileKey == null && other.profileKey != null) || (this.profileKey != null && !this.profileKey.equals(other.profileKey))) {
            return false;
        }
        return true;
    }

    public ProfileKey getProfileKey() {
        return profileKey;
    }

    public void setProfileKey(ProfileKey profileKey) {
        this.profileKey = profileKey;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
