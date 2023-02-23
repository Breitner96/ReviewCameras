# review-cameras-ms

Micro-service about Reviews Cameras. This API was released with de domain ***LocalHost***.

>  #aws #rest #java #reviews-cameras
---
## Content
- [Description](#description)
- [Detail of Functions](#detail-of-functions)
- [Architecture](#architecture)
- [Built With](#built-with)
- [Development](#development)
- [Security](#security)
- [Endpoints](#endpoints)
- [Authors](#authors)
- [License](#license)
---
## Description

API was released with de domain ***LocalHost***

## Detail of Functions

The following are the functionalities present in this repository:

#### POST/ /api/v1/tiendabreit/save/author

Mandatory headers:

Grades:

##### REQUEST
```
{
    "autorDto":{
        "nombre":"breitner",
        "telefono":"965668",
        "email":"breitner@gmail.com",
        "pais":"Colombia"
    }
}

```

##### RESPONSE OK
```
{
  "autorDto": { 
    "idAutor": 6,
    "nombre": "breitner",
    "email": "breitner@gmail.com",
    "pais": "Colombia"
  }
}
```


##### RESPONSE ERROR
```
{
    "timestamp": "2023-02-23T03:38:52.982+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "trace": ""
    "message": "author already exists"
    "path": "/api/v1/tiendabreit/save/author"
}
```

#### GET/ /api/v1/tiendabreit/author

Mandatory headers:

Grades:

##### REQUEST
```
localhost:8080/api/v1/tiendabreit/author

```

##### RESPONSE OK
```
[
    {
        "autorDto": {
            "idAutor": 1,
            "nombre": "Breitner Mora",
            "email": "breitner@gmail.com",
            "pais": "Colombia"
        }
    },
    {
        "autorDto": {
            "idAutor": 2,
            "nombre": "Paula Ospina",
            "email": "paula@gmail.com",
            "pais": "Colombia"
        }
    }
]
```


##### RESPONSE ERROR
```
[]
```

#### GET/ /api/v1/tiendabreit/product

Mandatory headers:

Grades:

##### REQUEST
```
localhost:8080/api/v1/tiendabreit/product

```

##### RESPONSE OK
```
[
    {
        "productoDto": {
            "idProducto": 1,
            "nombre": "SAMSUNG TV 4K",
            "marca": "SAMSUNG",
            "precio": 2000000.56,
            "caracteristica": [
                {
                    "idCaracteristica": 1,
                    "nombre": "Dimensiones y definicion",
                    "detalles": "Televisor ultimo modelo, 32 pulgadas, definicion 4K"
                }
            ]
        }
    },
    {
        "productoDto": {
            "idProducto": 2,
            "nombre": "SONIC 5YD33",
            "marca": "SONIC",
            "precio": 5000000.8,
            "caracteristica": [
                {
                    "idCaracteristica": 2,
                    "nombre": "Gama",
                    "detalles": "Equipo de sonido con la utima tegnologia 5g"
                }
            ]
        }
    }
]
```


##### RESPONSE ERROR
```
[]
```

#### POST/ /api/v1/tiendabreit/save/review

Mandatory headers:

Grades:

##### REQUEST
```
{
    "reviewDto":{

        "titulo":"Capacidad televisor",
        "contenido":"No recomiendo este televisor tiene muy mala señal",
        "idAutor":2,
        "idProducto":1

    }
}

```

##### RESPONSE OK
```
{
    "reviewDTO": {
        "idReview": 3,
        "titulo": "Capacidad televisor",
        "contenido": "No recomiendo este televisor tiene muy mala señal",
        "autorDto": {
            "idAutor": 2,
            "nombre": "Paula Ospina",
            "email": "paula@gmail.com",
            "pais": "Colombia"
        },
        "producto": {
            "idProducto": 1,
            "nombre": "SAMSUNG TV 4K",
            "marca": "SAMSUNG",
            "precio": 2000000.56,
            "caracteristica": [
                {
                    "idCaracteristica": 1,
                    "nombre": "Dimensiones y definicion",
                    "detalles": "Televisor ultimo modelo, 32 pulgadas, definicion 4K"
                }
            ]
        }
    }
}
```


##### RESPONSE ERROR
```
{
    "timestamp": "2023-02-23T03:38:52.982+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "trace": ""
    "message": "Product does not exist"
    "path": "/api/v1/tiendabreit/save/review"
}
```

#### GET/ /api/v1/tiendabreit/review

Mandatory headers:

Grades:

##### REQUEST
```
localhost:8080/api/v1/tiendabreit/review

```

##### RESPONSE OK
```
[
    {
        "reviewDTO": {
            "idReview": 1,
            "titulo": "Uso del televisor despues de un año",
            "contenido": "El televisor se encuentra en optimas condiciones",
            "autorDto": {
                "idAutor": 1,
                "nombre": "Breitner Mora",
                "email": "breitner@gmail.com",
                "pais": "Colombia"
            },
            "producto": {
                "idProducto": 1,
                "nombre": "SAMSUNG TV 4K",
                "marca": "SAMSUNG",
                "precio": 2000000.56,
                "caracteristica": [
                    {
                        "idCaracteristica": 1,
                        "nombre": "Dimensiones y definicion",
                        "detalles": "Televisor ultimo modelo, 32 pulgadas, definicion 4K"
                    }
                ]
            }
        }
    },
    {
        "reviewDTO": {
            "idReview": 2,
            "titulo": "Capacidad televisor",
            "contenido": "No recomiendo este televisor tiene muy mala señal",
            "autorDto": {
                "idAutor": 2,
                "nombre": "Paula Ospina",
                "email": "paula@gmail.com",
                "pais": "Colombia"
            },
            "producto": {
                "idProducto": 1,
                "nombre": "SAMSUNG TV 4K",
                "marca": "SAMSUNG",
                "precio": 2000000.56,
                "caracteristica": [
                    {
                        "idCaracteristica": 1,
                        "nombre": "Dimensiones y definicion",
                        "detalles": "Televisor ultimo modelo, 32 pulgadas, definicion 4K"
                    }
                ]
            }
        }
    }
]
```


##### RESPONSE ERROR
```
[]
```

---

## Architecture
Description of the architecture

## Built With

The code was implemented with Java 11 y Gradle 7.5 using the following libraries:

- Lombok - To simplify the creation of an object's means of accessing data
- Spring Data JPA - To simplify the persistence of objects in the database
- MapStruct - For mapping between Java objects
- h2 - To simulate the database
- swagger - Documentation

## Development
1. Install Java 11 and an IDE to development like Eclipse or IntelliJ.
2. Clone the repository.
3. Allow building the project with gradle.
4. Initialize the project
5. Open http://localhost:8080/swagger-ui/ to see the list of apis

To run the unit tests:
1. Run the project from test in gradle.

## Security

---

## Endpoints

- **DEV**
  - API:  http://localhost:8080/

---

## Authors

The team involved in the implementation of these components is detailed below:

- Development Team: Breitner Mora
- Technical Leader: Breitner Mora
- IT Architect: Breitner Mora

---

## License
- Copyright 2023 ©