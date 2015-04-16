package controllers;

import models.Game;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.*;

public class Games extends Controller {
  static Form<Game> gameForm = Form.form(Game.class);

  @Security.Authenticated(Secured.class)
  public static Result index() {
    return ok(games.render());
  }

  @Security.Authenticated(Secured.class)
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

  @Security.Authenticated(Secured.class)
  public static Result form() {
    return ok(addgame.render(gameForm));
  }

  @Security.Authenticated(Secured.class)
  public static Result delete(long id) {
    Game.delete(id);
    return redirect("/games");
  }

  @Security.Authenticated(Secured.class)
  // returns all games as JSON for AJAX request
  public static Result getAll() {
    return ok(Json.toJson(Game.all()));
  }

  @Security.Authenticated(Secured.class)
  public static Result edit(Long id) {
    Game game = Game.find.ref(id);
    Form form = gameForm.fill(game);
    return ok(editgame.render(form, id, game));
  }

  @Security.Authenticated(Secured.class)
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
