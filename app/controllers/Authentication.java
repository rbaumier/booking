package controllers;

import models.Admin;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Authentication extends Controller {
  static Form<Admin> loginForm = Form.form(Admin.class);
  public static Result form() {
    return ok(login.render(loginForm));
  }

  public static Result logout() {
    session().clear();
    flash("success", "Vous avez été déconnecté.");
    return redirect(routes.Application.index());
  }

  public static Result login() {
    Form<Admin> boundForm = loginForm.bindFromRequest();
    if(boundForm.hasErrors()) {
      return badRequest(login.render(boundForm));
    }
    Admin admin = boundForm.get();
    session().clear();
    session("username", admin.username);
    return redirect(routes.Application.index());
  }

}
