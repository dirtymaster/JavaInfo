package edu.school21.javainfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "\"checks\"")
public class Check {
    @Id
    @Column
    public int id;
    @Column
    public String peer;
    @Column
    public String task;
    @Column
    public Date date;
}
