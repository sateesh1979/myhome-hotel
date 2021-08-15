package org.myhomehotel.model;

import java.time.LocalDate;
import java.util.List;
import org.myhomehotel.util.MyHomeUtil;

public class MyHomeReservation {


   // lambok can be used to generate setter/getters.     but, now i am generation setter/getters.
  private final Integer id;
  private final LocalDate fromDate;
  private final LocalDate toDate;
  private final Integer price;
  private String status;   // Booking, Booked, Active, Cancelled, Error
  private List<HomeGuest> guests;

  public MyHomeReservation(LocalDate fromDate, LocalDate toDate, Integer price,List<HomeGuest> guests) {
    this.id = MyHomeUtil.generateBookingId();
    this.fromDate = fromDate;
    this.toDate = toDate;
    this.price = price;
    this.guests = guests;
    this.status = "Booking";
  }

  public Integer getId() {
    return id;
  }

  public LocalDate getFromDate() {
    return fromDate;
  }

  public LocalDate getToDate() {
    return toDate;
  }

  public Integer getPrice() {
    return price;
  }

  public List<HomeGuest> getGuests() {
    return guests;
  }

  public String toString(){
   return "reservation Id:"+id +" -  fromDate:"+fromDate +  " -  toDate:"+toDate +" - price:"+price;
  }
}
