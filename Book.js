import React from "react";
import './Main.css';


function Book(){

  return(
   <div className="book">
     <fieldset>
       <div className="table">
         <h1>Book Now !!!</h1>
         <hr />
        <table cellpadding ="2" cellspacing="3">
          <tbody>
            <tr>
              <td>Name:</td>
              <td>
                <input type="text" maxlength="15" size="10"/>
              </td>
            </tr>
            <tr>
              <td>Surname:</td>
              <td>
                <input type="text" maxlength="15" size="10"/>
              </td>
            </tr>
            <tr>
              <td>Passport Number:</td>
              <td>
                <input type="text" />
              </td>
            </tr>
            <tr>
              <td>Date:</td>
              <td>
                <select>
                  <option>Day</option>
                  <option>1</option>
                  <option>2</option>
                  <option>3</option>
                  <option>4</option>
                  <option>5</option>
                  <option>6</option>
                  <option>7</option>
                  <option>8</option>
                  <option>9</option>
                  <option>10</option>
                  <option>11</option>
                  <option>12</option>
                  <option>13</option>
                  <option>14</option>
                  <option>15</option>
                  <option>16</option>
                  <option>17</option>
                  <option>18</option>
                  <option>19</option>
                  <option>20</option>
                  <option>21</option>
                  <option>22</option>
                  <option>23</option>
                  <option>24</option>
                  <option>25</option>
                  <option>26</option>
                  <option>27</option>
                  <option>28</option>
                  <option>29</option>
                  <option>30</option>
                </select>
                <select>
                  <option>Month</option>
                  <option>January</option>
                  <option>February</option>
                  <option>March</option>
                  <option>April</option>
                  <option>May</option>
                  <option>June</option>
                  <option>July</option>
                  <option>August</option>
                  <option>September</option>
                  <option>October</option>
                  <option>November</option>
                  <option>December</option>
                </select>
              </td>
            </tr>
            <button>Book</button>
          </tbody>
        </table>
       </div>
     </fieldset>
   </div>
  )
      
}

export default Book;