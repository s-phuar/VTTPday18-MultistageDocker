package VTTPday18.inclass.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import VTTPday18.inclass.Models.Carkpark;
import VTTPday18.inclass.Service.CarkparkService;

@RestController
@RequestMapping("/api/carparks")
public class CarkparkRestController {
    
    @Autowired
    CarkparkService carkparkService;

    @GetMapping()
    public ResponseEntity<List<Carkpark>> getCarparks(){
        List<Carkpark> carparks = carkparkService.getCarparks();


        //In Spring, when you return a ResponseEntity<List<Carpark>> from a REST controller
        //Spring automatically converts the List<Carpark> object into JSON format before sending it back to the client
        return ResponseEntity.ok().body(carparks);
        // return new ResponseEntity<>(carparks, HttpStatus.OK);        
    }

    
}
