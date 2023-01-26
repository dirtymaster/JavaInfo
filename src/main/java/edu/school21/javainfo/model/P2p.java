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
}
