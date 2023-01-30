package edu.school21.javainfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "\"checks\"")
public class Check {
    @Id
    @Column
    public int id;
    @Column
    public String peer;
    @Column
    public String task;
    @Column
    public Date date;

    public Check() {
    }

    public Check(int id, String peer, String task, Date date) {
        this.id = id;
        this.peer = peer;
        this.task = task;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeer() {
        return peer;
    }

    public void setPeer(String peer) {
        this.peer = peer;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
