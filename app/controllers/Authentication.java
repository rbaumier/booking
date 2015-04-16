package controllers;

import models.Admin;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Authentication extends Controller {
  static Form<Login> loginForm = Form.form(Login.class);

  public static Result form() {
    return ok(login.render(loginForm));
  }

  public static Result logout() {
    session().clear();
    flash("success", "Vous avez été déconnecté.");
    return redirect(routes.Application.index());
  }

  public static Result login() {
    Form<Login> boundForm = loginForm.bindFromRequest();
    if(boundForm.hasErrors()) {
      return badRequest(login.render(boundForm));
    }
    Login admin = boundForm.get();
    session().clear();
    session("username", admin.username);
    return redirect(routes.Application.index());
  }

  public static class Login {
    public String username;
    public String password;

    public String validate() {
      if (Admin.authenticate(username, password) == null) {
        return "Nom d'utilisateur ou mot de passe invalide";
      }
      return null;
    }
  }


}
