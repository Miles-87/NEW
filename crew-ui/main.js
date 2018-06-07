import React from 'react';
import ReactDOM from 'react-dom';

import TeamPage from "./TeamPage.js";
import IconLabelTabs from "./IconLabelTabs.js";
import Management from "./Management.js";
import App from "./App.jsx";
import {HashRouter  as Router, Route, Switch} from 'react-router-dom'

ReactDOM.render(
    <Router>
        <Switch>
            <Route exact path="/" component={IconLabelTabs}/>
            <Route path="/teams" component={TeamPage}/>
            <Route path="/persons" component={App}/>
            <Route path="/manage" component={Management}/>
        </Switch>
    </Router>
    , document.getElementById('app'));