package controllers;

import models.Game;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Games extends Controller {
  static Form<Game> gameForm = Form.form(Game.class);

  public static Result index() {
    return ok(games.render());
  }

  public static Result create() {
    Form<Game> boundForm = gameForm.bindFromRequest();
    System.out.println(boundForm);
    if(boundForm.hasErrors()) {
      return badRequest(addgame.render(boundForm));
    }
    Game game = boundForm.get();
    game.save();
    return index();
  }

  public static Result form() {
    return ok(addgame.render(gameForm));
  }

  public static Result delete(long id) {
    Game.delete(id);
    return index();
  }

  // returns all games as JSON for AJAX request
  public static Result getAll() {
    return ok(Json.toJson(Game.all()));
  }

  public static Result edit(Long id) {
    Form form = gameForm.fill(Game.find.ref(id));
    return ok(editgame.render(form, id));
  }

  public static Result update(long id) {
    Form<Game> boundForm = gameForm.bindFromRequest();
    System.out.println(boundForm);
    if(boundForm.hasErrors()) {
      return badRequest(addgame.render(boundForm));
    }
    Game game = boundForm.get();
    game.id = id;
    game.save();
    return index();

  }
}
