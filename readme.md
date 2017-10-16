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
HTTP GET http://localhost:8181/demo?query={ employees(email:"james@email.demo"){id, name, email}}
```

### Get employees by name and email
```URL
HTTP GET http://localhost:8181/demo?query={ employees(name:"James", email:"james@email.demo"){id, name, email}}
```

### Get employee by id
```URL
HTTP GET http://localhost:8181/demo?query={ employee(id:1){id, name, email}}
```

### Add employee
```URL
HTTP POST: http://localhost:8181/demo
BODY: {"query":"mutation{addEmployee(name:\"James\", email:\"james@email.demo\"){id name email}}"}
```

### Update employee
```URL
HTTP POST: http://localhost:8181/demo
BODY: {"query":"mutation{updateEmployee(id:1, name:\"James\", email:\"james@email.demo\"){id name email}}"}
```

# Using Project lombok
The type class `Employee` is a typical POJO with `@Entity` annotation.
```java
@Entity
public class Employee {

	private int id;

	private String name;

	private String email;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
```
So to reduce the overhead of writing and maintaining `Setter`, `Getter`, `toString`, `hashCode` and `equals` method we have used `lombok` and the same class is now significantly smaller and cleaner.
```java
@Entity
@Data
public class Employee {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String email;
}
```

#### more features coming soon...