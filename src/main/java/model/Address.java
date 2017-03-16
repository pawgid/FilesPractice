package model;

public class Address {

    public enum streetPrefix {
        STREET("ul."), AVENUE("al."), SQUARE("pl."),;

        private final String prefix;

        streetPrefix(String prefix) {
            this.prefix = prefix;
        }


    }


    private String streetName;
    private String houseNumber;
    private String flatNumber;
    private String postalCode;
    private String city;
    private String country;

    public Address() {
    }



    public Address(String streetName, String houseNumber, String flatNumber, String postalCode, String city, String country) {

        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

//    @Override
//    public String toString() {
//        return
//                streetName + " " + houseNumber + "/" + flatNumber + " " + postalCode + " " + city;
//    }

    @Override
    public String toString() {
        return
        streetName + " " + houseNumber + "/" + flatNumber + "\n" + postalCode + " " + city;
    }
}
