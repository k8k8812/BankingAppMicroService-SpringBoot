# BankingAppMicroService-SpringBoot

a simple project to reproduce a banking system;
```java
This is a side project for the weekend using the knowledge I have learnt as a practice.

```

### 1. Spring Initialzr
```python
Dependencies are: 
Spring Web, Spring Data JPA, Lombok, Validation, MySQL Driver and Spring Boot DevTool.
```

```python
prior to April 22, 2022, the training has covered: 
```

- [x] Core Concept of Java, 
- [x] Spring Boot Framework
- [x] MicroServices
- [x] RESTful API
- [x] MySql Workbench
- [x] Junit Testing
- [ ] 
.... 
#### ## Materials to cover are:  ####
- [ ] Spring Security
- [ ] Exceptional Handling
- [ ] AWS


<br>

### 2. Project Entity Relationship 

```mermaid
erDiagram 
Customer ||--o{ Account: OneToMany
Account ||--|{ CheckingAccount : inherits
Account ||--|{ SavingAccount : inherits
```

<br>

### 3. Project Logs

```python
April 22 2022: started project. 
desgined ORM and ERdiagram; 
created models for Customer , Account , CheckingAccount , SavingAccount
connected to MySql and successfully created tables accordingly.
```


