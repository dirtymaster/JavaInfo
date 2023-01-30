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

    public Recommendation() {
    }

    public Recommendation(int id, String peer, String recommendedPeer) {
        this.id = id;
        this.peer = peer;
        this.recommendedPeer = recommendedPeer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeer() {
        return peer;
    }

    public void setPeer(String peer) {
        this.peer = peer;
    }

    public String getRecommendedPeer() {
        return recommendedPeer;
    }

    public void setRecommendedPeer(String recommendedPeer) {
        this.recommendedPeer = recommendedPeer;
    }
}
