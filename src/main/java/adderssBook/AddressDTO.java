package adderssBook;

public class AddressDTO {
    String city;
    String state;
    String zip;

    public AddressDTO(String city, String state, String zip) {
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public AddressDTO(Address address) {
        this(address.city, address.state, address.zip);
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
