package controllers;

import play.mvc.*;
import views.html.stats;

public class Statistics extends Controller {
  public static Result index() {
    return ok(stats.render());
  }

  public static Result get(long id) {
    return Results.TODO;
  }
}
