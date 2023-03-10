# StudentManagementSystem
REST-API of Student Management System that can be use by any organization in order to maintain there business online.

## Tech Stack
- Java
- Spring Boot with JPA
- MySQL
- Maven
- Lombok
- Swagger UI
- Spring Security


## ER Diagram
Following ER diagram indicates the database tables and thier interaction which we are using.
![ER Diagram](https://user-images.githubusercontent.com/101566310/208860432-64e8317e-af38-4163-bdb5-f3f157ffb566.jpg)

## Entites 
- Admin
- Course
- Student
- User
- Address


## MySql database details
Install and connect with database
```bash
#db specific properties
spring.datasource.url=jdbc:mysql://localhost:3306/StudentManagementSystem
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=9038473989
Spring Data JPA: 2
```

## Admin Controller
```bash
## Admit Student
{
   "student_Code" : 1,
   "studentName" : "Aryan Jaiswal",
   "email" : "aryanjaiswal5928@gmail.com",
   "dateOfBirth" : "20/11/2000",
   "gender" : "male",
   "mobileNumber" : "6666666666",
   "mothersName" : " Mrs Pramila Jaiswal" ,
   "fathersName" :  "Mr Ramchandra Jaiswal"

}

##  Upload Course

{
    "courseName" : "JavaBackedDevelopment",
    "description" : "full fledge course on backend development",
    "courseType" : "full time",
    "duration" : "6 months" ,
    "topics" : "core java, hibernate, jdbc, spring security"
}

## Assign a Course to a Student
http://localhost:8088/admin/assign/1/JavaBackedDevelopment
```
## Student Controller
```bash

##update student profile
{
   "student_Code" : 101,
   "studentName" : "Aryan Jaiswal",
   "email" : "aryanjaiswal5928@gmail.com",
   "dateOfBirth" : "20/11/2000",
   "gender" : "male",
   "mobileNumber" : "7777777777",
   "mothersName" : " Mrs Pramila Jaiswal" ,
   "fathersName" :  "Mr Ramchandra Jaiswal"
}

##check for the assigned course
http://localhost:8088/student/assignedcourses/gaurav
```


## Running Tests
Run the ![Screenshot_20221221_015619](https://user-images.githubusercontent.com/101566310/208862198-d90564ef-2141-4353-a6ed-2f2f1b239009.png)
following command on swagger UI
![Screenshot_20221221_015156](https://user-images.githubusercontent.com/101566310/208862186-333f6ae0-776a-4bee-9ae3-5884ef54fb24.png)

## REST API Use for below functions
- Admit Student by Admin
- upload Course by Admin
- assign a course to a student by Admin
- student can leave the course
- student can update their profile
- student can search their courses by name
