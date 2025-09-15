1. What is an API?
API stands for Application Programming Interface.
It’s a way for two software applications to talk to each other.

Think of it as a menu in a restaurant:
The menu = API → shows what you can order (functions, data).
The kitchen = internal system → does the work.
You don’t know how the food is cooked; you just use the menu.

👉 Example:
A weather app calls an API from a weather service.
The API gives back the temperature, humidity, forecast, etc.


2. What is a RESTful API?  (Stateless API):

REST = Representational State Transfer (a set of rules for building APIs).
A RESTful API is an API that follows these REST rules.
It uses HTTP methods (the same ones browsers use):

GET → Read data
POST → Create data
PUT/PATCH → Update data
DELETE → Remove data

👉 Example: In an eCommerce API:
GET /products → fetch all products
GET /products/10 → fetch product with ID 10
POST /products → add a new product
PUT /products/10 → update product with ID 10
DELETE /products/10 → remove product with ID 10

3. HTTP OR HTTPS (HTTP + SSL Certificate)  URL :
URL : URL = Uniform Resource Locator (address of a resource on the web).

https://example.com/users/123?active=true
https → protocol
example.com → domain
/users/123 → path (resource: user with ID 123)
?active=true → query parameters (extra filters/options)

HTTP Methods
Used in RESTful APIs to define the action (nature of request):

Method	Meaning	Example
GET	Fetch/read data	GET /products → get all products
POST	Create new data	POST /products → add a new product
PUT	Update/replace data (entire object)	PUT /products/10 → replace product with ID 10
PATCH	Update partially	PATCH /products/10 → update only price of product 10
DELETE	Remove data	DELETE /products/10 → delete product with ID 10

3. HTTP Status Codes

These tell the client whether the request worked or not:

3.1. Informational responses (1XX)

100 Continue -> indicates that the client should continue the request or ignore the response if the request is already finished
101 Switching Protocols -> This code is sent in response to an Upgrade request header from the client and indicates the protocol the server is switching to.
102 Processing Deprecated -> This code was used in WebDAV contexts to indicate that a request has been received by the server, but no status was available at the time of the response.

3.2. ✅ Success (2xx)

200 OK → Request successful (GET, PUT, DELETE).
201 Created → Resource created (POST).
202 Accepted -> Request accepted 
204 No Content → Success, but no change data to return.

3.3. Redirection messages
301 Moved Permanently : The URL of the requested resource has been changed permanently.

3.4 ❌ Client Errors (4xx)

400 Bad Request → Invalid input.
401 Unauthorized → Not logged in.
403 Forbidden → Logged in but not allowed.
404 Not Found → Resource doesn’t exist.

3.5 🚨 Server Errors (5xx)

500 Internal Server Error → Something went wrong on server.
501 Not Implemented -> The request method is not supported by the server
503 Service Unavailable → Server is down or overloaded.

Old Approach : (Servlet + Spring MVC)
http://localhost:8080/getUsers
http://localhost:8080/createUsers
http://localhost:8080/deleteUsers
http://localhost:8080/updateUsers
http://localhost:8080/activateUsers

Uniform URL Design: (HTTP URL + HTTP Methods)

GET -> http://localhost:8080/users   -> GET ALL users
POST -> http://localhost:8080/users  -> Add user 
PUT ->  http://localhost:8080/users  -> Update user
DELETE ->  http://localhost:8080/users  -> Delete user
GET ->  http://localhost:8080/users/{id}  -> Get one user

Rules :
✅ Use nouns, not verbs → /users, not /getUsers
✅ Use plural nouns → /products, /orders
✅ Use resource hierarchy → /users/{id}/orders
✅ Use query parameters for filters/search → /products?category=mobile&price=1000
✅ Use HTTP methods for actions (don’t put actions in URL)
✅ Use lowercase + hyphens for readability → /product-reviews

{id} -> Path Varaible  -> @PathVaraible
?  -> Query Paramters -> @RequestParameter  -> ?category=mobile&price=1000

Examples (E-Commerce API)
/users/{id}/orders  -> get all order for a user id
/users/{id}/address/1  -> Get 1st address of user id
/orders/{id}/reviews -> /orders/10/reviews
/orders/{id}/reviews -> /orders/10/reviews
/orders/{id}/reviews/{userid} -> /orders/10/reviews/45

✅ Filtering, Sorting, Pagination
GET /products?category=electronics&brand=apple
GET /products?sort=price&order=asc
GET /products?page=2&limit=20





