package models;

import play.db.ebean.Model;

import javax.persistence.*;

@Entity
public class Player extends Model {
  @Id
  public long id;
  public String name;

  @OneToOne
  public Stats stats;
}
