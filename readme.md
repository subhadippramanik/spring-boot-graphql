# Intro
## What is `GraphQL`?
GraphQL is a data query language developed internally by Facebook in 2012 before being publicly released in 2015. It provides an alternative to REST and ad-hoc webservice architectures.
###### source: wikipedta

## `GraphQL` vs `REST`
There are many similarities and differences.. No one is clear winner over other one. The selection is entirely dependent on the usecase.
Here are some nice articles for reference:
[dev-blog.apollodata.com](https://dev-blog.apollodata.com/graphql-vs-rest-5d425123e34b), 
[howtographql.com](https://www.howtographql.com/basics/1-graphql-is-the-better-rest/)

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


Let's start with a simple entity `Employee`. In GraphQL schema we define a tpye for the entity which looks like 
```
type Employee {
  id: Int!
  name: String!
  email: String
}
```

### Add employee
```URL
HTTP POST: http://localhost:8181/demo
BODY: {"query":"mutation{addEmployee(name:\"James\", email:\"james@email.demo\"){id name email}}"}
```

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

### Update employee
```URL
HTTP POST: http://localhost:8181/demo
BODY: {"query":"mutation{updateEmployee(id:1, name:\"James\", email:\"james.ql@email.demo\"){id name email}}"}
```
### Mapping and relationship between Entities
So far we handled only one entity `Employee`. Now let's bring some reality here. Employee without a department? Umm! So we need `Department` - our another entity.
For the simplicity we assume the Department is very simple for now. It has an `ID`, a `name`, a `code` and a `manager` who is `Employee`.
Our `Department` type should look like 
```
type Department {
  id: Int!
  name: String!
  code: String!
  manager: Employee
}
```
As described, we have `manager` of type `Employee`..that's how we define the first relationship.
Now let's create a department. Till now James joined, but had no department..so we will assign him as the manager of the new department.
```URL
HTTP POST: http://localhost:8181/demo
BODY: {"query":"mutation{addDepartment(name:\"Admin\", code:\"001\", managerId:1){id name code}}"}
```
So along with the department `name` and `code` we here provide the `id` of James and `managerId` and the response is pretty nice and highly customisable..
```JSON
{
    "data": {
        "addDepartment": {
            "id": 1,
            "name": "Admin",
            "code": "001"
        }
    }
}
```
Now let's form `query` and see how we can customize the result as per our need.
First we get department details based on id
```URL
HTTP GET: http://localhost:8181/demo?query={ department(id:1){id, name, code} }
```
and the result is 
```JSON
{
    "data": {
        "department": {
            "id": 1,
            "name": "Admin",
            "code": "001"
        }
    }
}
```
Yes..that's what we added just now, but where is the mapped manager? Is it there? or lost?
To check that we again form the query. This time we need department details along with manager name and email.
```URL
HTTP POST: http://localhost:8181/demo?query={ department(id:1){id, name, code manager{name, email}} } 
```
See..we have added one more parameter in the query and mentioned eaxctly the properties we want from that type and result is 
```JSON
{
    "data": {
        "department": {
            "id": 1,
            "name": "Admin",
            "code": "001",
            "manager": {
                "name": "James",
                "email": "james.ql@email.demo"
            }
        }
    }
}
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
###### TODOs
- ###### <s>Split Query and Mutation classes -> resource wise</s>
- ###### One to Many relationship -> `Employee` has mulitple `Asset`s
- ###### Query to find reverse mapping -> Employee to Department