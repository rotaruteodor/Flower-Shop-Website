import './App.css';
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { LoginComponent } from './components/LoginComponent'
import { MainPageComponent } from './components/MainPageComponent';
import {FlowerArrangementDetails} from './components/FlowerArrangementDetails';
import { CheckOutComponent } from './components/CheckOutComponent';

function App() {
  return (
    <div id='mainAppDiv'>
      <Router>
        <Routes>
          <Route exact path="/" element={<LoginComponent />} />
          <Route exact path="/mainPage" element={<MainPageComponent/>} />
          <Route exact path="/flowerArrangementDetails" element={<FlowerArrangementDetails/>} />
          <Route exact path="/mainPage/checkout" element={<CheckOutComponent/>} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
