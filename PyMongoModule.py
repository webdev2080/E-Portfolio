from pymongo import MongoClient
from bson.objectid import ObjectId

class AnimalShelter(object):
    """CRUD OPERATIONS for Animal Collection in MongoDB"""
    
    def __init__(self, user, password):
        #self.client = MongoClient('mongodb://localhost:37300')
        #self.client = MongoClient('mongodb://127.0.0.1:37300/?authSource=AAC&compressors=disabled&gssapiServiceName=mongodb' % (user, password))
        self.client = MongoClient('mongodb://%s:%s@localhost:37300/AAC' % (user, password))
        self.database = self.client['AAC']
        print("Connected to Database")

    
        
#Implement create in Crud
    def create(self, data):
        try:
            if data is not None:
                insert_result = self.database.animals.insert_one(data) #data should be dictionary
                print(insert_result)
                return True
            else:
                #Raise error
                raise Exception("Nothing to save, data is empty")
        except:
            return False # return false for bool requirement
            
#Implement read in Crud
    def read(self, target):
        try:
            if target is not None:
                read_result = list(self.database.animals.find(target, {"_id": False}))
                return read_result
            else:
                raise Exception("Nothing to find. Target is empty.")
                return False
        except Exception as e:
            print("Exception has occured: ", e)

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
            
            
            
            
            
            
            