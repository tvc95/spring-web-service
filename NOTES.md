# RESTful Web Services

## Social Media Application

### Routes
- Retrieve all Users: ```GET /users```
- Create a new User:  ```POST /users```
- Retrieve one User:  ```GET /users/{id}```
- Delete an user:     ```DELETE /users/{id}```

- Retrieve all posts for a User: ```GET /users/{id}/posts```
- Create a new post for a User: ```POST /users/{id}/posts```
- Retrieve details of a post: ```GET /users/{id}/posts/{post_id}```

## Questions
- What is dispatcher service?
- Who is configuring dispatcher servlet?
- What does the dispatcher servlet do?
- How does the HelloWorldBean object get converted to JSON?
- Who is configuring the error mapping?

Spring boot autoconfiguration

Jackson to Object mapper -> does the conversion from JSON to Beans and Beans to JSON.

dispatcherServlet