package models;

import javax.persistence.*;
import play.db.ebean.*;
import java.util.List;

@Entity
public class Admin extends Model {

  @Id
  public long id;
  public String username;
  public String password;

  public static Finder<String,Admin> find = new Finder<String,Admin>(
    String.class, Admin.class
  );

  public static boolean checkPassword(String password, String maybePassword) {
    return password.equals(maybePassword);
  }

  public static boolean isValid(String username, String password) {
    // prevent InvocationTargetException
    List<Admin> users = find.where().eq("username", username).findList();
    Admin user = users.isEmpty() ? null : users.get(0);
    return user != null && checkPassword(user.password, password);
  }
}
