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
}
