package edu.school21.javainfo.model;

import javax.persistence.*;

@Entity
@Table(name = "friends")
public class Friend {
    @Id
    @Column
    public int id;
    @Column
    public String peer1;
    @Column
    public String peer2;

    public Friend() {
    }

    public Friend(int id, String peer1, String peer2) {
        this.id = id;
        this.peer1 = peer1;
        this.peer2 = peer2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeer1() {
        return peer1;
    }

    public void setPeer1(String peer1) {
        this.peer1 = peer1;
    }

    public String getPeer2() {
        return peer2;
    }

    public void setPeer2(String peer2) {
        this.peer2 = peer2;
    }
}
