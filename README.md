# Worlds Events API

#### This project created for learning Java nad Spring, i used Java 17 and Spring Boot 3.0.1 \
#### In this project you can send request and get random world event from chosen country and chosen tags, of course you must to chosen Period in "dd-MM-yyyy"  format \
#### Use Mysql Server to Database System

# Routes

# Tags Routes

## Get All Tags Route

`GET /tag`

### This Route will return you all tags from database

## Create Tag Route

`POST /tag`

### This Route will create new tag by body from request, there is example body:

```
{
    "tag": "String"
}
```

#### Field tag takes in String, that will be a name of tag in database

# Countries Routes

## Get All Countries Route

`GET /country`

### This Route will return you all countries from database

## Create Country Route

`POST /country`

### This Route will create new country by body from request, there is example body:

```
{
    "country": "String"
}
```

#### Field country takes in String, that will be a name of country in database

# Events Routes

## Create Event Route

`POST /addEvent`

### This Route will create new Event by body from request, there is example body:

```
{
    "date": "String",
    "description": "String",
    "linkToWiki": "String",
    "countryId": Long,
    "tagsIds": [Long, Long]
}
```

#### Date field takes in date when event happened, it has to be a String date by dd-MM-yyyy format.
#### Description field takes in descriptionof the event.
#### Link to wiki field will contain link to wikipedia of your event, it has to be a String.
#### Country Id, it's field takes number, specifically id of Country where event is happened, you can get countries id's from `GET /country` route. It cannot be 0 or less.
#### Tags Ids, this is array of tags ids that have to be in event which will be created, you can get tags id's from `GET /tag` route. Id's cannot be 0 or less.

## Get Random Event Route

`POST /event`

### This Route will return Event by body from request, there is example body:

```
{
    "countryId": Long,
    "dateAfter": "String",
    "dateBefore": "String",
    "tags": [Long, Long]
}
```

#### Country Id field takes in Id fo country where have to event happened (if you write 0 there, you will get event from random country). You can get countries id's from `GET /country` route.
#### Date After field takes the start of period when event was happened.
#### Date Before field takes the end of period when event was happened.
#### Tags Ids, this is array of tags ids that have to be in event which will be returned, you can get tags id's from `GET /tag` route. Id's cannot be 0 or less, but if you send empty array it return event with random tags.