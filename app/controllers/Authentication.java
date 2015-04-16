package controllers;

import controllers.helpers.Login;
import models.Game;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Authentication extends Controller {
  static Form<Login> loginForm = Form.form(Login.class);

  public static Result login() {
    return ok(
      login.render(Form.form(Login.class))
    );
  }

  public static Result logout() {
    session().clear();
    flash("success", "Vous avez été déconnecté.");
    return redirect(routes.Application.login());
  }

  public static Result authenticate() {
    Form<Login> boundForm = loginForm.bindFromRequest();
    if(boundForm.hasErrors()) {
      return badRequest(login.render(boundForm));
    }
    session().clear();
    session("username", loginForm.get().username);
    return redirect(routes.Application.index());
  }

}
