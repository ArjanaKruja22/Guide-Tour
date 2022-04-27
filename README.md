# Guide-Tour
This project was done with Visual Studio Code.For the backend part GUIDE-TOUR is used Spring Boot.
Firstly, we initialised Spring Initializr to get the zip folder,exctract it and open in VS.
Created a simple CSV file and imported it in VS.
After that, we created the main files : MODEL,SERVICE,CONTROLLER,VIEW
MODEL contains the main class GuideTour.java (declare the variables, constructor, get/set methods for each)
SERVICE contains GuideService.java and GuideServiceImpl.java which implements the methods: createGuide,updateGuide,deleteGuide,getGuides(),getFilteredGuideTours
CONTROLLER contains GuideController.java which have the routes for our backend localhost and frontend localhost, also the requests methods.
HIT run command to see the JSON file in browser.
