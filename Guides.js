import React, { useEffect, useState } from "react";
import { useParams } from 'react-router-dom';
import './Main.css';
import Header from "./Header";
import SocialFollow from "./SocialFollow";
import Contacts from "./contacts";



function Guides(){

    let params = useParams();
    const [guide, setGuide] = useState({});

    useEffect(() => {
        fetch("http://localhost:8080/guides/" + params.guideID).then(res => res.json()).then(json => setGuide(json));
    }, []);
    
    return( 
    <div className="full-guide">
        <Header/>
        <div class="guide-content">
        <h1>{guide.name} Tour</h1>
        <img src={guide.src} className="guide-image"/>
        <h2>Bus program, 2 days</h2>
        <p>
        Take a guided tour of 3 famous Roman sites: the Colosseum, Roman Forum, and Palatine Hill. Let your guide bring 
        their history to life as you tour a UNESCO World Heritage site, the Ancient Roman social epicenter, and founding hill.
        </p>
        <div className="day 1">
        <b>Day 1</b>
        </div>
        <div className="inside">
        <img src="https://images.contentstack.io/v3/assets/blt06f605a34f1194ff/blt7e0cc5db76ecaf89/6249f53b7d552701c6365d36/Rome_Maps_R2_150dpi-Day_1.jpg?width=704&heigth=704&format=webp" className="map"/>
        </div>
        <div>
            <b>
            Explore 2,000 years of history at the Vatican Museums (2.5 hours)
            </b>
            <p>
            Vatican City, encircled by Rome, is the smallest country in the world and home to the Vatican Museums, where more than 20,000 priceless pieces of history and art are on display across 24 interconnecting galleries. Although you can 
            enter the museum for free on certain days, you can’t book ahead and the line will eat into your 48 hours — so book a 
            ticket in advance, and an audio guide at the very least, as its sheer size can be overwhelming and there aren’t many signs.
            Grab a map at the beginning and make sure you leave time to explore the Sistine Chapel, which sits at the end of this 
            labyrinth of spaces, as well the Salvador Dali painting in The Collection of Modern Religious Art — it’s truly breathtaking.
            </p>
        </div>
        <div className="map1">
        <img src="https://images.contentstack.io/v3/assets/blt06f605a34f1194ff/blt3a1ed6827e8a6a63/6249f67e6cd4ca7aebeb5771/Copy_of_BCC-2022-IT-ROME-DAY1-STOP3.jpg?width=700&height=350&fit=crop&format=webp" className="eat"/>
        </div>
        <div>
            <b>
            Stop for lunch in Prati (1 hour)
            </b>
            <p>
            A short walk to the east of the Vatican will bring you to Rome’s Prati neighborhood, a vibrant area filled with cafes,
            restaurants, and gelato stands where you can enjoy your lunch alfresco if the weather’s on your side. Find a Rosticceria,
            which is typically a hole-in-the-wall style spot with buffet-style food behind the counter. Expect plates of lasagne, roasted
            meats and vegetables, and pastas, paid for by weight and often made according to age-old family recipes — it’s one of the most
            authentic ways to eat in the city. Once you’ve refueled, shop around the area’s tempting boutiques, as you make your way south.
            </p>

            <b>Day 2</b>
        </div>
        <div className="inside">
        <img src="https://images.contentstack.io/v3/assets/blt06f605a34f1194ff/blte2d817014e16af5c/6249f84021fd967b5ff22058/Rome_Maps_R2_150dpi-Day_2.jpg?width=704&heigth=704&format=webp" className="map"/>
        </div>
        <div>
            <b>
            Be an early bird at the Colosseum and Roman Forum (3 hours)
            </b>
            <p>
            Get up early to visit the Colosseum, Rome’s most iconic sight, before the crowds descend. There is so much to experience
            at this wonder of the ancient world, that it’s best to book a guided tour and let an expert guide you through it and answer
            any questions you might have. Make sure you choose a ticket that allows you to enter the underground passages, as well as through
            the Gladiators’ Gate to stand in the Arena floor — it’s pretty special to see from the gladiators’ point of view. From here, it’s only
            a short walk on to the Roman Forum and Palatine Hill, the birthplace of the city, and access is included in all Colosseum tickets.
            </p>
        </div>
        <div className="map1">
        <img src="https://images.contentstack.io/v3/assets/blt06f605a34f1194ff/blt8851c7527ec12e04/6249f9617d552701c6365d42/Copy_of_BCC-2022-IT-ROME-DAY2-STOP2.jpg?width=700&height=350&fit=crop&format=webp" className="eat"/>
        </div>
        <div>
            <b>
            Get a unique panorama of Rome at the Altar of the Fatherland (1 hour)
            </b>
            <p>
            A bold national monument erected in honor of Victor Emmanuel II, Vittoriano — known as the Altar of the Fatherland — stands
            elevated in Venice Square and its terraces offer mesmerizing views of the city, including the Colosseum and the Roman Forum.
            Taking the glass elevator to the top is something of a hidden gem that not many tourists know about, but you can visit the Altar’s
            terrace for free if you climb the 243 steps instead. A limited number of people are allowed to do this at any one time, so be prepared
            to wait.
            </p>
            
        </div>
        </div>
        <Contacts/>
        <SocialFollow/>
    </div>
    
    );
}

export default Guides;