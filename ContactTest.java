/*
		Ryan Helferich
		CS 320
		7/15/21
		Contact Class
 */

import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
  protected String contactId, firstNameTest, lastNameTest, phoneNumberTest,
      addressTest, notesTest, escapeTest;
  protected String tooLongContactId, tooLongFirstName, tooLongLastName,
      tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress, tooLongNotes, escapeCharNotes;


  @BeforeEach
  void setUp() {
    contactId = "1649H8328";
    firstNameTest = "Ryan";
    lastNameTest = "Helferich";
    phoneNumberTest = "9517600184";
    addressTest = "1801 E Palm Valley Blvd";
    tooLongContactId = "1111111111111111111";
    tooLongFirstName = "Ryan Ryan Ryan";
    tooLongLastName = "HelferichHelferichHelferich";
    tooLongPhoneNumber = "9999999999";
    tooShortPhoneNumber = "99";
    tooLongAddress = "1801 E Palm Valley Blvd-1801 E Palm Valley Blvd";
    escapeCharNotes = "[\\w*\\s*]*";
    //121 Characters of notes
    tooLongNotes = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas id dictum enim, a ornare nisi. Maecenas viverra fusce... ";
    
  }

  @Test
  void contactIdFullNamePhoneNumberConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
    assertAll("constructor four",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertEquals(lastNameTest, contact.getLastName()),
              ()
                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              ()
                  -> assertEquals(notesTest, contact.getNotes()),

              () -> assertNotNull(contact.getAddress()));
  }
  
  @Test
  void contactIdAndFirstNameConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest);
    assertAll("constructor two",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactTest() {
    Contact contact = new Contact();
    assertAll("constructor",
              ()
                  -> assertNotNull(contact.getContactId()),
              ()
                  -> assertNotNull(contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              ()
                  -> assertNotNull(contact.getNotes()),

              () -> assertNotNull(contact.getAddress()));
  }
  
  @Test
  void contactIdConstructorTest() {
    Contact contact = new Contact(contactId);
    assertAll("constructor one",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
                  -> assertNotNull(contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
                  
              () -> assertNotNull(contact.getAddress()));
  }  
  
  @Test
  void contactIdAndFullNameConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest);
    assertAll("constructor three",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertEquals(lastNameTest, contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }



  @Test
  void allTheProperThingsConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
    assertAll("constructor all",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertEquals(lastNameTest, contact.getLastName()),
              ()
                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              () -> assertEquals(addressTest, contact.getAddress()));
  }

  @Test
  void updateFirstNameTest() {
    Contact contact = new Contact();
    contact.updateFirstName(firstNameTest);
    assertAll(
        "first name",
        ()
            -> assertEquals(firstNameTest, contact.getFirstName()),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateFirstName(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateFirstName(tooLongFirstName)));
  }

  @Test
  void updateLastNameTest() {
    Contact contact = new Contact();
    contact.updateLastName(lastNameTest);
    assertAll(
        "last name",
        ()
            -> assertEquals(lastNameTest, contact.getLastName()),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateLastName(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateLastName(tooLongFirstName)));
  }

  @Test
  void updatePhoneNumberTest() {
    Contact contact = new Contact();
    contact.updatePhoneNumber(phoneNumberTest);
    assertAll("phone number",
              ()
                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updatePhoneNumber(null)),
              ()
                  -> assertThrows(
                      IllegalArgumentException.class,
                      () -> contact.updatePhoneNumber(tooLongPhoneNumber)),
              ()
                  -> assertThrows(
                      IllegalArgumentException.class,
                      () -> contact.updatePhoneNumber(tooShortPhoneNumber)),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updatePhoneNumber(contactId)));
  }

  @Test
  void updateAddressTest() {
    Contact contact = new Contact();
    contact.updateAddress(addressTest);
    assertAll("phone number",
              ()
                  -> assertEquals(addressTest, contact.getAddress()),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updateAddress(null)),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updateAddress(tooLongAddress)));
  }

  @Test
  void updateContactIdTest() {
    Contact contact = new Contact();
    contact.updateContactId(contactId);
    assertAll(
        "contact ID",
        ()
            -> assertEquals(contactId, contact.getContactId()),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateContactId(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateContactId(tooLongContactId)));
  }

  //Notes test - check for invalid characters (malicious code) and null values
  @Test
  void updateNotesTest() {
      Contact contact = new Contact();
      contact.updateNotes(notesTest);
      assertAll(
          "notes",
          ()
          -> assertEquals(notesTest, contact.getNotes()),
          ()
          -> assertThrows(IllegalArgumentException.class,
                          () -> contact.updateNotes(null)),
          ()
          -> assertThrows(IllegalArgumentException.class,
                          () -> contact.updateNotes(tooLongNotes)));
      )
  }
}
