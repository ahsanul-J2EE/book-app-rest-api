# API Documentation

## Authentication

- **Login**
  - Endpoint: `POST /auth/login`
  - Description: Authenticates a user and generates an authentication token.
  - Request Body:
    - email: (string) The user's email address.
    - password: (string) The user's password.
  - Response Body:
    - token: (string) Authentication token.

- **Register**
  - Endpoint: `POST /register`
  - Description: Registers a new user.
  - Request Body:
    - username: (string) The desired username.
    - email: (string) The user's email address.
    - password: (string) The user's password.

## Books

- **Create a Book**
  - Endpoint: `POST /books/create`
  - Description: Creates a new book.
  - Request Body:
    - title: (string) The title of the book.
    - author: (string) The author of the book.
    - description: (string) The description of the book.

- **Update a Book**
  - Endpoint: `PUT /books/update/{bookId}`
  - Description: Updates an existing book.
  - Path Parameter:
    - bookId: (string) The ID of the book to be updated.
  - Request Body:
    - title: (string) The updated title of the book.
    - author: (string) The updated author of the book.
    - description: (string) The updated description of the book.

- **Delete a Book**
  - Endpoint: `DELETE /books/delete/{bookId}`
  - Description: Deletes an existing book.
  - Path Parameter:
    - bookId: (string) The ID of the book to be deleted.

- **Get All Books**
  - Endpoint: `GET /books/all`
  - Description: Retrieves all books.

- **Get Books by Author**
  - Endpoint: `GET /books/author/{author_name}`
  - Description: Retrieves books written by a specific author.
  - Path Parameter:
    - author_name: (string) The name of the author.

- **Get Book by Author and Title**
  - Endpoint: `GET /books/{author_name}/{book_name}`
  - Description: Retrieves a book by its author and title.
  - Path Parameters:
    - author_name: (string) The name of the author.
    - book_name: (string) The title of the book.
