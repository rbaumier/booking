package models;

import javax.persistence.*;
import play.db.ebean.*;

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

  public static boolean checkPassword(String password, String maybePassword) {
    return password.equals(maybePassword);
  }

  public static Admin authenticate(String username, String password) {
    Admin user = find.where().eq("username", username).findUnique();
    System.out.println(user);
    return user != null && checkPassword(user.password, password) ? user : null;
  }
}
