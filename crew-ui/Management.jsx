import React from 'react';
import Paper from "@material-ui/core/es/Paper/Paper";
import MenuList from "@material-ui/core/es/MenuList/MenuList";
import MenuItem from "@material-ui/core/es/MenuItem/MenuItem";
import {Link,} from 'react-router-dom';

export class Management extends React.Component {
    constructor() {
        super();
    }

    render() {
        return (
            <div>
                <Paper style={styling.list}>
                    <MenuList style={{display: 'inline-flex'}} role="menu">
                        <MenuItem style={styling.item}>
                            <Link style={styling.link} exact to="/">Home</Link>
                        </MenuItem>
                        <MenuItem style={styling.item}>
                            <Link style={styling.link} to="/teams">Team Table</Link>
                        </MenuItem>
                        <MenuItem style={styling.item}>
                            <Link style={styling.link} to="/persons">Person Table</Link>
                        </MenuItem>

                    </MenuList>
                </Paper>
                <h1> test </h1>
            </div>

        );
    }

}

const styling = {
    list: {
        display: 'inline-flex',
        backgroundColor: 'rgb(0, 191, 255,0.2)',
        float: 'right',
        marginTop: 20,
        marginRight: 75,

    },
    item: {
        padding: '20px',
        marginLeft: '10px',
        marginRight: '10px',
        backgroundColor: 'rgb(255, 215,0, 0.65)',
        border: '3px solid white',
        color: '#1E90FF',
        borderRadius: '50px 20px',
        fontWeight: 'bold',
    },
    link: {
        textDecoration: 'none',
        color: '#6495ED',
    }

}
export default Management;