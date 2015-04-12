package models;

import play.data.validation.Constraints.*;
import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Booking extends Model {
  @Id
  public long id;
  public String name;

//  @Required
//  @OneToMany
//  public Team team;
//
//  @Required
//  public Timestamp start_date;
//
//  @Required
//  public Alley alley;

  public static Finder<Long,Booking> find = new Finder(
    Long.class, Booking.class
  );

  public static List<Booking> all() {
    return find.all();
  }

  public static void create(Booking booking) {
    booking.save();
  }

  public static void delete(Long id) {
    find.ref(id).delete();
  }
}
