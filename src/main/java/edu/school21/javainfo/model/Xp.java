package edu.school21.javainfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "xp")
public class Xp {
    @Id
    @Column
    public int id;
    @Column
    public int check;
    @Column
    public int xpAmount;

    public Xp() {
    }

    public Xp(int id, int check, int xpAmount) {
        this.id = id;
        this.check = check;
        this.xpAmount = xpAmount;
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

    public int getXpAmount() {
        return xpAmount;
    }

    public void setXpAmount(int xpAmount) {
        this.xpAmount = xpAmount;
    }
}
