package GuideTour.demo.service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import GuideTour.demo.model.GuideTour;

@Service //to mark the class as a service provider
public class GuideServiceImpl implements GuideService {
    private static Map<Integer, GuideTour> guides = new HashMap<Integer, GuideTour>(); //initialise a static Map,Hashmap is used to store a key
    //for auto id generation
    private final AtomicLong id = new AtomicLong(); //incremented sequence numbers

    //The class' constructor, in which data is read from the CSV file and stored into a HashMap

    public GuideServiceImpl(){ //method need to read our CSV

        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        //try{}catch block to connect our CSV data.
        try(BufferedReader br = new BufferedReader(new FileReader ("guide.csv"))){
            String line; 
            while ((line = br.readLine()) != null){
                String [] values = line.split(",");
                GuideTour guideTour = new GuideTour((int)id.incrementAndGet(), values[1],values[2], values[3], values[4], values[5],values[6],values[7]);
                guides.put(id.intValue(), guideTour);
            } }catch(IOException e) {
            e.printStackTrace(); } }
            
    
    //used when we override a method in sub class @Override

    //This method is used to add a new article to the hashmap
    @Override   //auto-implementation from our main class
    public void createGuide(GuideTour GuideTour) { //POST method
        if(guides. containsKey(GuideTour.getId())){ //condition for creation of guides
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Existig Id ...");}
        guides.put(GuideTour.getId(), GuideTour);
    }

    //This method is called to edit an already existing article
    @Override
    public void updateGuide(Integer id, GuideTour GuideTour) { //PUT method
        guides.remove(id);
        GuideTour.setId(id);
        guides.put(GuideTour.getId(), GuideTour);  
    }

    //This method is used to delete an article from the hashmap based on the ID provided
    @Override
    public void deleteGuide(Integer id) { //DELETE method
        guides.remove(id);
    }

    //This method simply returns the entries in the hashmap in the form of an array
    @Override
    public Collection<GuideTour> getGuides() {
        return guides.values(); 
    }

    //This method is used to get a filtered set of guides 
    // with the filtertype and filter provided in the frontend

    @Override //This code is written for the filter method. If we want to search by name, we have the first case.
    public Collection<GuideTour> getFilteredGuideTours(String filterType, String filter) {
        Map<Integer, GuideTour> filteredGuides = new HashMap<Integer, GuideTour>();
        AtomicLong counter = new AtomicLong();
        switch(filterType) {
            case "name": for(Map.Entry<Integer, GuideTour> el : guides.entrySet()) {
                if(el.getValue().getName().toLowerCase().contains(filter.toLowerCase()))
                    filteredGuides.put((int)counter.incrementAndGet(), el.getValue());
            } break;
            case "period": for(Map.Entry<Integer, GuideTour> el : guides.entrySet()) {
                if(el.getValue().getPeriod().toLowerCase().contains(filter.toLowerCase()))
                    filteredGuides.put((int)counter.incrementAndGet(), el.getValue());
            } break;
            case "monument": for(Map.Entry<Integer, GuideTour> el : guides.entrySet()) {
                if(el.getValue().getMonument().toLowerCase().contains(filter.toLowerCase()))
                    filteredGuides.put((int)counter.incrementAndGet(), el.getValue());
            } break;
            case "tour": for(Map.Entry<Integer, GuideTour> el : guides.entrySet()) {
                if(el.getValue().getTour().toLowerCase().contains(filter.toLowerCase()))
                    filteredGuides.put((int)counter.incrementAndGet(), el.getValue());
            } break;
            case "languages": for(Map.Entry<Integer, GuideTour> el : guides.entrySet()) {
                if(el.getValue().getLanguages().toLowerCase().contains(filter.toLowerCase())) {
                    filteredGuides.put((int)counter.incrementAndGet(), el.getValue());
                }
            } break;
            case "prices": for(Map.Entry<Integer, GuideTour> el : guides.entrySet()) {
                if(el.getValue().getLanguages().toLowerCase().contains(filter.toLowerCase())) {
                    filteredGuides.put((int)counter.incrementAndGet(), el.getValue());
                }
            } break;
            default: System.out.println("Guide not found!!!");
        } 
        return filteredGuides.values();
    }
    @Override
    public Object getSingleGuide(Integer id) {
        return guides.get(id);
    }
}