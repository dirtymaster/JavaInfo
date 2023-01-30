package edu.school21.javainfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "verter")
public class Verter {
    @Id
    @Column
    public int id;
    @Column
    public int check;
    @Column
    public String state;
    @Column
    public Timestamp time;

    public Verter() {
    }

    public Verter(int id, int check, String state, Timestamp time) {
        this.id = id;
        this.check = check;
        this.state = state;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
