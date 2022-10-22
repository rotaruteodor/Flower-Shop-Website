import './App.css';
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import {LoginComponent} from './components/LoginComponent'
import { MainPageComponent } from './components/MainPageComponent';

function App() {
  return (
    <div>
      <Router>
        <Routes>
          <Route exact path="/" element={<LoginComponent/>} />
          <Route exact path="/mainPage" element={<MainPageComponent />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
