import play.*;
import play.mvc.*;
import play.mvc.Http.*;
import play.libs.F.*;
import views.html.notFound;

import static play.mvc.Results.*;

public class Global extends GlobalSettings {
  // 404 webpage render
  public Promise<Result> onHandlerNotFound(RequestHeader request) {
    return Promise.<Result>pure(notFound(
      notFound.render()
    ));
  }
}
