package edu.school21.javainfo.model;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String title;

    @Column
    public String parentTask;

    @Column
    public int maxXP;

    public Task() {
    }

    public Task(String title, String parentTask, int maxXP) {
        this.title = title;
        this.parentTask = parentTask;
        this.maxXP = maxXP;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParentTask() {
        return parentTask;
    }

    public void setParentTask(String parentTask) {
        this.parentTask = parentTask;
    }

    public int getMaxXP() {
        return maxXP;
    }

    public void setMaxXP(int maxXP) {
        this.maxXP = maxXP;
    }
}
