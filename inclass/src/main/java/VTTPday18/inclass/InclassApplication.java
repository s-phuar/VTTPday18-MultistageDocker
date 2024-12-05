package VTTPday18.inclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InclassApplication {

	public static void main(String[] args) {
		SpringApplication.run(InclassApplication.class, args);
	}

}


//try not to use slim in FROM for dockerfile, might have issues with health check

//starting on railway
	//create empty service
	//create redis database
	
//from redis railway, grab and divide up {REDIS_PUBLIC_URL} for below 

//In empty service (use REDIS_PUBLI_URL)
	//variables -> new variables
		//SERVER_PORT (whatever you declare in application_properties)
		//SPRING_DATA_REDIS_HOST (junction...)
		//SPRING_DATA_REDIS_PORT (20320)
		//SPRING_DATA_REDIS_USERNAME (default)
		//SPRING_DATA_REDIS_PASSWORD (messy string)

//connecting to railway redis with ubuntu
	//redis-cli -u {REDIS_PUBLIC_URL} (found under database's variables)
	

//after dockerizing your application
	//railway login
	//railway link
	//railway up (deploy app to railway)

