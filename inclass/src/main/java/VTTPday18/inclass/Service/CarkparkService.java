package VTTPday18.inclass.Service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import VTTPday18.inclass.Models.Carkpark;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;



@Service
public class CarkparkService {

    public static final String URL = "https://data.gov.sg/api/action/datastore_search?resource_id=d_9f6056bdb6b1dfba57f063593e4f34ae";

    public List<Carkpark> getCarparks(){  
        //building the request with URL
        RequestEntity<Void> req = RequestEntity
                .get(URL)
                .accept(MediaType.APPLICATION_JSON)
                .build();
        //exchanging req for JSON string
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resp = restTemplate.exchange(req, String.class);
        //String carparkRawData =  restTemplate.getForObject(URL, String.class);
            //direct way to make a GET request with the provided URL
            //automatically converts the response body into the desired object type (desire a String/JSONString)

        String payload = resp.getBody();

        JsonReader reader = Json.createReader(new StringReader(payload));
        JsonObject result = reader.readObject();

        JsonArray records = result.getJsonObject("result").getJsonArray("records");

        //ArrayList holding carpark objects
        List<Carkpark> carpark = new ArrayList();
        for(int i = 0; i < records.size(); i++){
            JsonObject temp = records.getJsonObject(i);
            Carkpark uniCar = new Carkpark(temp.getInt("_id"),
                    temp.getString("carpark"),
                    temp.getString("category"),
                    temp.getString("weekdays_rate_1"),
                    temp.getString("weekdays_rate_2"),
                    temp.getString("saturday_rate"),
                    temp.getString("sunday_publicholiday_rate")
                    );
            carpark.add(uniCar);
        }
        return carpark;
    }

}
