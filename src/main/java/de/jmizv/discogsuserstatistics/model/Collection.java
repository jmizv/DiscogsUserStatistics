package de.jmizv.discogsuserstatistics.model;

import jakarta.persistence.*;

@Entity
@Table(name = "collection")
public class Collection {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column(name = "user_fk_id")
  private Integer userId;
  @Column(name = "r_fk_id")
  private Integer releaseId;

}
