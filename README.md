# Reading Is Good

'Reading is good' is a spring boot rest app that allows you the following operations for the book tracking.

• Registering New Customer

• Placing a new order

• Tracking the stock of books

• List all orders of the customer

• Viewing the order details

• Query Monthly Statistics


## How To Run

Make sure that you have installed the followings: Java 11, Maven and Docker.

First clone the project to your local.

```bash 
  https://github.com/tuncayemekci/reading-is-good.git
```

Then open up the terminal and cd into root directory of the project

```bash 
  cd reading-is-good
```

After that run the docker command below

```bash 
  docker-compose up -d
```

Finally app should runs at localhost:8080 and you can access the mongo-express at localhost:8081.

## Rest API Guide

## customer-controller

#### getAllCustomers
```http
  GET /api/v1/customer/all
```

#### addCustomer
```http
  POST /api/v1/customer/add
```

    {
        "firstName": "tuncay",
        "lastName": "emekci",
        "email": "tuncayemekci@gmail.com",
        "password": "1234"
    }


#### getOrdersOfCustomerByPagination
```http
  GET /api/v1/customer/{customerId}/orders?page=0&size=1
```


## book-controller

#### getAllBooks
```http
  GET /api/v1/book/all
```


#### addBook
```http
  POST /api/v1/book/add
```

    {
        "name": "The Lord of the Rings",
        "author": "J. R. R. Tolkien",
        "price": 25.0,
        "stock": 100
    }


#### updateBookStock
```http
  PUT /api/v1/book/updateStock
```

    {
        "name": "The Lord of the Rings",
        "quantity": 10
    }


## order-controller

#### getAllOrders
```http
  GET /api/v1/order/all
```

#### addOrder
```http
  POST /api/v1/order/add
```
    {
        "email": "tuncayemekci@gmail.com",
        "details": 
            [
                {
                    "bookName": "Harry Potter",
                    "quantity": 2
                },
                {
                    "bookName": "The Lord of the Rings",
                    "quantity": 3
                }
            ] 
    }

#### getOrderById
```http
  GET /api/v1/order/{customerId}
```


#### getOrdersByDateInterval
```http
  GET /api/v1/order/interval?startDate=2022-01-11&endDate=2022-01-15
```


## statistic-controller

#### getMonthlyOrderStatistics
```http
  GET /api/v1/statistic/monthly/{customerId}
```