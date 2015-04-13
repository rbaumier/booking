package models;

import play.data.validation.Constraints.*;
import play.db.ebean.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team extends Model {
  @Id
  public long id;
  public String name;

  @Required
  @OneToMany (cascade = CascadeType.ALL)
  public List<Player> players;

  public static Finder<Long, Team> find = new Finder<Long, Team>(Long.class, Team.class);

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
