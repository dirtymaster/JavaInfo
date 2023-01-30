package edu.school21.javainfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "timetracking")
public class Timetracking {
    @Id
    @Column
    public int id;
    @Column
    public String peer;
    @Column
    public Date date;
    @Column
    public Time time;
    @Column
    public String state;

    public Timetracking() {
    }

    public Timetracking(int id, String peer, Date date, Time time, String state) {
        this.id = id;
        this.peer = peer;
        this.date = date;
        this.time = time;
        this.state = state;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
