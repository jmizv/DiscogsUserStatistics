package de.jmizv.discogsuserstatistics.model;

import jakarta.persistence.*;

@Entity
@Table(name = "genre")
public class Genre {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column(name = "name")
  private String name;
}
