package models;

import play.data.validation.Constraints.*;
import play.db.ebean.Model;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Booking extends Model {
  @Id
  public long id;
  public int alley;
  public String name;
  public Date start_date;;

  @Required
  @OneToMany (cascade = CascadeType.ALL)
  public List<Team> teams;

  public static Finder<Long,Booking> find = new Finder(
    Long.class, Booking.class
  );

  public static List<Booking> all() {
    return find.all();
  }

  public static void delete(Long id) {
    find.ref(id).delete();
  }
}
