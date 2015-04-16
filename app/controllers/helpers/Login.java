package controllers.helpers;

import models.Admin;

public class Login {
  public String username;
  public String password;

  public String validate() {
    if (Admin.authenticate(username, password) == null) {
      return "Nom d'utilisateur ou mot de passe invalide.";
    }
    return null;
  }

}
