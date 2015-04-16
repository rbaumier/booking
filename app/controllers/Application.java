package controllers;

import play.Routes;
import play.mvc.*;
import views.html.index;
import play.mvc.Http.*;
import play.libs.F.*;
import views.html.notFound;

public class Application extends Controller {
  public static Result index() {
    // if account needed => new Admin("bowling", "bowling").save();
    return ok(index.render());
  }

  // http://stackoverflow.com/questions/11133059/play-2-x-how-to-make-an-ajax-request-with-a-common-button
  public static Result javascriptRoutes() {
    response().setContentType("text/javascript");
    return ok(Routes.javascriptRouter("JSRouter", routes.javascript.Games.getAll()));
  }
}
