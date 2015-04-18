package controllers;

import models.Admin;
import play.Routes;
import play.mvc.*;
import views.html.index;

public class Application extends Controller {
  public static Result index() {
//    new Admin().create("bowling", "bowling");
    return ok(index.render());
  }

  // http://stackoverflow.com/questions/11133059/play-2-x-how-to-make-an-ajax-request-with-a-common-button
  public static Result javascriptRoutes() {
    response().setContentType("text/javascript");
    return ok(Routes.javascriptRouter("JSRouter",
      routes.javascript.Games.getAll(),
      routes.javascript.Search.get()
    ));
  }
}
