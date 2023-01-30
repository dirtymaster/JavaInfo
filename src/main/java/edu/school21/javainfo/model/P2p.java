package edu.school21.javainfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "p2p")
public class P2p {
    @Id
    @Column
    public int id;
    @Column
    public String check;
    @Column
    public String checkingPeer;
    @Column
    public String state;
    @Column
    public Timestamp time;

    public P2p() {
    }

    public P2p(int id, String check, String checkingPeer, String state, Timestamp time) {
        this.id = id;
        this.check = check;
        this.checkingPeer = checkingPeer;
        this.state = state;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public String getCheckingPeer() {
        return checkingPeer;
    }

    public void setCheckingPeer(String checkingPeer) {
        this.checkingPeer = checkingPeer;
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
