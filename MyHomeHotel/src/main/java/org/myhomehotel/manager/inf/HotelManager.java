package org.myhomehotel.manager.inf;

import java.time.LocalDate;
import java.util.List;
import org.myhomehotel.model.MyHomeReservation;

public interface HotelManager {
  int findFreeRooms(LocalDate givenDate);

  void setNumberOfRooms(int numRooms);

  boolean bookRoom(MyHomeReservation res);

  List<MyHomeReservation> showBookingsForAGuest(String guestName, String kycId );

}
