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
    return ok(views.html.index.render(Booking.all()));
  }

  public static Result newBooking() {
    Form<Booking> filledForm = bookingForm.bindFromRequest();

    if(filledForm.hasErrors()) {
      return badRequest(views.html.newbooking.render(filledForm));
    }
    Booking.create(filledForm.get());
    return redirect("/bookings");
  }

  public static Result form() {
    return ok(views.html.newbooking.render(bookingForm));
  }

  public static Result deleteBooking(long id) {
    Booking.delete(id);
    return redirect("/bookings");
  }
}
