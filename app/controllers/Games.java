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
    return redirect("/games");
  }

  // returns all games as JSON for AJAX request
  public static Result getAll() {
    return ok(Json.toJson(Game.all()));
  }

  public static Result edit(Long id) {
    Game game = Game.find.ref(id);
    Form form = gameForm.fill(game);
    return ok(editgame.render(form, id, game));
  }

  public static Result update(long id) {
    Form<Game> boundForm = gameForm.bindFromRequest();
    System.out.println(boundForm);
    if(boundForm.hasErrors()) {
      return badRequest(addgame.render(boundForm));
    }
    Game game = boundForm.get();

    // Yup... since ebeans needs a bidirectionnal relation for updates and we have a stackoverflow while generating a json because of that,
    // we will use this ugly trick as a temporary/permanent solution.
    // http://bit.ly/1IKbC24
    game.delete(id);
    game.save();
    return redirect("/games");
  }
}
