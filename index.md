About Me




--
### Code Review of Projects
[![IMAGE ALT TEXT](https://user-images.githubusercontent.com/52177935/145691919-19fc0537-147c-4558-b081-4f85f0a3552b.PNG)](https://www.youtube.com/watch?v=_7mXQKjlJFA "Code Review")

### Contact Service Application
This project consisted of developing and testing back-end based services for a software company with the goal of creating contacts, task, and appointment systems in place for a front-end based interface to interact with. The project itself was initially started and finished in the CS 320 class. I selected this artifact to be included in my ePortfolio as it demonstrated an excellent case of where test should be implemented when performing CRUD operations on systems. The second goal of including this was being able to demonstrate clean and precise Object-Oriented Programming skills within Java and management through a single series of objects and their sub-classes. 
The test exemplified in this project consisted of checking the protected values in the object, creating a simulation of objects created through Junit while also handling exceptions that may arise during the input or incorrect characters or length variance. The artifact itself was improved in both the structure and security aspect of its potential. In the structure itself, we enhanced the artifact by providing the user with an additional area of usage through “notes” which allows them to implement more information on the contact when initially creating the contact object. Our security aspect of the artifact was enhanced by providing additional checks for character length and scanning for escape sequence characters in the cleansed input to prevent basic/malicious injections from being entered into the system. 
As I was creating the project initially in CS 320, we implemented basic exceptions checks and tests to check for character length and format upon input, yet upon entering this enhancement, I was able to see there were no security checks in place. The main challenge I faced during this enhancement and was able to successfully implement was adding additional security to the objects aside from checking escape characters to prevent current styles of malicious code and how it could break in.

```markdown
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
```

