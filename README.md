#  Hospital Management System (Spring Boot Backend)

A backend system built using **Spring Boot** for managing hospital operations — including patients, doctors, appointments, and medical records.  
It is designed to be efficient, modular, and easily integrable with any frontend like React or Angular.

---

##  Features

- Manage Doctors, Patients, Appointments, and Medical Records  
- Add, update, delete, and view hospital data through secure REST APIs  
- Authentication & Authorization using **JWT**  
- MySQL database integration with **Spring Data JPA (Hibernate)**  
- CORS enabled for frontend communication  
- Structured and layered architecture (Controller → Service → Repository → Entity)

---

## Tech Stack

**Language:** Java  
**Framework:** Spring Boot  
**Security:** Spring Security + JWT  
**Database:** MySQL  
**ORM:** Hibernate / JPA  
**Build Tool:** Maven  
**Testing Tool:** Postman  

---

## ⚙️ Setup Instructions

###  Clone the Repository
```bash
git clone https://github.com/yourusername/hospital-management-backend.git
cd hospital-management-backend
#  Hospital Management System (Spring Boot Backend)

A backend system built using **Spring Boot** for managing hospital operations — including patients, doctors, appointments, and medical records.  
It is designed to be efficient, modular, and easily integrable with any frontend like React or Angular.

---

## ⚙️ Setup & Run Instructions

###  Configure the Database
Create a MySQL database (example: `hospital_db`) and update the `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect



## API Endpoints

| Method | Endpoint | Description |
|--------|-----------|-------------|
| **GET** | `/api/doctors` | Fetch all doctors |
| **POST** | `/api/doctors` | Add a new doctor |
| **PUT** | `/api/doctors/{id}` | Update doctor details |
| **DELETE** | `/api/doctors/{id}` | Delete a doctor |
| **GET** | `/api/patients` | Fetch all patients |
| **POST** | `/api/patients` | Register a new patient |
| **PUT** | `/api/patients/{id}` | Update patient details |
| **DELETE** | `/api/patients/{id}` | Delete a patient |
| **GET** | `/api/appointments` | View all appointments |
| **POST** | `/api/appointments` | Schedule an appointment |
| **PUT** | `/api/appointments/{id}` | Update appointment status |
| **DELETE** | `/api/appointments/{id}` | Cancel an appointment |
| **GET** | `/api/medical-records/{patientId}` | Get medical record of a patient |
| **POST** | `/api/medical-records` | Add a new medical record |
| **POST** | `/api/auth/login` | Login and receive JWT token |
