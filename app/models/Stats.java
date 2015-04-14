package models;

import play.db.ebean.Model;
import javax.persistence.*;

@Entity
public class Stats extends Model {
  @Id
  public long id;

  @Column(columnDefinition = "integer default 0")
  public int score;

  // total of strikes in a game
  @Column(columnDefinition = "integer default 0")
  public int strikes;

  // total of spares in a game
  @Column(columnDefinition = "integer default 0")
  public int spares;

  @Column(columnDefinition = "integer default 0")
  public int strikeSerie;

  // total of pins fallen in a game
  @Column(columnDefinition = "integer default 0")
  public int pins;
}
