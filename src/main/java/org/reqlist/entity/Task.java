/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.reqlist.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "task")
public class Task implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "title")
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
    @Column(name = "done")
    private boolean done;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "task")
    private List<TaskAllocation> allocations;
    
    @JoinColumn(name = "delivery_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Delivery delivery;
    
    @JoinColumn(name = "requirement_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Requirement requirement;
    
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public List<TaskAllocation> getAllocations() {
        return allocations;
    }

    public void setAllocations(List<TaskAllocation> allocations) {
        this.allocations = allocations;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
