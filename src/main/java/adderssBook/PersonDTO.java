package adderssBook;

public class PersonDTO {
    String firstName;
    String lastName;
    String phoneNumber;
    AddressDTO address;

    public PersonDTO(String firstName, String lastName, String phoneNumber, AddressDTO address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    PersonDTO(PersonInfo personInfo) {
        this(personInfo.firstName,personInfo.lastName,personInfo.phoneNumber,new AddressDTO(personInfo.address));
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + address +
                '}';
    }
}
