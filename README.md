# PESEL Service

PESEL Service is a REST API that allows extracting data (date of birth and gender) based on the provided PESEL number.

## Table of Contents

- [Introduction](#introduction)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [PESEL Validation](#pesel-validation)
- [Project Structure](#project-structure)

## Introduction
PESEL (Universal Electronic System for Population Registration) is a unique identification number assigned to every citizen of Poland. It consists of 11 digits that contain information about the date of birth, serial number, gender, and a checksum digit.

## Technologies
- **Java 17**
- **Spring Boot (Spring REST)**
- **MapStruct**

## Getting Started
1. Clone the repository:
   ```sh
   git clone https://github.com/shrowd/pesel_service.git
   cd pesel-service
   ```
2. Build the project using Maven:
   ```sh
   mvn clean install
   ```
3. Run the application:
   ```sh
   mvn spring-boot:run
   ```

## Usage
- **Endpoint:** `POST /api/v1/pesel`
- **Example request:**
  ```json
  {
    "pesel": "92052092359"
  }
  ```
- **Example response:**
  ```json
  {
    "birthDate": "1992-05-20",
    "gender": "MALE"
  }
  ```

## PESEL Validation
The service validates PESEL according to the following criteria:
- Not empty: The PESEL request cannot be empty.
- Length: PESEL must be exactly 11 digits long.
- Format: PESEL must consist of digits only.
- Checksum: The last digit of PESEL must comply with the checksum algorithm.

## Project Structure

	  .
	  ├── src 
      │   ├── controller          # Controller layer (handles requests and responses)
      │   ├── core                # Core logic and utilities
      │   ├── dto                 # Data Transfer Objects (models for data communication)
      │   ├── exception           # Custom exceptions and error handling
      │   ├── mapper              # Mapping logic (e.g., mapping between entities and DTOs)
      │   └── service             # Service layer (business logic)
	  ├── test  
      │   └── service             # Tests for service layer
	  └── README.md
  

