import React from 'react';
import PropTypes from 'prop-types';
import {withStyles} from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';

const styles = theme => ({
    root: {
        width: '100%',
        marginTop: theme.spacing.unit * 3,
        overflowX: 'auto',
    },
    table: {
        minWidth: 700,
    },
});

let id = 0;

function createData(name, lastname, location, email, status, role) {
    id += 1;
    return {name, lastname, location, email, status, role};
}

const data = [
    createData('Jan', 'mucha', 'krakow', 'mail@mail', 'remote', 'admin'),
    createData('Jan', 'mucha', 'krakow', 'mail@mail', 'remote', 'admin'),
    createData('Jan', 'mucha', 'krakow', 'mail@mail', 'remote', 'admin'),
    createData('Jan', 'mucha', 'krakow', 'mail@mail', 'remote', 'admin'),
];

function NextPersonTable(props) {
    const {classes} = props;

    return (
        <Paper className={classes.root}>
            <Table className={classes.table}>
                <TableHead>
                    <TableRow>
                        <TableCell>Name</TableCell>
                        <TableCell>Lastname</TableCell>
                        <TableCell>Location</TableCell>
                        <TableCell>Email</TableCell>
                        <TableCell>Status</TableCell>
                        <TableCell>Role</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {data.map(n => {
                        return (
                            <TableRow key={n.id}>
                                <TableCell component="th" scope="row">
                                    {n.name}
                                </TableCell>
                                <TableCell>{n.lastname}</TableCell>
                                <TableCell>{n.location}</TableCell>
                                <TableCell>{n.email}</TableCell>
                                <TableCell>{n.status}</TableCell>
                                <TableCell>{n.role}</TableCell>
                            </TableRow>
                        );
                    })}
                </TableBody>
            </Table>
        </Paper>
    );
}

NextPersonTable.propTypes = {
    classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(NextPersonTable);
