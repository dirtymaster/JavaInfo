package edu.school21.javainfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @Column
    public String title;

    @Column
    public String parentTask;

    @Column
    public int maxXP;
}
