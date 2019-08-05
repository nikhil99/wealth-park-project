# Employee Management System

### Requirements
* Java 8 or higher
* mvn
* Linux or Mac OS (I have not yet tested in windows environment)
### How to start

* Unzip the package EmployeeManagement.zip in a new directory
* "cd" into the new directory
* Build the package by running
    > $ mvn package 
* Run the package with
    > $ java -jar target/EmployeeManagement-0.0.1-SNAPSHOT.jar
    * Currently the server always run on 8080 port (I haven't added support for reading port from configuration on CLI yet).
      Please make sure that 8080 port is free before running the app.
* I added few UTs to test the service and dao, they could be verified with 
    > $ mvn test
    

### Specs
* API has endpoints to 
   * List employees
        >example :
         $ curl -X GET  http://localhost:8080/employees -H 'content-type: application/json' 
   
   * Create employee
        >curl -X POST \
           http://localhost:8080/employees/new \
           -H 'cache-control: no-cache' \
           -H 'content-type: application/json' \
           -d ' {
                         "firstName": "SCS",
                         "lastName": "Baggins",
                         "birthDate": 697297871528,
                         "address": "Tokyo, Japan",
                         "bossId": 2,
                         "salary": 5000
          }'
        
   * Update employee
        > curl -X PUT \
            http://localhost:8080/employees/2 \
            -H 'cache-control: no-cache' \
            -H 'content-type: application/json' \
            -d ' {
                          "firstName": "SCS",
                          "lastName": "Baggins",
                          "birthDate": 697297871528,
                          "address": "501 New Heights Azabu",
                          "bossId": 2,
                          "salary": 750000
           }' 
   
   * Delete Employee
        > curl -X DELETE \
            http://localhost:8080/employees/2 \
            -H 'cache-control: no-cache' \
            -H 'content-type: application/json' \
            -d ' {
                          "firstName": "SCS",
                          "lastName": "Baggins",
                          "birthDate": 697297871528,
                          "address": "501 New Heights Azabu",
                          "bossId": 2,
                          "salary": 750000
           }'
           
   * Filters : 
        * currently filters are only implemented for filter by firstName and/or lastName
        > curl -X POST \
            http://localhost:8080/employees \
            -H 'cache-control: no-cache' \
            -H 'content-type: application/json' \
            -d ' {
                          	"employeeFilterDto":{
                          		"firstName": "Pandurang",
                          		"lastName": "Parmar"
                          	}
           }'
    * Pages : 
        > curl -X POST \
            http://localhost:8080/employees \
            -H 'cache-control: no-cache' \
            -H 'content-type: application/json' \
            -d ' {
                          	"employeePageDto":{
                          		"currentPage":2,
                          		"maxPage":5
                          	}
           }'

        **  Filters with pagination is not yet supported, either filters or pagination works but both doesnt

* I have added the git repo to check the commits and progression on this assignment
> https://github.com/nikhil99/wealth-park-project
