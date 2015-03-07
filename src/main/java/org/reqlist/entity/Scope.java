package org.reqlist.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@Entity
@Table(name = "scope")
public class Scope implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "title")
    private String title;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "register_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Project project;
    
    @ManyToMany
    @JoinTable(name = "scope_x_requirement",
        joinColumns = @JoinColumn(name = "scope_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "requirement_id", referencedColumnName = "id"))
    private List<Requirement> requirements;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }
    
}
