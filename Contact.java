/*
		Ryan Helferich
		CS 320
		11/13/21
		Contact Class
*/


public class Contact {
	
	private static final String INITIALIZER = "INITIAL";
	private static final String INITIALIZER_NUM = "1235559999";
	private static final byte CONTACT_FNAME_LENGTH = 10;
	private static final byte CONTACT_LNAME_LENGTH = 10;
	private static final int CONTACT_PHONENUM_LENGTH = 10;
	private static final byte CONTACT_ID_LENGTH = 10;
	private static final byte CONTACT_ADDRESS_LENGTH = 30;
  private static final byte CONTACT_NOTES_LENGTH = 120;
  // Added notes length

  private String contactId;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String address;
  private String notes;

  Contact() {
    this.contactId = INITIALIZER;
    this.firstName = INITIALIZER;
    this.lastName = INITIALIZER;
    this.phoneNumber = INITIALIZER_NUM;
    this.address = INITIALIZER;
    this.notes = INITIALIZER;
  }

  Contact(String contactId) {
    updateContactId(contactId);
    this.firstName = INITIALIZER;
    this.lastName = INITIALIZER;
    this.phoneNumber = INITIALIZER_NUM;
    this.address = INITIALIZER;
  }

  Contact(String contactId, String firstName) {
    updateContactId(contactId);
    updateFirstName(firstName);
    this.lastName = INITIALIZER;
    this.phoneNumber = INITIALIZER_NUM;
    this.address = INITIALIZER;
  }

  Contact(String contactId, String firstName, String lastName) {
    updateContactId(contactId);
    updateFirstName(firstName);
    updateLastName(lastName);
    this.phoneNumber = INITIALIZER_NUM;
    this.address = INITIALIZER;
  }

  Contact(String contactId, String firstName, String lastName,
          String phoneNumber) {
    updateContactId(contactId);
    updateFirstName(firstName);
    updateLastName(lastName);
    updatePhoneNumber(phoneNumber);
    this.address = INITIALIZER;
  }

  Contact(String contactId, String firstName, String lastName,
    String phoneNumber, String address) {
    updateContactId(contactId);
    updateFirstName(firstName);
    updateLastName(lastName);
    updatePhoneNumber(phoneNumber);
    updateAddress(address);
  }
//New Notes implementation
  Contact(String contactId, String firstName, String lastName,
  String phoneNumber, String address, String notes) {
  updateContactId(contactId);
  updateFirstName(firstName);
  updateLastName(lastName);
  updatePhoneNumber(phoneNumber);
  updateAddress(address);
  updateNotes(notes); //update notes
  this.notes = INITIALIZER;
}



  protected final String getFirstName() { return firstName; }
  protected final String getAddress() { return address; }
  protected final String getContactId() { return contactId; }
  protected final String getPhoneNumber() { return phoneNumber; }
  protected final String getLastName() { return lastName; }


  protected void updateFirstName(String firstName) {
    if (firstName == null) {
      throw new IllegalArgumentException("First name cannot be empty");
    } else if (firstName.length() > CONTACT_FNAME_LENGTH) {
      throw new IllegalArgumentException("First name cannot be longer than " +
                                         CONTACT_FNAME_LENGTH + " characters");
    } else {
      this.firstName = firstName;
    }
  }

  protected void updateLastName(String lastName) {
    if (lastName == null) {
      throw new IllegalArgumentException("Last name cannot be empty");
    } else if (lastName.length() > CONTACT_LNAME_LENGTH) {
      throw new IllegalArgumentException("Last name cannot be longer than " +
                                         CONTACT_LNAME_LENGTH + " characters");
    } else {
      this.lastName = lastName;
    }
  }

  protected void updatePhoneNumber(String phoneNumber) {
    String regex = "[0-9]+";
    if (phoneNumber == null) {
      throw new IllegalArgumentException("Phone number cannot be empty.");
    } else if (phoneNumber.length() != CONTACT_PHONENUM_LENGTH) {
      throw new IllegalArgumentException(
          "Phone number length invalid. Ensure it is " +
          CONTACT_PHONENUM_LENGTH + " digits.");
    } else if (!phoneNumber.matches(regex)) {
      throw new IllegalArgumentException(
          "Phone number cannot have anything but numbers");
    } else {
      this.phoneNumber = phoneNumber;
    }
  }

  protected void updateAddress(String address) {
    if (address == null) {
      throw new IllegalArgumentException("Address cannot be empty");
    } else if (address.length() > CONTACT_ADDRESS_LENGTH) {
      throw new IllegalArgumentException("Address cannot be longer than " +
                                         CONTACT_ADDRESS_LENGTH +
                                         " characters");
    } else {
      this.address = address;
    }
  }

  protected void updateContactId(String contactId) {
    if (contactId == null) {
      throw new IllegalArgumentException("Contact ID cannot be empty");
    } else if (contactId.length() > CONTACT_ID_LENGTH) {
      throw new IllegalArgumentException("Contact ID cannot be longer than " +
                                         CONTACT_ID_LENGTH + " characters");
    } else {
      this.contactId = contactId;
    }
  }

  protected void updateNotes(String notes) {
    if (notes == null) {
      throw new IllegalArgumentException("Notes cannot be empty");
    } else if (notes.length() > CONTACT_NOTES_LENGTH) {
      throw new IllegalArgumentException("Notes cannot be longer than " +
                                         CONTACT_NOTES_LENGTH +
                                         " characters");
    //Check for matching escape characters
    } else if (notes.matches("[\\w*\\s*]*")) {
      //throw expection if caught
      throw new IllegalArgumentException("Detected suspicious characters, please try again.");
    } else {
      this.notes = notes;
    }
  }
}
