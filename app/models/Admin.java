package models;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;

@Entity
public class Admin extends Model {

  @Id
  public long id;
  public String username;
  public String password;

  public Admin(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public static Finder<String,Admin> find = new Finder<String,Admin>(
    String.class, Admin.class
  );

  public static Object authenticate(String username, String password) {
    return find.where().eq("username", username).eq("password", password).findUnique();
  }
}
