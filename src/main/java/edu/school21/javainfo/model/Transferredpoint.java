package edu.school21.javainfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transferredpoints")
public class Transferredpoint {
    @Id
    @Column
    public int id;
    @Column
    public String checkingPeer;
    @Column
    public String checkedPeer;
    @Column
    public int pointsAmount;

    public Transferredpoint() {
    }

    public Transferredpoint(int id, String checkingPeer, String checkedPeer, int pointsAmount) {
        this.id = id;
        this.checkingPeer = checkingPeer;
        this.checkedPeer = checkedPeer;
        this.pointsAmount = pointsAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCheckingPeer() {
        return checkingPeer;
    }

    public void setCheckingPeer(String checkingPeer) {
        this.checkingPeer = checkingPeer;
    }

    public String getCheckedPeer() {
        return checkedPeer;
    }

    public void setCheckedPeer(String checkedPeer) {
        this.checkedPeer = checkedPeer;
    }

    public int getPointsAmount() {
        return pointsAmount;
    }

    public void setPointsAmount(int pointsAmount) {
        this.pointsAmount = pointsAmount;
    }
}
