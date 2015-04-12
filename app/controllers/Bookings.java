package controllers;

import models.Booking;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Bookings extends Controller {
  static Form<Booking> bookingForm = Form.form(Booking.class);

  public static Result list() {
    return ok(views.html.index.render(Booking.all()));
  }

  public static Result create() {
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

  public static Result delete(long id) {
    Booking.delete(id);
    return redirect("/bookings");
  }
}
