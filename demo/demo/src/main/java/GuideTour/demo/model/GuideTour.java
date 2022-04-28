package GuideTour.demo.model;

public class GuideTour {

    private Integer id; // declaration of variables 
    private String name;
    private String period;
    private String monument;
    private String tour;
    private String languages;
    private String src;
    private String price;

    public GuideTour(){};

    public GuideTour(Integer id, String name, String period, String monument, String tour, String languages,String src,String price){ //constructor called when an instance of the class is created
        this.id = id;  //this. refers to the current object in a method or constructor
        this.name = name;
        this.period = period;
        this.monument = monument;
        this.tour = tour;
        this.languages = languages;
        this.src = src;
        this.price = price;
        
    }
                                  // get/set method for each variable
    public String getPrice() {    // get()  reads the value of a variable
        return price;
    }
    public void setPrice(String price) {   //set()  A setter updates the value of a variable
        this.price = price;
    }
    public String getSrc() {
        return src;
    }
    public void setSrc(String src) {
        this.src = src;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLanguages() {
        return languages;
    }
    public void setLanguages(String languages) {
        this.languages = languages;
    }
    public String getTour() {
        return tour;
    }
    public void setTour(String tour) {
        this.tour = tour;
    }
    public String getMonument() {
        return monument;
    }
    public void setMonument(String monument) {
        this.monument = monument;
    }
    public String getPeriod() {
        return period;
    }
    public void setPeriod(String period) {
        this.period = period;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
}
