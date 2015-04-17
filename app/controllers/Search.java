package controllers;

import models.Game;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.*;

public class Search extends Controller {
  @Security.Authenticated(Secured.class)
  public static Result index() {
    return ok(search.render());
  }

  @Security.Authenticated(Secured.class)
  public static Result get(String title) {
    return ok(Json.toJson(Game.searchByTitle(title)));
  }
}
