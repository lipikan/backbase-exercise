# backbase-exercise
backbase-exercise is spring-java web MVC project:
1) This application has two REST API services:
ATM Locator
```
This service lists down all the ATM locations for a given city

URI Endpoint:http://host:port/backbase-exercise/api/atmLocator?city={name-of-the-city}
```
Example:
```
http://localhost:8080/backbase-exercise/api/atmLocator?city=Heerlen

Response:
{
    "cityName": "Heerlen",
    "banks": [
        {
            "bankName": "ING",
            "atmAddress": [
                {
                    "street": "Homerusplein",
                    "houseNumber": "9",
                    "postalCode": "6411 AW",
                    "geoLocation": {
                        "lat": "50.886494",
                        "lng": "5.969686"
                    }
                },
                {
                    "street": "In de Cramer",
                    "houseNumber": "142",
                    "postalCode": "6412 PM",
                    "geoLocation": {
                        "lat": "50.89939",
                        "lng": "5.945195"
                    }
                },
                {
                    "street": "Schandelerboord",
                    "houseNumber": "25",
                    "postalCode": "6415 AA",
                    "geoLocation": {
                        "lat": "50.890832",
                        "lng": "5.984737"
                    }
                },
                {
                    "street": "Groeët Genhei",
                    "houseNumber": "24",
                    "postalCode": "6413 GN",
                    "geoLocation": {
                        "lat": "50.917146",
                        "lng": "5.956317"
                    }
                },
                {
                    "street": "Honigmannstraat",
                    "houseNumber": "44",
                    "postalCode": "6411 LM",
                    "geoLocation": {
                        "lat": "50.8885169",
                        "lng": "5.9753429"
                    }
                },
                {
                    "street": "Saroleastraat",
                    "houseNumber": "51A",
                    "postalCode": "6411 LR",
                    "geoLocation": {
                        "lat": "50.887998",
                        "lng": "5.97812"
                    }
                }
            ]
        }
    ]
}

```
Header Parameters
```
To access the REST API there is a basic Authorization required:
User Name : admin
Password : admin123
If you are using Postman to access the URI:
The header is as follow:
Key : Authorization 
Value: Basic YWRtaW46YWRtaW4xMjM=
```


To Run the App:
```
Go to the project root folder using command line 
> mvn clean install
Under the target folder the backbase-exercise.war can be found.
Copy the war and place it under the webapp directory of your Tomcat instance.
Start your Tomcat Server.
```

Design Consideration:

```
Implemented using teh RESTful architecture principles.
Added Basic Authentication as a security mechanism.
Implemented a reusable object model, which can work for any any other bank.
```
Improvements:
```
Could have decoupled the data source unsing routing mechanism( could have been Apache Camel or MuleSoft)
Could not finish Exception Handling due to lack of time.
Could have also added some Junit test cases.
``
