# LivQuik
LivQuik Application Weather forecast

Things you may require to run it:

Java 8
Maven 3
Intilej Idea IDE (Optional)
Else you can make a build by running foloowing command

   Command :
   
     mvn clean install -D skipTests
     cd target/
     java -jar LivQuikApp-0.0.1-SNAPSHOT.jar


Import the package and do a mvn clean install to build package top download the dependencies,
once all the dependency resolved, run this application
which by default will run on port :8080, the server on which will be running
will be local host, hence all your request will be pointing to localhost

There are two REST API's exposed from this microservices,
1. In order to get the List of Longitude and Latitude along with the city name

   Request Method : GET
   
        End Point : localhost:8080/getCityAndLocation
        Response : Watch it after you run it
 
 2. In order to get the Weather Forecast of City with it's name and number of days for which you want the forecast
 
   Request Method : GET
 
    End Point : localhost:8080/getWeatherForecast
    Request param : cityName, startDate (Date type not string), numberOfDays

    cityName : Accepts String Value only
    startDate : Accepts Date in yyyy-mm-dd format
    numberOfDays: Accpets integer value
 
    Sample Request : localhost:8080/getWeatherForecast?cityName=Atlanta&startDate=2019-05-26&numberOfDays=5
    Response: Watch it after you run it

 
 
 

