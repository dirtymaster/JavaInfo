package edu.school21.javainfo.model;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String title;

    @Column
    public String parentTask;

    @Column
    public int maxXP;
}
