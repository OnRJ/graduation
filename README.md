# Graduation
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/d9da16792c3e4fa7b9fefe779f1ce9e0)](https://www.codacy.com/gh/OnRJ/graduation/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=OnRJ/graduation&amp;utm_campaign=Badge_Grade)
[![Build Status](https://api.travis-ci.com/OnRJ/graduation.svg?branch=main)](https://travis-ci.com/OnRJ/graduation.svg?branch=main)


##Get all restaurant meals
Access for roles: ADMIN, USER
Request type: GET
Example request: http://localhost:8080/rest/meals/restaurantId=100002

Attribute | Data type | Size | Required | Description
--------- | --------- | ---- | -------- | -----------
restaurantId | string | 10 | yes | restaurant id


##Create meal for restaurant
Access for roles: ADMIN
Request type: POST
Example request: http://localhost:8080/rest/meals
{
    "name": "Meal",
    "price": "19.2",
    "restaurantId": "100002"
}

Attribute | Data type | Size | Required | Description
--------- | --------- | ---- | -------- | -----------
name | string | 2-100 | yes | name meal
price | String | - | yes | price meal
restaurantId | string | 10 | yes | restaurant id