import React from 'react';
import Paper from "@material-ui/core/es/Paper/Paper";
import Tabs from "@material-ui/core/es/Tabs/Tabs";
import {Link} from "react-router-dom";
import Tab from "@material-ui/core/es/Tab/Tab";
import AccessibilityIcon from '@material-ui/icons/Accessibility';
import PersonPinIcon from '@material-ui/icons/PersonPin';
import DeveloperBoardIcon from '@material-ui/icons/DeveloperBoard'
import HomeIcon from '@material-ui/icons/Home';


class IconLabelTabs extends React.Component {
    constructor() {
        super()
    }

    render() {
        return (
            <Paper style={styled.paper}>
                <Tabs style={styled.inner}>
                    fullWidth
                    indicatorColor="secondary"
                    textColor="secondary"
                    >
                    <Link style={{textDecoration: 'none'}} to="/"><Tab style={styled.icon}
                                                                       icon={<HomeIcon style={{fontSize: 40}}
                                                                                       color="secondary"/>}
                                                                       label="Home MainPage"/>
                    </Link>
                    <Link style={{textDecoration: 'none'}} to="/teams"><Tab style={styled.icon}
                                                                            icon={<AccessibilityIcon style={{fontSize: 40}}/>}
                                                                            label="Teams Table"/></Link>
                    <Link style={{textDecoration: 'none'}} to="/persons"><Tab style={styled.icon}
                                                                              icon={<PersonPinIcon style={{fontSize: 40}}/>}
                                                                              label="Persons Table"/></Link>
                    <Link style={{textDecoration: 'none'}} to="/manage"><Tab style={styled.icon}
                                                                             icon={<DeveloperBoardIcon style={{fontSize: 40}}/>}
                                                                             label="Management "/></Link>
                </Tabs>
            </Paper>
        );
    }
}

export default IconLabelTabs;

const styled = {
    paper: {
        marginLeft: 'auto',
        marginRight: 'auto',
        backgroundColor: 'rgb(135, 206, 250, 0.25)',
        width: '50%',
        height: '50%',
        textAlign: 'center',
    },
    inner: {
        padding: '50px',
        display: 'inline-block',
    },
    icon: {
        fontWeight: 'bold',
        fontSize: '25px',
        marginTop: '4px',
    }
}