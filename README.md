# Fruit Shop API

FRUIT SHOP API is a Java-based web service that provides an interface for managing fruit shop data. It is designed to be a simple and easy-to-use tool for creating, updating, and retrieving information about various fruits, their prices, and their availability.

# Getting Started
## Prerequisites
To run FRUIT SHOP API, you will need:
- Java 1.8 or higher
- Maven
- An IDE or text editor of your choice

# Installation
To install FRUIT SHOP API, follow these steps:

1. Clone the repository:
```bash
git clone https://github.com/yourusername/fruit-shop-api.git
```
2. Navigate to the project directory:
```bash
cd fruit-shop-api
```
3. Build the project using Maven:
```bash
mvn clean install
```
4. Run the application:
```bash
java -jar target/fruit-shop-api-1.0.0.jar
```

# Endpoints

### CategoryController
| Method | Endpoint | Description |
|---|---|---|
| GET | /api/v1/categories | Retrieve a list of all categories |
| GET | /api/v1/categories/{name} | Retrieve a category by name |

### CustomerController
| Method | Endpoint | Description |
|---|---|---|
| GET | /api/v1/customers | Retrieve a list of all customers |
| GET | /api/v1/customers/{id} | Retrieve a customer by its id |
| POST | /api/v1/customers | Create a new customer |
| PUT | /api/v1/customers/{id} | Update a customer by its id |
| PATCH | /api/v1/customers/{id} | Update a customer partially by its id |
| DELETE | /api/v1/customers/{id} | Delete a customer by its id |

### VendorController
| Method | Endpoint | Description |
|---|---|---|
| GET | /api/v1/vendors | Retrieve a list of all vendors |
| GET | /api/v1/vendors/{id} | Retrieve a vendor by its id |
| POST | /api/v1/vendors | Create a new vendor |
| PUT | /api/v1/vendors/{id} | Update a vendor by its id |
| PATCH | /api/v1/vendors/{id} | Update a vendor by its id (partial update) |
| DELETE | /api/v1/vendors/{id} | Delete a vendor by its id |