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
}
