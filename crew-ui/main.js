import React from 'react';
import ReactDOM from 'react-dom';

import TeamPage from "./TeamPage.js";
import Management from "./Management.js";
import App from "./App.jsx";
import {HashRouter  as Router, Route, Switch} from 'react-router-dom'
import Home from "./Home.jsx"

{/*
   @author Wiktor Religo
 * @since 03.06.2018*/
}
ReactDOM.render(
    <Router>
        <Switch>
            <Route exact path="/" component={Home}/>
            <Route path="/teams" component={TeamPage}/>
            <Route path="/persons" component={App}/>
            <Route path="/manage" component={
                Management}/>
        </Switch>
    </Router>
    , document.getElementById('app'));