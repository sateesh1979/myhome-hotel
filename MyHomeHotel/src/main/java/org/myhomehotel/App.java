package org.myhomehotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.myhomehotel.impl.BookingManager;
import org.myhomehotel.model.HomeGuest;
import org.myhomehotel.model.MyHomeReservation;

public class App {
  public static void main(String[] args) {

    if (args.length < 1) {
      System.err.println("Please provide total rooms in this hotel");
      System.exit(0);
    }
    BookingManager myHomeHotelBookings = new BookingManager(Integer.parseInt(args[0]));
    // myHomeHotelBookings.setNumberOfRooms(40);

    List<HomeGuest> guestsForRes1 =  new ArrayList<>();
    guestsForRes1.add(new HomeGuest("1", "Name1",  "1ACB", "33333333", "Line1 XXX") );

    List<HomeGuest> guestsForRes2 =  new ArrayList<>();
    guestsForRes2.add(new HomeGuest("2", "Name2",  "2ANC", "444444", "Lin2 XXX") );


    List<HomeGuest> guestsForRes3 =  new ArrayList<>();
    guestsForRes3.add(new HomeGuest("3", "Name3",  "3BFC", "5555555", "Line3 XXX") );

    List<HomeGuest> guestsForRes4 =  new ArrayList<>();
    guestsForRes3.add(new HomeGuest("4", "Name4",  "4CCD", "6666", "Line4 XXX") );

    MyHomeReservation ob1 = new MyHomeReservation(LocalDate.of(2021, 8, 14),
        LocalDate.of(2021, 8, 16),2200, guestsForRes1);
    MyHomeReservation ob2 = new MyHomeReservation(LocalDate.of(2021, 8, 13),
        LocalDate.of(2020, 8, 17),1500, guestsForRes2);
    MyHomeReservation ob3 = new MyHomeReservation(LocalDate.of(2021, 8, 12),
        LocalDate.of(2020, 8, 15),1500, guestsForRes3);
    MyHomeReservation ob4 = new MyHomeReservation(LocalDate.of(2021, 8, 11),
        LocalDate.of(2020, 8, 12),1000, guestsForRes4);



    myHomeHotelBookings.bookRoom(ob1);
    myHomeHotelBookings.bookRoom(ob2);
    myHomeHotelBookings.bookRoom(ob3);
    myHomeHotelBookings.bookRoom(ob4);


    List<MyHomeReservation> guests =myHomeHotelBookings.showBookingsForAGuest("Name2","2ANC");
     for(MyHomeReservation res:guests) {
         System.out.println(res);
     }
  }
}
