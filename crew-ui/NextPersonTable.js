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

export var dataTable = [
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
                        <TableCell className={classes.head}>ID:</TableCell>
                        <TableCell className={classes.head} numeric>Name:</TableCell>
                        <TableCell className={classes.head} numeric>Lastname</TableCell>
                        <TableCell className={classes.head} numeric>Location</TableCell>
                        <TableCell className={classes.head} numeric>Email</TableCell>
                        <TableCell className={classes.head} numeric>Status</TableCell>
                        <TableCell className={classes.head} numeric>Role</TableCell>

                    </TableRow>
                </TableHead>
                <TableBody>
                    {dataTable.map(n => {
                        return (
                            <TableRow key={n.id}>
                                <TableCell className={classes.innerRow} component="th" scope="row">
                                    {n.id}
                                </TableCell>
                                <TableCell className={classes.innerRow} numeric>{n.name}</TableCell>
                                <TableCell className={classes.innerRow} numeric>{n.lastname}</TableCell>
                                <TableCell className={classes.innerRow} numeric>{n.location}</TableCell>
                                <TableCell className={classes.innerRow} numeric>{n.email}</TableCell>
                                <TableCell className={classes.innerRow} numeric>{n.status}</TableCell>
                                <TableCell className={classes.innerRow} numeric>{n.role}</TableCell>
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
