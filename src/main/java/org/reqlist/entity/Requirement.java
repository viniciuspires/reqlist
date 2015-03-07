package org.reqlist.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.reqlist.enumerated.RequirementTypeEnum;

@Entity
@Table(name = "requirement")
public class Requirement implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "title")
    @NotNull
    @NotBlank
    @Size(min = 1, max = 128)
    private String title;
    
    @Basic
    @Size(max = 1024)
    @Column(name = "description")
    private String description;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "register_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private RequirementTypeEnum type;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User user;
    
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Project project;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requirement")
    private List<Task> tasks;
    
    @ManyToMany(mappedBy = "requirements")
    private List<Objective> objectives;
    
    @ManyToMany(mappedBy = "requirements")
    private List<Scope> scopes;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public RequirementTypeEnum getType() {
        return type;
    }

    public void setType(RequirementTypeEnum type) {
        this.type = type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Objective> getObjectives() {
        return objectives;
    }

    public void setObjectives(List<Objective> objectives) {
        this.objectives = objectives;
    }

    public List<Scope> getScopes() {
        return scopes;
    }

    public void setScopes(List<Scope> scopes) {
        this.scopes = scopes;
    }
    
}
