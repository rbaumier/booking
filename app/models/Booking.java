package models;

import play.data.validation.Constraints.*;
import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Booking extends Model {
  @Required
  @Id
  public long id;

  @Required
  public String name;

  @Required
  @OneToMany
  public Team team;

  @Required
  public Timestamp start_date;

  @Required
  public Alley alley;

  public static List<Booking> all() {
    return new ArrayList<Booking>();
  }

  public static void create(Booking task) {
  }

  public static void delete(Long id) {
  }
}
