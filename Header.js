import './Main.css'
import { AppBar } from "@mui/material";
import { Link } from 'react-router-dom';


export default function Header(){
    return(
        <AppBar>
             <div className="header">
              <div class="logo">
              <img src="https://unlitravels.com/wp-content/uploads/2021/09/Picture_2_Travel.jpeg" className="header-img"  />
              <h3 className="header-text">GUIDE TOUR</h3>
              </div>

               <div className="link">
                   <Link to = "/home">Home</Link>
                   <Link to = "/guides">Guides</Link>
                   <Link to = "/about">About</Link>
                   </div>

                   </div>
            </AppBar>
    )
}