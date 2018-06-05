import React from 'react';
import {BrowserRouter as Router, Route,} from 'react-router-dom';
import App from "./App.jsx";
import HomeIcon from '@material-ui/icons/Home';
import FavoriteIcon from '@material-ui/icons/Favorite';
import PersonPinIcon from '@material-ui/icons/PersonPin';
import Tabs from "@material-ui/core/es/Tabs/Tabs";
import Paper from "@material-ui/core/es/Paper/Paper";
import Tab from "@material-ui/core/es/Tab/Tab";

{/*
   @author Wiktor Religo
 * @since 04.06.2018*/
}

class PageRouting extends React.Component {
    constructor() {
        super();
    }

    render() {
        return (
            <Router>
                <div>
                    <Route exact path="/main" component={IconLabelTabs}/>
                    <Route exact path="/" component={Persons}/>
                    <Route path="/persons" component={App}/>
                </div>
            </Router>
        );
    }


}

export class IconLabelTabs extends React.Component {
    constructor() {
        super();
        this.state = {
            value: 0,
        };
        this.handleChange = (event, value) => {
            this.setState({value});
        };
    }


    render() {
        return (
            <Paper style={{width: 500}}>
                <Tabs>
                    value={this.state.value}
                    onChange={this.handleChange}
                    fullWidth
                    indicatorColor="secondary"
                    textColor="secondary"
                    >
                    <Tab icon={<HomeIcon color="secondary"/>} label="Home MainPage"/>
                    <Tab icon={<FavoriteIcon/>} label="FAVORITES"/>
                    <Tab icon={<PersonPinIcon/>} label="NEARBY"/>
                </Tabs>
            </Paper>
        );
    }
}

export default PageRouting;
