
#navvis-task-backend
###Local
* Make sure you have docker installed.

    1. Make sure you're outside the navvis-task-backend directory, which contain the docker-compose file and then run the command
        ```
        docker-compose up -d
        ```
    
* Running the application.
    Click on `Run` button on any editor and app would start listening to requests at port 8082.

###Swagger 
* Click the links below to explore rest api.  
  1. http://localhost:8082/v2/api-docs
  2. http://localhost:8082/swagger-ui/index.html (swagger ui)

##Improvements
1. Testing the REST apis endpoint using JUNIT with coverage of important endpoints
2. Better configuration for CORS and setting application properties according to environment
3. Use migration scripts (sql) for creating and modifying models (tables) in the DB
4. 