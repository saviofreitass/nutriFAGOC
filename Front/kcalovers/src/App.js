import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';

import ListFood from './pages/ListFood';
import Login from './pages/Login';
import Cadastro from './pages/Cadastro';

function App() {



  return (
    <div className="App">
      <Router>
        <Routes>
         <Route exact path="/" element={<ListFood/>}></Route>
         <Route path="/login" element={<Login/>}></Route>
         <Route path="/cadastro" element={<Cadastro/>}></Route>
        </Routes>
      </Router>
      </div>

  );
}

export default App;
