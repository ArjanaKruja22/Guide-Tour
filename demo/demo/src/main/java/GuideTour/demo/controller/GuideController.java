package GuideTour.demo.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import GuideTour.demo.model.GuideTour;
import GuideTour.demo.service.GuideService;

@RestController // allows to handle all REST APIs such as GET, POST, Delete, PUT requests
public class GuideController {
    @Autowired // marks a Constructor, Setter method, Properties
    GuideService guideService; //variable declaration

    //This code is used to return the full list of guides read from the CSV file
    @CrossOrigin(origins = "http://localhost:3000") //link with frontend
    @RequestMapping(value = "/guides", method=RequestMethod.GET) //request a specific method, in this case GET, 
    public ResponseEntity<Object> getPlace() throws FileNotFoundException, IOException{
        return new ResponseEntity<>(guideService.getGuides(), HttpStatus.OK);
    }

    //This code returns a single guide requested by the user
    @CrossOrigin(origins= "http://localhost:3000")
    @RequestMapping(value = "/guides/{id}", method=RequestMethod.GET)
    public ResponseEntity<Object> getSingleGuide(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(guideService.getSingleGuide(id), HttpStatus.OK);
    }

    //This endpoint is used to delete guides 
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/guides/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id")Integer id){
        guideService.deleteGuide(id);
        return new ResponseEntity<>("Guide is deleted successfully", HttpStatus.OK);
    }

    //This code is used to add/create a new guide 
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/guides", method=RequestMethod.POST)
    public ResponseEntity<Object> createGuide(@RequestBody GuideTour GuideTour){
        guideService.createGuide(GuideTour);
        return new ResponseEntity<>("Place is created successfully", HttpStatus.CREATED);
    }

    //This code is used to edit a guide
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/guides/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Object> updateGuide(@PathVariable("id") int id, @RequestBody GuideTour GuideTour){
        guideService.updateGuide(id,GuideTour);
        return new ResponseEntity<>("Place is updated successfully", HttpStatus.OK); 
        //ResponseEntity is meant to represent the entire HTTP response
    }

    //This code is used to get a filtered list of all guides
    //that completes the user's filter condition
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/guides/{filterType}/{filter}", method = RequestMethod.GET)
    public ResponseEntity<Object> getFilteredGuideTours(@PathVariable("filterType") String filterType,
            @PathVariable("filter") String filter) {
        return new ResponseEntity<>(guideService.getFilteredGuideTours(filterType, filter), HttpStatus.OK);
    }
}