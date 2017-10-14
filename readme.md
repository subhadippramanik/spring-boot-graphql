# Intro

This is a sample project using `GraphQL` with `Spring Boot`.

# Getting started

```
mvn clean install
```
 and then run 

 ```
 mvn spring-boot:run
 ```

 This runs the applicaiton which is accessible at `http://localhost:8181/demo`. The endpount `/demo` can be changed through the configuration in `application.yml` or `application.properites`. Same with the port `8181`.


### Get all employees
```URL
HTTP GET: http://localhost:8181/demo?query={ employees{id, name, email}}
```

### Get emplyees by name
```URL
HTTP GET http://localhost:8181/demo?query={ employees(name:"James"){id, name, email}}
```

### Get employees by email
```URL
HTTP GET http://localhost:8181/demo?query={ employees(name:"James"){id, name, email}}
```

### Get employees by name and email
```URL
HTTP GET http://localhost:8181/demo?query={ employees(name:"James", email:"james@email.demo"){id, name, email}}
```

### Get employee by id
```URL
HTTP GET http://localhost:8181/demo?query={ employee(id:1){id, name, email}}
```

### Add/Update employee
```URL
HTTP POST: http://localhost:8181/demo
BODY: {"query":"mutation{addEmployee(id:1, name:\"James\", email:\"james@email.demo\"){id name email}}"}
```
#### more features coming soon...