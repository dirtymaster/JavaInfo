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
    private String title;
    @Column
    private String parrentTask;
    @Column
    private int maxXP;

    public Task() {
    }

    public Task(String title, String parrentTask, int maxXP) {
        this.title = title;
        this.parrentTask = parrentTask;
        this.maxXP = maxXP;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParrentTask() {
        return parrentTask;
    }

    public void setParrentTask(String parrentTask) {
        this.parrentTask = parrentTask;
    }

    public int getMaxXP() {
        return maxXP;
    }

    public void setMaxXP(int maxXP) {
        this.maxXP = maxXP;
    }
}
