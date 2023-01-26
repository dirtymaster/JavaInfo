package edu.school21.javainfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "peers")
public class Peer {
    @Id
    @Column
    public String nickname;
    @Column
    public Date birthday;
}
