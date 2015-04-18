package models;

import javax.persistence.*;

import org.mindrot.jbcrypt.BCrypt;
import play.db.ebean.*;
import java.util.List;

@Entity
public class Admin extends Model {

  @Id
  public long id;
  public String username;
  public String password;

  public static Admin create(String username, String password) {
    Admin user = new Admin();
    user.username = username;
    user.password = BCrypt.hashpw(password, BCrypt.gensalt());
    user.save();
    return user;
  }

  public static Finder<String,Admin> find = new Finder<String,Admin>(
    String.class, Admin.class
  );

  public String validate() {
    if(Admin.authenticate(username, password)) return null;
    return "Nom d'utilisateur ou mot de passe invalide";
  }

  public static boolean authenticate(String username, String password) {
    return true;
  }
}
