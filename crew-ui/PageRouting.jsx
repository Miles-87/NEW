import React from 'react';
import TeamPage from "./TeamPage.jsx";
import {BrowserRouter as Router, NavLink, Route,} from 'react-router-dom';
import App from "./App.jsx";
import HomeIcon from '@material-ui/icons/Home';
import AccessibilityIcon from '@material-ui/icons/Accessibility';
import PersonPinIcon from '@material-ui/icons/PersonPin';
import Tabs from "@material-ui/core/es/Tabs/Tabs";
import Paper from "@material-ui/core/es/Paper/Paper";
import Tab from "@material-ui/core/es/Tab/Tab";
import Management from "./Management.jsx";
import DeveloperBoardIcon from '@material-ui/icons/DeveloperBoard'

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
                <div style={styled.container}>
                    <Route exact path="/" component={IconLabelTabs}/>
                    <Route path="/teams" component={TeamPage}/>
                    <Route path="/persons" component={App}/>
                    <Route path="/manage" component={Management}/>
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
            <Paper style={styled.paper}>
                <Tabs style={styled.inner}>
                    value={this.state.value}
                    onChange={this.handleChange}
                    fullWidth
                    indicatorColor="secondary"
                    textColor="secondary"
                    >
                    <NavLink style={{textDecoration: 'none'}} exact to="/"><Tab style={styled.icon}
                                                                                icon={<HomeIcon style={{fontSize: 40}} color="secondary"/>}
                                                                                label="Home MainPage"/>
                    </NavLink>
                    <NavLink style={{textDecoration: 'none'}} to="/teams"><Tab style={styled.icon}
                                                                               icon={<AccessibilityIcon style={{fontSize: 40}}/>}
                                                                               label="Teams Table"/></NavLink>
                    <NavLink style={{textDecoration: 'none'}} to="/persons"><Tab style={styled.icon}
                                                                                 icon={<PersonPinIcon style={{fontSize: 40}}/>}
                                                                                 label="Persons Table"/></NavLink>
                    <NavLink style={{textDecoration: 'none'}} to="/manage"><Tab style={styled.icon}
                                                                                icon={<DeveloperBoardIcon style={{fontSize: 40}}/>}
                                                                                label="Management "/></NavLink>
                </Tabs>
            </Paper>
        );
    }
}

export const styled = {
    paper: {
        backgroundColor: 'rgb(135, 206, 250, 0.25)',
        width: '50%',
        height: '50%',
        textAlign: 'center',
        margin: 'auto',

    },
    container: {
        textAlign: 'center',
        margin: 'auto',
        display: 'block',
    },
    inner: {
        flex: 'none',
        padding: '50px',
        display: 'inline-block',
    },
    icon: {
        fontWeight: 'bold',
        fontSize: '25px',
        marginTop: '4px',
    }
}

export default PageRouting;

