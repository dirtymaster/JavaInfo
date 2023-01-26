package edu.school21.javainfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recommendations")
public class Recommendation {
    @Id
    @Column
    public int id;
    @Column
    public String peer;
    @Column
    public String recommendedPeer;
}
