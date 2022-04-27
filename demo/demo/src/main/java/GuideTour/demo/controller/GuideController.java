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
    GuideService guideService; 
    @CrossOrigin(origins = "http://localhost:3000") //link with frontend
    @RequestMapping(value = "/guides", method=RequestMethod.GET) //request a specific method, in this case GET, 
    public ResponseEntity<Object> getPlace() throws FileNotFoundException, IOException{
        return new ResponseEntity<>(guideService.getGuides(), HttpStatus.OK);
    }
    @CrossOrigin(origins= "http://localhost:3000")
    @RequestMapping(value = "/guides/{id}", method=RequestMethod.GET)
    public ResponseEntity<Object> getSingleGuide(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(guideService.getSingleGuide(id), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/guides/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id")Integer id){
        guideService.deleteGuide(id);
        return new ResponseEntity<>("Guide is deleted successfully", HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/guides", method=RequestMethod.POST)
    public ResponseEntity<Object> createGuide(@RequestBody GuideTour GuideTour){
        guideService.createGuide(GuideTour);
        return new ResponseEntity<>("Place is created successfully", HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/guides/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Object> updateGuide(@PathVariable("id") int id, @RequestBody GuideTour GuideTour){
        guideService.updateGuide(id,GuideTour);
        return new ResponseEntity<>("Place is updated successfully", HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/guides/{filterType}/{filter}", method = RequestMethod.GET)
    public ResponseEntity<Object> getFilteredGuideTours(@PathVariable("filterType") String filterType,
            @PathVariable("filter") String filter) {
        return new ResponseEntity<>(guideService.getFilteredGuideTours(filterType, filter), HttpStatus.OK);
    }
}