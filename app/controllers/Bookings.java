package controllers;

import models.Booking;
import models.Player;
import models.Team;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import java.util.ArrayList;
import java.util.List;

public class Bookings extends Controller {
  static Form<Booking> bookingForm = Form.form(Booking.class);

  public static Result list() {
    return ok(index.render(Booking.all()));
  }

  public static Result create() {
    Form<Booking> boundForm = bookingForm.bindFromRequest();
    System.out.println(boundForm);
    if(boundForm.hasErrors()) {
      return badRequest(newbooking.render(boundForm));
    }
    Booking booking = boundForm.get();

    booking.save();
    return redirect("/bookings");
  }

  public static Result form() {
    return ok(newbooking.render(bookingForm));
  }

  public static Result delete(long id) {
    Booking.delete(id);
    return redirect("/bookings");
  }
}
