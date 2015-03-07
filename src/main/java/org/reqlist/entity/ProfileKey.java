package org.reqlist.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@Embeddable
public class ProfileKey implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private Long userId;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "project_id")
    private Long projectId;

    public ProfileKey() {}
    
    public ProfileKey(Long userId, Long projectId) {
        this.userId = userId;
        this.projectId = projectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += userId.intValue();
        hash += projectId.intValue();
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ProfileKey)) {
            return false;
        }
        ProfileKey other = (ProfileKey) object;
        if (!userId.equals(other.getUserId())) {
            return false;
        }
        if (!projectId.equals(other.getProjectId())) {
            return false;
        }
        return true;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
    
}
