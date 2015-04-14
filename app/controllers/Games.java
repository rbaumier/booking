package controllers;

import models.Game;
import models.Player;
import models.Team;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import java.util.ArrayList;
import java.util.List;

public class Games extends Controller {
  static Form<Game> gameForm = Form.form(Game.class);

  public static Result list() {
    return ok(index.render(Game.all()));
  }

  public static Result create() {
    Form<Game> boundForm = gameForm.bindFromRequest();
    System.out.println(boundForm);
    if(boundForm.hasErrors()) {
      return badRequest(newgame.render(boundForm));
    }
    Game game = boundForm.get();

    game.save();
    return redirect("/games");
  }

  public static Result form() {
    return ok(newgame.render(gameForm));
  }

  public static Result delete(long id) {
    Game.delete(id);
    return redirect("/games");
  }
}
