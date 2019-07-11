# REST DEMO
REST demo is a simple application which aim is to demonstrate basic capabilities of REST as well as client-side Javascript programming when accessing REST API. The application is being used throughout the Middleware and Web Services and Web 2.0 courses at the Czech Technical University in Prague.

# Technologies
The application is implemented in Java Spring Boot, defines a simple in-memory dataset and a REST model in Java, and uses Semantic UI and Angular JS for user interaction. In order to demonstrate a third-party Web API access from Spring Boot, it uses OpenWeather API to retrieve a temperature 

# Running

You will need maven to run the application. You can run it as follows:

1. If you want to use data from OpenWeather API, you will need to create OpenWeather API key.
2. Store the key in a file APIKEY in the root directory of the app.
3. Run ```bin/run.sh```.

You can also use docker container and in the ```bin``` directory run ```docker-compose up -d```. The container uses maven Java 8 image.
