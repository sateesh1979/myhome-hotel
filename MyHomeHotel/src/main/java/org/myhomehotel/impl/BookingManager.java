package org.myhomehotel.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.myhomehotel.manager.inf.HotelManager;
import org.myhomehotel.model.HomeGuest;
import org.myhomehotel.model.MyHomeReservation;

public class BookingManager implements HotelManager {
  private HashMap<Integer, MyHomeReservation> myHomeReservations;
  private int numberOfRooms;

  public BookingManager(int noOfRooms) {
    myHomeReservations = new HashMap<>();
    numberOfRooms = noOfRooms;
  }

  @Override
  public int findFreeRooms(LocalDate givenDate) {
    int freeRooms = 0;
    for (Entry<Integer, MyHomeReservation> entry : myHomeReservations.entrySet()) {
      MyHomeReservation existingReservation = entry.getValue();
      if (existingReservation.getFromDate().isBefore(givenDate)
          && existingReservation.getToDate().isAfter(givenDate)) {
        freeRooms++;
      }

    }
    return this.numberOfRooms - freeRooms;
  }

  @Override
  public void setNumberOfRooms(int numRooms) {
    this.numberOfRooms = numRooms;
  }

  @Override
  public boolean bookRoom(MyHomeReservation res) {
    int nonAvailableRooms = 0;
    for (Map.Entry<Integer, MyHomeReservation> entry : myHomeReservations.entrySet()) {
      if (verifyReservationsOverlapping(res, entry.getValue())) {
        nonAvailableRooms++;
      }
    }
    if (nonAvailableRooms == this.numberOfRooms) {
      return false;
    } else {
      myHomeReservations.put(res.getId(), res);
      return true;
    }

  }

  private boolean verifyReservationsOverlapping(MyHomeReservation resNew, MyHomeReservation resOld) {
    if (resNew.getFromDate().isAfter(resOld.getToDate()) ||
        resNew.getToDate().isBefore(resOld.getFromDate())) {
      return false;
    }
    return true;
  }

  @Override
  public List<MyHomeReservation> showBookingsForAGuest(String guestName, String kycId) {
    List<MyHomeReservation> out = new ArrayList<>();
    for (MyHomeReservation res : myHomeReservations.values()) {
      for (HomeGuest guest : res.getGuests()) {
        if (guest.getFullName().equalsIgnoreCase(guestName) && guest.getKycDocId().equalsIgnoreCase(kycId) ) {
          out.add(res);
        }
      }
    }
    return out;

  }
}
