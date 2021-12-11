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
### Rescue Animal Project
The Rescue Animal Project developed in CS 340 consisted of developing a full-stack based application through the Dash framework a Python based middle-man and a NoSQL MongoDB based database. This application features CRUD based operations through a MVC or Model-View-Controller architecture to query specific requests of information on specific animals in the database for the user. The main area that we have enhanced is based on the update and delete operations within the module. Currently both operations will now handle multiple use cases through the implementation of adding an additional parameter for manipulating multiple components in our database rather than only one. The method will check how many objects are being selected on the user interface and pass through a count which will determine whether we can use a single update/delete function or update many and delete many. This enhancement demonstrates the improvements of a previously overlooked and flawed design from the previous class where the software itself is being limited on the intermediate interaction needed with the user. Not only are we enhancing an easy and friendly to use method for the user to possess, but we are also increasing the overall efficiency of the application by handling multiple tasks in a single movement. Additional tests will need to be implemented to validate our new additions to the previous functions. These tests will help ensure there are limitations and correct case usage between a single operation and multiple within one call to the method. 
```markdown
#U operation for update in CRUD
    def update(self, fromTarget, toTarget, count): #added count parameter
        if fromTarget is not None:
            if count == 1: #Count 1 check
                update_result = self.database.animals.update(fromTarget, toTarget) #update 1 target
                print("Success!")
                print(update_result)
                return True
                
            elif count == 2: # more than 1 count check
                update_result = self.database.animals.update_many(fromTarget, toTarget)  #update all counts
                print("Success!")
                print(update_result)
                return True
                
            else:
                print("Count not recognized - try again.")
                return False
        else:
            #lets the user know there was a problem
            raise Exception("Nothing to update, because at least one of the target parameters is empty")
            return False       

#D operation for delete in CRUD
    def deleteData(self, target, count): #Added count parameter
        if target is not None:
            if count == 1: #Check Count 1
                try:
                    delete_result = self.database.animals.delete_one(target) # delete one
                    print("Success!")
                    print(delete_result)
                    return True
                except Exception as e:
                    print("An exception has occurred: ", e)
            elif count == 2: # More than 1 count
                try:
                    delete_result = self.database.animals.delete_many(target) #Delete many
                    print("Success!")
                    print(delete_result)
                    return True
                except Exception as e:
                    print("An exception has occurred: ", e)
                    return False
            else:
                print("Count not recognized - try again.")
                return False
        else:
            #lets the user know there was a problem
            raise Exception("Nothing to delete, because the target parameter is empty")
            return False        
```

