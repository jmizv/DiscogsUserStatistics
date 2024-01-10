package de.jmizv.discogsuserstatistics.model;

import jakarta.persistence.*;

@Entity
@Table(name = "r")
public class Release {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column(name = "extid")
  private Integer extid;
  @Column(name = "name")
  private String name;
  @Column(name = "ryear")
  private String year;
  @Column(name = "master_fk_id")
  private Integer masterId;

}
