package de.jmizv.discogsuserstatistics.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "stat_task")
public class StatTask {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column(name = "username")
  private String username;
  @Column(name = "cdate")
  private Instant cdate;
  @Column(name = "finished_date")
  private Instant finishedDate;

  @Column(name = "collection_locked")
  private boolean collectionLocked;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Instant getFinishedDate() {
    return finishedDate;
  }

  public void setFinishedDate(Instant finishedDate) {
    this.finishedDate = finishedDate;
  }
}
