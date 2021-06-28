# ReadMe

Implementation description for junior homework task.

# REST API

The REST API to the example app is described below.


---

## Get list of Books

### Request

`GET /book`

     http://localhost:8080/book

### Response body

    [
        {
            "id": 0,
            "name": "name",
            "author": "author2",
            "category": "category2",
            "language": "LT",
            "publicationDate": "2000",
            "isbn": "isbn",
            "guid": "guid"
        },
        {
            "id": 1,
            "name": "name2",
            "author": "author2",
            "category": "category",
            "language": "EN",
            "publicationDate": "2020",
            "isbn": "isbn2",
            "guid": "guid2"
        },
        {
            "id": 2,
            "name": "name2",
            "author": "author",
            "category": "category2",
            "language": "EN",
            "publicationDate": "2020",
            "isbn": "isbn2",
            "guid": "guid2"
        }
    ]

---

## Create a new Book

### Request

`POST /add`

    'Accept: application/json' -d http://localhost:8080/book/add

    {
        "name": "testName",
        "author": "testAuthor",
        "category": "testCategory",
        "language": "TEST",
        "publicationDate": 2019,
        "isbn": "testIsbn",
        "guid": "testGuid"
    }

### Response Body

    Status: 200 OK

---

## Take a Book from the Library

### Request

`GET /take/userId/bookId/periodFrom/periodTo`

    http://localhost:8080/book/take/0/0/2021-06-22/2021-07-03

### Response Body

    Status: 200 OK

---

## Get a Book by GUID

### Request

`GET /guid`

    http://localhost:8080/book/guid2

### Response Body

    [
        {
            "id": 1,
            "name": "name2",
            "author": "author2",
            "category": "category",
            "language": "EN",
            "publicationDate": "2020",
            "isbn": "isbn2",
            "guid": "guid2"
        }
    ]

---

## Get list of all Books. Add the following parameters to filter the data

### Request

`GET /filter/parameter/filterBy`

    http://localhost:8080/book/filter/name/name2

### Response Body

    [
        {
            "id": 1,
            "name": "name2",
            "author": "author2",
            "category": "category",
            "language": "EN",
            "publicationDate": "2020",
            "isbn": "isbn2",
            "guid": "guid2"
        }
    ]

---

## Delete a Book

### Request

`DELETE /id`

    http://localhost:8080/book/2

### Response Body

     Status: 200 OK

---