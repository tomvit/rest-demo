# REST DEMO
REST demo is a simple application which aim is to demonstrate basic capabilities of REST as well as client-side Javascript programming when accessing REST API. The application is being used throughout [Middleware and Web Services and Web 2.0 courses](https://vitvar.com/lectures) at the Czech Technical University in Prague. The goal is to cover topics in the two courses and showcase, for example, REST resources identification, representation and interaction, uniform interface, HATEOAS, caching, revalidation and concurrency control as well as browser-based client access programming requirements including same-origin policy, CORS, JSONP, and streaming API such as SSE, Websockets, etc. Note, that not all of the features are currently implemented in the app, they will be added gradually over time.      

The application is implemented in [Java Spring Boot](https://spring.io/projects/spring-boot), defines a simple in-memory dataset and a REST model in Java, and uses [Semantic UI](https://semantic-ui.com/) and [AngularJS](https://angularjs.org/) for user interaction. In order to demonstrate a third-party Web API access from Spring Boot, it uses [OpenWeather API](https://openweathermap.org/api) to retrieve a temperature for a given city.

## Running

You will need maven to run the application. You can run it as follows:

1. If you want to use data from OpenWeather API, you will need to create OpenWeather API key.
2. Export the key in a file APIKEY in the root directory of the app ```export OPENWEATHER_KEY=<your_key>```.
3. Run ```bin/run.sh```.
4. Access the app at http://localhost:8080

Alternatically, if you do not have maven installed locally and you use Docker, you can run the application as follows. The container uses [Maven Java 8 image](https://hub.docker.com/_/maven).

1. Go to the ```bin``` directory 
2. Run ```docker-compose up -d```. 
4. Access the app at http://localhost:8080 
