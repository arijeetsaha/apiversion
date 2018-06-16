# API versioning in Spring MVC

API versioning can be done using 3 mechanisms -

1. URL versioning -

a) curl -XGET http://localhost:8080/app/v1/person/1

{
  "id": "1",
  "name": "Romeo Gonzalves",
  "address": "Amsterdam, Netherlands"
}

b) curl -XGET http://localhost:8080/app/v2/person/1

{
  "id": "1",
  "name": {
    "firstName": "Romeo",
    "lastName": "Gonzalves"
  },
  "address": "Amsterdam, Netherlands"
}


2. Header -

a)  curl -H "Accept:application/app-v1+json" http://localhost:8080/app/person/1

{
  "id": "1",
  "name": "Romeo Gonzalves",
  "address": "Amsterdam, Netherlands"
}


b)  curl -H "Accept:application/app-v2+json" http://localhost:8080/app/person/1


{
  "id": "1",
  "name": {
    "firstName": "Romeo",
    "lastName": "Gonzalves"
  },
  "address": "Amsterdam, Netherlands"
}



3. Request Param - 


a)  curl -XGET http://localhost:8080/app/person/1?v=1

{
  "id": "1",
  "name": "Romeo Gonzalves",
  "address": "Amsterdam, Netherlands"
}

b)  curl -XGET http://localhost:8080/app/person/1?v=2


{
  "id": "1",
  "name": {
    "firstName": "Romeo",
    "lastName": "Gonzalves"
  },
  "address": "Amsterdam, Netherlands"
}
