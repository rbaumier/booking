package models;

import play.data.format.Formats;

import play.data.validation.Constraints.*;
import play.db.ebean.Model;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Game extends Model {
  @Id
  public long id;

  @Required
  @Min(value = 1, message = "Le numéro de piste doit être compris entre 1 et 10 inclus.")
  @Max(value = 10, message = "Le numéro de piste doit être compris entre 1 et 10 inclus.")
  public int alley;

  @Required(message = "Vous devez spécifier un nom de partie.")
  public String name;

  @Required
  public String phone;

  @Formats.DateTime(pattern="yyyy-MM-dd'T'HH:mm")
  public Date start_date;

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

  public static List<Game> searchByTitle(String name) {
    return find.where().eq("name", name).findList();
  }
}
