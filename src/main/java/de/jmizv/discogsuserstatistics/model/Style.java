package de.jmizv.discogsuserstatistics.model;

import jakarta.persistence.*;

@Entity
@Table(name = "style")
public class Style {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column(name = "name")
  private String name;
}
