import React, { useState, useEffect } from "react";
import "./Main.css";
import SimpleImageSlider from "react-simple-image-slider";

import "./index.js";
import {Link} from "react-router-dom";
import SocialFollow from "./SocialFollow"
import Header from "./Header";



function Home() { 
    //Declare a new state variable, which we'll call filter,guides,filterType
    const [filter, setFilter] = useState("");
    const [guides, setGuides] = useState([]);
    const [filterType, setFilterType] = useState("name");

    const getData = () => {
        if (filter === "") {
            fetch("http://localhost:8080/guides/")
                .then(res => res.json())
                .then(json => setGuides(json));
        }
        else {
            fetch("http://localhost:8080/guides/" + filterType + "/" + filter)
                .then(res => res.json())
                .then(json => setGuides(json));
        }
    }

    useEffect(() => {
        fetch("http://localhost:8080/guides").then(res => res.json()).then(json => setGuides(json));
    }, []);

    const images = [
        { url: "https://wallpaperaccess.com/full/185289.jpg" },
        { url: "https://wallpaperaccess.com/full/129471.jpg" },
        { url: "https://wallpaperaccess.com/full/383910.jpg" },
        { url: "https://wallpaperaccess.com/full/3087751.jpg" },
        { url: "https://wallpaperaccess.com/full/222685.jpg" },
        { url: "https://wallpaperaccess.com/full/2561242.jpg" },
        { url: "https://wallpaperaccess.com/full/441374.jpg" },
        { url: "https://wallpaperaccess.com/full/1127235.jpg"},
        { url: "https://wallpaperaccess.com/full/3690383.jpg"},
        { url: "https://wallpaperaccess.com/full/26316.jpg"},
        { url: "https://wallpaperaccess.com/full/1088051.jpg"},
        
      ];
      
      
      

    return (
        <div className="main-body">

            
                <div className="slider">
                 <SimpleImageSlider
                   width={904}
                   height={504}
                   images={images}
                   showBullets={true}
                    showNavs={true}
                />
                </div>

                <div className="header-nav">
                <div class="box">
                    <input type="text" value={filter} onChange={(event) => {
                        setFilter(event.target.value);
                    }} className="input-search"></input>


                    <select onChange={(event) => {
                        setFilterType(event.target.value);
                    }} name="filterType">
                        <option value="name">Filter by name</option>
                        <option value="monument">Filter by monument</option>
                        
                    </select>


                    <button onClick={getData} className="search-btn">Search</button>


                    </div>
                    </div>

            <div className="backend">
                {guides.map(guide => <div>
                    <div>
                    <Link to = {"/" + guide.id}><img src={guide.src} className="guide-images"/></Link>
                    </div>
                    <h4>Place name: {guide.name}</h4>
                    <h5>Period: {guide.period}</h5>
                    <h5>Monument: {guide.monument}</h5>
                    <h5>Tour: {guide.tour}</h5>
                    <h5>Languages: {guide.languages}</h5>
                    <h5>Price: {guide.price}</h5>
                    <Link to = "/book"><button type="button" className="book-button">Book</button></Link>
                    </div>)}
                    </div>

                    
                
            

            <div className='Bottom'>
        <p>
          <b>Guide Tour. All rights reserved.</b>
          <br/>
          <b>Phone Number:</b>
          +35569xxxxxxx
          <br/>
          <b>Open:</b>
          Monday-Saturday (9:00 - 18-00)
          <br/>
          
        </p>
        
     </div>
    
        </div>
    )
}
export default function App(){
    return <div class="wrapper">
    <Header/>
    <Home />
    <SocialFollow />
    
    </div>
}
