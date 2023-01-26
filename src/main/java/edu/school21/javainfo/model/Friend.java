package edu.school21.javainfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
