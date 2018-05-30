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

{/*
   @author Wiktor Religo
 * @since 21.05.2018*/
}

class TeamPage extends React.Component {
    render() {
        return (
            <div>
                <NavigationMenu/>
                <TeamTable/>
                <TeamDialog/>
            </div>

        );
    }
}


const NavigationMenu = () => {
    return (
        <div className={styles2.root}>
            <AppBar position="static">
                <Toolbar>
                    <IconButton className={styles2.menuButton} color="inherit" aria-label="Menu">
                        <MenuIcon/>
                    </IconButton>
                    <Typography variant="title" color="inherit" className={styles2.flex}>
                        Title
                    </Typography>
                    <Button color="inherit">Login</Button>
                </Toolbar>
            </AppBar>
        </div>
    );
}

const styles2 = {
    root: {
        flexGrow: 1,
    },
    flex: {
        flex: 1,
    },
    menuButton: {
        float: 'right',
        marginLeft: -12,
        marginRight: 20,
    },
    button: {
        margin: spacing.unit,
    },
};
export default TeamPage;