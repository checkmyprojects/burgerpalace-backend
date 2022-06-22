# BurgerPalace 🚀

This is our event management app. Admins can add/remove/edit events and users can subscribe/unsubscribe to attend them.

**Link to project:** 

FrontEnd: https://github.com/checkmyprojects/burgerpalace-frontend

Backend (this one): https://github.com/checkmyprojects/burgerpalace-backend
## How It's Made:
**Tech used 🛠️:** Java, Spring Boot, JWT, Spring Security, MySQL

Our backend allows users to register and order products.

Frontend uses angular and with JWT we do the authentication and authorization.

All services are tested.

## Team
---

Hi there!

We are a group of enthusiastic coders excited about web-designing. On our latest project we have created a web-page for an online food order service.

- Iris: https://github.com/irisvilaseca Scrum Master/developer
- Jesús: https://github.com/checkmyprojects Developer
- Carlos: https://github.com/CarlitosHunter Product Owner/developer


## Lessons Learned:
---

When deploying to heroku we had to move from MySQL to Postgres.

When building JWT token, we missed a few fields missing that we needed on our frontend so we had to do that later.

A good planning helps speed things up.


# API Documentation

### Base Path: /api
## Users
### Return a list of users with roles and orders
```GET: /users```
```json
[
    {
        "id": 1,
        "name": "A registered user",
        "address": "My address",
        "username": "user@mail.com",
        "phone": "123321123",
        "password": "$2y$13$pjkCrATlcVzhRDl0KlgdZ.cHZQTsOK9Ig3kF/BmtXxjQ4eC90m32s",
        "roles": [
            {
                "id": 2,
                "name": "ROLE_ADMIN"
            }
        ],
        "order": [
            {
                "id": 29,
                "quantity": 1,
                "uuid": "cc57007c-2c43-4b8c-a711-1e6fba2b1200",
                "food": {
                    "id": 16,
                    "name": "Coca Cola",
                    "type": "drink",
                    "ingredients": "Cola",
                    "vegan": false,
                    "alergies": "none",
                    "price": 2.0,
                    "img": "assets/img/product/drink-cocacola.png"
                }
            },
            {
                "id": 30,
                "quantity": 1,
                "uuid": "cc57007c-2c43-4b8c-a711-1e6fba2b1200",
                "food": {
                    "id": 14,
                    "name": "Double Burger",
                    "type": "burger",
                    "ingredients": "Double burger",
                    "vegan": false,
                    "alergies": "none",
                    "price": 30.0,
                    "img": "assets/img/product/burger-doubleburger.png"
                }
            }
        ]
    }
]
```
### Return a user by {id} with roles and orders
```GET: /users/{id}```
```json
{
    "id": 1,
    "name": "A registered user",
    "address": "My address",
    "username": "user@mail.com",
    "phone": "123321123",
    "password": "$2y$13$pvhCrATlcVzhRDl0KlgdZ.cHZQTsOK9Ig3kF/AmtXxjQ4eC90m32s",
    "roles": [
        {
            "id": 2,
            "name": "ROLE_ADMIN"
        }
    ],
    "order": [
        {
            "id": 29,
            "quantity": 1,
            "uuid": "cc57007c-2c43-4b8c-a711-1e6fba2b1200",
            "food": {
                "id": 16,
                "name": "Coca Cola",
                "type": "drink",
                "ingredients": "Cola",
                "vegan": false,
                "alergies": "none",
                "price": 2.0,
                "img": "assets/img/product/drink-cocacola.png"
            }
        }
    ]
}
```
### Return the authed user username
```GET: /users/whoami```
```json
"test@mail.com"
```
### Create new user
```POST: /users/save```

body: JSON
```json
{
    "name": "test",
    "address": "test street",
    "username": "test@mail.com",
    "phone": "123321123",
    "password": "password"
}
```
### Create new role
```POST: /role/save```

body: JSON
```json
{
    "name": "ROLE_ADMIN",
}
```
### Add role to user
```POST: /role/addToUser```

body: JSON
```json
{
    "username": "test@mail.com",
    "rolename": "ROLE_ADMIN",
}
```

### User login returns JWT token
```POST: /api/login```

header: x-www-form-urlencoded
```json
KEY             VALUE
________        _____________

username        test@mail.com
password        password
```

Returns:

```json
{
    "access_token": "pbkBtcWlsLmNvbSIsInJvbGVzIjpbIlJPTEVfQURNSU4i.eyJzdpbkBtcWlsLmNvbSIsInJvbGVzIjpbIlJPTEVfQURNSU4iInJvbGVzIjpbIlJPTEVfQURNSU4i2xvY2FsaG9zdDo4MDgwL2FwaS9sb2dpbiIsImpbkBtcWlsLmNvbSIsInJvbGVzIjpbIlJPTEVfpbkBtcWlsLmNvbSIsInJvbGVzIjpbIlJPTEVfQURNSU4igFyieDP8",
    "refresh_token": "pbkBtcWlsLmNvbSIsInJvbGVzIjpbIlJPTEVfQURNSU4i.eyJzdpbkBtcWlsLmNvbSIsInJvbGVzIjpbIlJPTEVfQURNSU4iInJvbGVzIjpbIlJPTEVfQURNSU4i2xvY2FsaG9zdDo4MDgwL2FwaS9sb2dpbiIsImpbkBtcWlsLmNvbSIsInJvbGVzIjpbIlJPTEV",
    "roles": "ROLE_ADMIN",
    "username": "test@mail.com"
}
```

### Refresh user token
```GET: /token/refresh```

header: Authorization

```json
KEY                 VALUE
________            __________________________
Authorization       "Bearer refresh_token_key"
```
## Food
### Return all food items
```GET: /food```
```json
[
    [
    {
        "id": 4,
        "name": "Cangreburger",
        "type": "burger",
        "ingredients": "Carne de cangrejo",
        "vegan": false,
        "alergies": "cangrejo",
        "price": 15.0,
        "img": "assets/img/product/burger-cangreburger.png"
    },
    {
        "id": 5,
        "name": "Eggburger",
        "type": "burger",
        "ingredients": "egg",
        "vegan": false,
        "alergies": "Egg",
        "price": 10.0,
        "img": "assets/img/product/burger-eggburger.png"
    }
]
```
### Return food by id
```GET: /food/{id}```
```json
[
    [
    {
        "id": 4,
        "name": "Cangreburger",
        "type": "burger",
        "ingredients": "Carne de cangrejo",
        "vegan": false,
        "alergies": "cangrejo",
        "price": 15.0,
        "img": "assets/img/product/burger-cangreburger.png"
    }
]
```
### Return food by category
```GET: /food/filter/{categoryName}```

(/food/filter/drink)
```json
[
    {
        "id": 16,
        "name": "Coca Cola",
        "type": "drink",
        "ingredients": "Cola",
        "vegan": false,
        "alergies": "none",
        "price": 2.0,
        "img": "assets/img/product/drink-cocacola.png"
    },
    {
        "id": 17,
        "name": "Fanta Naranja",
        "type": "drink",
        "ingredients": "Fanta",
        "vegan": false,
        "alergies": "none",
        "price": 2.0,
        "img": "assets/img/product/drink-fanta-orange.png"
    }
]
```
### Add new food
```POST: /food/save```
```json
{
        "name": "Classic grilled sandwich",
        "type": "sandwich",
        "ingredients": "Ham, tomato",
        "vegan": false,
        "alergies": "none",
        "price": 5.0,
        "img": "assets/img/product/sandwich-classic-grilled.png"
}
```
Returns:
```json
{
        "name": "Classic grilled sandwich",
        "type": "sandwich",
        "ingredients": "Ham, tomato",
        "vegan": false,
        "alergies": "none",
        "price": 5.0,
        "img": "assets/img/product/sandwich-classic-grilled.png"
}
```
### Edit food
```PUT: /food/edit```
```json
{
        "id": 30,
        "name": "Classic grilled sandwich 2",
        "type": "sandwich",
        "ingredients": "Ham, tomato",
        "vegan": false,
        "alergies": "none",
        "price": 5.0,
        "img": "assets/img/product/sandwich-classic-grilled.png"
}
```
Returns:
```json
{
        "id": 30,
        "name": "Classic grilled sandwich 2",
        "type": "sandwich",
        "ingredients": "Ham, tomato",
        "vegan": false,
        "alergies": "none",
        "price": 5.0,
        "img": "assets/img/product/sandwich-classic-grilled.png"
}
```
### Delete food by id
```DELETE: /food/delete/{id}```

(/food/delete/3)



## Orders
### Return all orders
```GET: /orders```
```json
[
    {
        "id": 29,
        "quantity": 1,
        "uuid": "cc57007c-2c43-4b8c-a711-1e6fba2b1200",
        "food": {
            "id": 16,
            "name": "Coca Cola",
            "type": "drink",
            "ingredients": "Cola",
            "vegan": false,
            "alergies": "none",
            "price": 2.0,
            "img": "assets/img/product/drink-cocacola.png"
        }
    },
    {
        "id": 30,
        "quantity": 1,
        "uuid": "cc57007c-2c43-4b8c-a711-1e6fba2b1200",
        "food": {
            "id": 14,
            "name": "Double Burger",
            "type": "burger",
            "ingredients": "Double burger",
            "vegan": false,
            "alergies": "none",
            "price": 30.0,
            "img": "assets/img/product/burger-doubleburger.png"
        }
    }
]
```
### Return user with id {id} orders list
```GET: /orders/{id}```
```json
[
    {
        "id": 29,
        "quantity": 1,
        "uuid": "cc57007c-2c43-4b8c-a711-1e6fba2b1200",
        "food": {
            "id": 16,
            "name": "Coca Cola",
            "type": "drink",
            "ingredients": "Cola",
            "vegan": false,
            "alergies": "none",
            "price": 2.0,
            "img": "assets/img/product/drink-cocacola.png"
        }
    },
    {
        "id": 30,
        "quantity": 1,
        "uuid": "cc57007c-2c43-4b8c-a711-1e6fba2b1200",
        "food": {
            "id": 14,
            "name": "Double Burger",
            "type": "burger",
            "ingredients": "Double burger",
            "vegan": false,
            "alergies": "none",
            "price": 30.0,
            "img": "assets/img/product/burger-doubleburger.png"
        }
    }
]
```
### Create orders for authenticated user (send item with quantity when doing checkout)
Can send a list of quantity + food and all of them will have the same unique uuid to know that they come from the same checkout.

```POST: /orders/checkout```
```json
[
    {
        "quantity": 2,
        "food": {
            "id": 14,
            "name": "Double Burger",
            "type": "burger",
            "ingredients": "Double burger",
            "vegan": false,
            "alergies": "none",
            "price": 30.0,
            "img": "assets/img/product/burger-doubleburger.png"
        }
    }
]
```
