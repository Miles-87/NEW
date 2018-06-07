import React from 'react';
import TeamTable from './TeamTable.js';
import {AppBar} from '@material-ui/core/';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import IconButton from '@material-ui/core/IconButton';
import MenuIcon from '@material-ui/icons/Menu';
import Toolbar from '@material-ui/core/Toolbar';
import spacing from "@material-ui/core/es/styles/spacing";
import TeamDialog from "./TeamDialog";
import {Link,} from 'react-router-dom';

{/*
   @author Wiktor Religo
 * @since 21.05.2018*/
}

class TeamPage extends React.Component {

    constructor() {
        super();
        this.teamAddedCallback = () => {
            this.tableRef.updateTableWithNewData();
        }
    }

    render() {
        return (
            <div style={{textAlign: 'left'}}>
                <NavigationMenu/>
                <TeamTable onRef={ref => {
                    (this.tableRef = ref);
                }}/>
                <TeamDialog onSave={this.teamAddedCallback}/>
            </div>
        );
    }
}

export const NavigationMenu = () => {
    return (
        <div className={styles2.root}>
            <AppBar position="static">
                <Toolbar>
                    <IconButton className={styles2.menuButton} color="inherit" aria-label="Menu">
                        <MenuIcon/>
                    </IconButton>
                    <Link style={styles2.link} to="/">
                        <Typography variant="title" color="inherit" className={styles2.flex}>
                            Back to Home
                        </Typography>
                    </Link>

                    <Button color="inherit"
                            style={{
                                marginLeft: '50px',
                                letterSpacing: 1.5,
                                opacity: 0.7,
                                border: '1.5px solid #00BFFF'
                            }}>
                        <Link style={styles2.link} to="/manage">Manage</Link></Button>
                    <Link style={styles2.link} to="/teams">
                        <Button color="inherit"
                                style={{marginLeft: '50px', backgroundColor: 'rgb(220, 20, 60,0.8)', letterSpacing: 1.5}}> show
                            show TeamTable </Button>
                    </Link>
                    <Link style={styles2.link} to="/persons">
                        <Button color="inherit"
                                style={{marginLeft: '50px', backgroundColor: 'rgb(220, 20, 60,0.8)', letterSpacing: 1.5}}> show
                            PersonTable </Button>
                    </Link>
                </Toolbar>
            </AppBar>
        </div>
    )
        ;
}

export const styles2 = {
    root: {
        flexGrow: 1,
    },
    flex: {
        flex: 1,
        marginRight: '15px',
    },
    menuButton: {
        float: 'right',
        marginLeft: -12,
        marginRight: 20,
    },
    button: {
        margin: spacing.unit,
    },
    link: {
        textDecoration: 'none',
        color: 'white',
    }
};
export default TeamPage;