package controllers;

import models.Admin;
import play.Routes;
import play.data.Form;
import play.mvc.*;
import views.html.index;
import views.html.login;

public class Application extends Controller {
  public static Result index() {
    new Admin("bowling", "bowling").save();
    return ok(index.render());
  }

  // http://stackoverflow.com/questions/11133059/play-2-x-how-to-make-an-ajax-request-with-a-common-button
  public static Result javascriptRoutes() {
    response().setContentType("text/javascript");
    return ok(
      Routes.javascriptRouter("JSRouter",
        routes.javascript.Games.getAll()
      )
    );
  }

  public static Result logout() {
    session().clear();
    flash("success", "You've been logged out");
    return redirect(
      routes.Application.login()
    );
  }

  public static class Login {
    public String username;
    public String password;
    public String validate() {
      if (Admin.authenticate(username, password) == null) {
        return "Invalid user or password";
      }
      return null;
    }
  }

  public static Result login() {
    return ok(
      login.render(Form.form(Login.class))
    );
  }

  public static Result authenticate() {
    Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
    if (loginForm.hasErrors()) {
      return badRequest(login.render(loginForm));
    } else {
      session().clear();
      session("username", loginForm.get().username);
      return redirect(
        routes.Application.index()
      );
    }
  }
}
