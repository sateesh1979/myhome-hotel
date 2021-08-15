package org.myhomehotel.test;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.myhomehotel.impl.BookingManager;
import org.myhomehotel.model.HomeGuest;
import org.myhomehotel.model.MyHomeReservation;

public class BookingManagerTest {

  BookingManager myHomeHotelBookings;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    System.out.println("before class");
  }
  @Before
  public void setUp() throws Exception {
    System.out.println("before");
    myHomeHotelBookings = new BookingManager(1);
  }

  @Test
  public void testBookRoom(){

    List<HomeGuest> guestsForRes1 =  new ArrayList<>();
    guestsForRes1.add(new HomeGuest("1", "Name1",  "1ACB", "33333333", "Line1 XXX") );
    MyHomeReservation ob1 = new MyHomeReservation(LocalDate.of(2021, 8, 14),
        LocalDate.of(2021, 8, 16),2200, guestsForRes1);

    List<HomeGuest> guestsForRes2 =  new ArrayList<>();
    guestsForRes1.add(new HomeGuest("2", "Name2",  "2ACB", "2222", "Line1 XXX") );
    MyHomeReservation ob2 = new MyHomeReservation(LocalDate.of(2021, 8, 14),
        LocalDate.of(2021, 8, 16),2200, guestsForRes2);

    assertEquals(true,myHomeHotelBookings.bookRoom(ob1));
    assertEquals(false,myHomeHotelBookings.bookRoom(ob2));

  }
}
