package models;

import play.data.validation.Constraints.*;
import play.db.ebean.Model;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Game extends Model {
  @Id
  public long id;
  public int alley;
  public String name;
  public Date start_ts;;

  @Required
  @OneToMany (cascade = CascadeType.ALL)
  public List<Team> teams;

  public static Finder<Long, Game> find = new Finder(
    Long.class, Game.class
  );

  public static List<Game> all() {
    return find.all();
  }

  public static void delete(Long id) {
    find.ref(id).delete();
  }
}
