import React from "react";
import './Main.css';
import logo from './logo.png'
import logo1 from './logo1.png'
import Header from "./Header";
import SocialFollow from "./SocialFollow";


function About(){
    return <div className="main">
        <Header/>
        <div className="header-about"> <h1 >About us</h1> </div> <br/>
        <div className="images">
        <img src={logo} />
        <img src={logo1}/>
        </div>
        <p className="paragraph">Our philosophy all over the world remains the same, excellent service, 
            knowledgeable and accurate information along with a positive and innovative attitude.
            We aim to give you all the services you would expect from a long independent trip. 
            Our staff has traveled extensively and in most cases can speak from the first hand experience 
            of many destinations, unlike many other malls, and they stay up to date with the latest travel tips.</p>
        <br/>
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
     <SocialFollow/>
    </div>
}

export default About;