package org.reqlist.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.reqlist.enumerated.AllocationTypeEnum;

/**
 * 
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@Entity
@Table(name = "allocation")
public class TaskAllocation implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "end")
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private AllocationTypeEnum type;
    
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Task task;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public AllocationTypeEnum getType() {
        return type;
    }

    public void setType(AllocationTypeEnum type) {
        this.type = type;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
    
}
