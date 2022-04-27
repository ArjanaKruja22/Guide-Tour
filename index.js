import React from 'react';
import './index.css';
import App from './App';
import { render } from '@testing-library/react';
import { BrowserRouter,Routes,Route } from 'react-router-dom';
import Guides from './Guides';
import About from './About';
import Book from './Book';

const rootElement = document.getElementById("root");
render(
  <BrowserRouter>
  <Routes>
  <Route path="/" element={<App />}/>
  <Route path="home" element={<App />}/>
  <Route path="/:guideID" element={<Guides />}/>
  <Route path="about" element={<About />}/>
  <Route path="book" element={<Book />}/>
  

  </Routes>
    </BrowserRouter>,
    rootElement
);
