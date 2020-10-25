import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Route, BrowserRouter, Switch } from 'react-router-dom';
import HomePage from './pages/HomePage';
import NavBar from './components/NavBar';

function App() {
  return (
    <div>
      <BrowserRouter>
      <NavBar/>
        <Switch>
          <Route exact path ="/" component={HomePage}/>
        </Switch>
      </BrowserRouter>
    </div>
  );
}
export default App;
