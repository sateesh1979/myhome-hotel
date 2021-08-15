package org.myhomehotel.util;

public class MyHomeUtil {
  public static int generateBookingId() {
    return (int) (Math.random() * 10000000);
  }
}
