# 📘 Phrase API – Spring Boot CRUD

This is a sample project that implements a REST API in Java using Spring Boot. The application allows you to manage a collection of phrases with their authors, supporting CRUD operations (Create, Read, Update, Delete).

---

## 🚀 Technologies Used

- Java 17
- Sprint Boot 3.5.0
- Spring Web
- Spring Data JPA
- MySQL Driver
- Maven

---

## 🗂️ Project Structure

The project follows a 3-layer architecture:


```
.
├── .mvn/
│   └── wrapper/
│       └── maven-wrapper.properties
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── phrase/
│   │   │               ├── PhraseApplication.java
│   │   │               ├── controllers/
│   │   │               │   └── PhraseController.java
│   │   │               ├── models/
│   │   │               │   └── Phrase.java
│   │   │               ├── repositories/
│   │   │               │   └── PhraseRepository.java
│   │   │               └── services/
│   │   │                   └── PhraseService.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── phrase/
│                       └── PhraseApplicationTests.java
├── .gitattributes
├── .gitignore
├── class_diagram.puml
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

---

## 📄 Data Model

The `Phrase` entity has the following fields:

```java
private Long id;
private String text;
private String author;
```

## 📮 Available Endpoints
| HTTP Method | URL               | Description               |
| ----------- | ----------------- | ------------------------- |
| GET         | `/phrases`        | Get all phrases           |
| GET         | `/phrases/{id}`   | Get a phrase by its ID    |
| POST        | `/phrases/create` | Create a new phrase       |
| PUT         | `/phrases/{id}`   | Update an existing phrase |
| DELETE      | `/phrases/{id}`   | Delete a phrase           |

## 🧪 Postman Usage Example

### Create a Phrase

#### Request
```http
POST /phrases/create
Content-Type: application/json
```

```JSON
{
"text": "Stay hungry, stay foolish.",
"author": "Steve Jobs"
}
```
## 📄 Class Diagram

A class diagram of the project is available in `class_diagram.puml`. This diagram shows the classes, their methods, fields, and relationships.

## ✍️ Author
- [Ana Carina](https://github.com/acpp2510)



