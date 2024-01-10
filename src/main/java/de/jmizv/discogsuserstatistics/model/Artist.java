package de.jmizv.discogsuserstatistics.model;

import jakarta.persistence.*;

@Entity
@Table(name = "a")
public class Artist {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column(name = "extid")
  private Integer extid;
  @Column(name = "name")
  private String name;
}
