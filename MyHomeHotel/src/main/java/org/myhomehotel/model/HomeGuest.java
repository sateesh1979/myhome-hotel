package org.myhomehotel.model;

public class HomeGuest {
    private final String id;
    private final String fullName;
    private final String kycDocId;
    private final String contactPhone;
    private String address;

  public HomeGuest(String id, String fullName, String kycDocId, String contactPhone,
      String address) {
    this.id = id;
    this.fullName = fullName;
    this.kycDocId = kycDocId;
    this.contactPhone = contactPhone;
    this.address = address;
  }

  public void setAddress( String newAddress) {
       this.address =newAddress;
  }
  public String getFullName( ) {
     return fullName;
  }
  public String getId( ) {
    return id;
  }
  public String getKycDocId( ) {
    return kycDocId;
  }
}
