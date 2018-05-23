import React from 'react';
import NextPersonTable from './NextPersonTable.jsx';
import {AppBar} from '@material-ui/core/';

import Button from '@material-ui/core/Button';
import IconButton from '@material-ui/core/IconButton';
import MenuIcon from '@material-ui/icons/Menu';
import Toolbar from '@material-ui/core/Toolbar';
import spacing from "@material-ui/core/es/styles/spacing";
import AddIcon from '@material-ui/icons/Add';


{/*
   @author Mateusz Michonski
 * @since 21.05.2018*/
}

class Persons extends React.Component {
    render() {
        return (
            <div>
                <ButtonNavigation/>
                <NextPersonTable/>
                <PersonButton/>
            </div>

        );
    }
}

const ButtonNavigation = () => {
    return (
        <div className={styles2.root}>
            <AppBar position="static">
                <Toolbar>
                    <IconButton className={styles2.menuButton} color="inherit" aria-label="Menu">
                        <MenuIcon/>
                    </IconButton>
                </Toolbar>
            </AppBar>
        </div>
    );
}
const PersonButton = () => {
    return (
        <div style={{marginTop: '15px'}}>
            <Button variant="raised" color="primary" aria-label="add" className={styles2.button}>
                <AddIcon/>
            </Button>
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
        float: 'left',
        marginLeft: -12,
        marginRight: 20,
    },
    button: {
        margin: spacing.unit,
    },
};


export default Persons;
