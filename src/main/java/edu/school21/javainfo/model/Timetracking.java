package edu.school21.javainfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "timetracking")
public class Timetracking {
    @Id
    @Column
    public int id;
    @Column
    public String peer;
    @Column
    public Date date;
    @Column
    public Time time;
    @Column
    public String state;
}
