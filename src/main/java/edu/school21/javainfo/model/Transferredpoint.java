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
}
