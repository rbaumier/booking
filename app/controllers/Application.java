package controllers;

import models.Booking;
import play.data.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  static Form<Booking> bookingForm = Form.form(Booking.class);

  public static Result index() {
    return redirect("/bookings");
  }

  public static Result bookings() {
    return ok(views.html.index.render(Booking.all(), bookingForm));
  }

  public static Result newBooking() {
    return Results.TODO;
  }

  public static Result deleteBooking(long id) {
    return Results.TODO;
  }
}
