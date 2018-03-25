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

Challenges:
There were a couple of challenges I faced while doing this project:
1) Data transformation of the web service GetCitiesByCountry
```
The Response GetCitiesByCountryResponse was a String intead of XML object, which was difficult to parse. 
To overcome it :
I wrote a groovy script to convert the string to a DOM object and then used 
MULE's DOMTOXML transformer to make it a proper XML. 
And Finally tranforming the XML to JSON as per my API's response.

Alternative:
Could have been also parsed through dataweave if I would have investigate more.
```
2) Dockerising the actual service and the mock service
```
Since the GetWeather webservice was not working, I had to write a simple mock service 
and call the service in my weather-raml-exercise instead of actual service.

The Problem was how to deploy bot the application in a docker container:

I tried deploying both the apps in one docker container but could not control the order of deployment, 
which cause the weather-raml-exercise app to Fail because it was dependent on "mock-weather-app".
And the container was first deploying weather-raml-exercise and then "mock-weather-app" 
later which caused Connection Refused error becuause it could not find the mock web service.

To overcome it:
I decided to deploy the mock service in a separate docker container.

and then deploy the weather-raml-exercise in separate container but to share the 
network of the mock container so that it can access the mock web service.

To achieve it I used the following docker command:
docker run --network container:muleMock -it --name muleService mule-container

```
Improvements:
```
1) Could have imporoved the Exception Handling of the project by defining a global exception strategy 
   and using it in all the flows.
2) If time permitted could have added unit test cases to app.
3) Made the mock webservice an exact replica of the actual webservice, which will reduce changes 
   to the app when the actual webservice is up and running.
```

I really enjoyed doing this exercis and learnt a lot about docker.
