Get all employees
```URL
HTTP GET: http://localhost:8181/graphql?query={ allEmployees{id, name, email}}
```

Get employee by id
```URL
HTTP GET http://localhost:8181/graphql?query={ employee(id:1){id, name, email}}
```

Add/Update employee
```URL
HTTP POST: http://localhost:8181/graphql
BODY: {"query":"mutation{addEmployee(id:1, name:\"James\", email:\"james@email.demo\"){id name email}}"}