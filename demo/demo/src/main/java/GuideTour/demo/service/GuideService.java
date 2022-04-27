package GuideTour.demo.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import GuideTour.demo.model.GuideTour;

public interface GuideService { 

    //create methods for each request we want to create

    public abstract void createGuide(GuideTour GuideTour); //create new guide 

    public abstract void updateGuide(Integer id,GuideTour GuideTour); //update the guide we just created

    public abstract void deleteGuide(Integer id); //delete the guide through the id

    public abstract Collection<GuideTour> getGuides() throws FileNotFoundException, IOException; //get all the guides we have

    public abstract Object getSingleGuide(Integer id); //get guide clicked through its id (single guide)
    
    public abstract Collection<GuideTour> getFilteredGuideTours(String filterType, String filter); //filter the guide we have based on its name etc
}
