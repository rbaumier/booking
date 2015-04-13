package models;

import play.db.ebean.Model;

import javax.persistence.*;

@Entity
public class Player extends Model {
  @Id
  public long id;
  public String name;

  @ManyToOne
  public Team team;

  @Column(columnDefinition = "integer default 0")
  public int score = 0;
}
