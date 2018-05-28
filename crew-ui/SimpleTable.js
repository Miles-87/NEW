import React from 'react';
import PropTypes from 'prop-types';
import {withStyles} from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';


{/*
   @author Wiktor Religo
 * @since 22.05.2018*/
}

const styles = theme => ({
    root: {
        width: '100%',
        marginTop: theme.spacing.unit * 3,
        overflowX: 'auto',
    },
    table: {
        minWidth: 700,
    },
    head: {
        fontSize: '20px',
    },
    innerRow: {
        fontSize: '15',
    }

});

let id = 0;

export function createData(name, city, description, headcount) {
    id += 1;
    return {id, name, city, description, headcount};
}

export var dataTable = [
    createData("Cebule z Polski", "Kraków", "Kilka danych o drużynie ", 12),
    createData("Pierogi jak u Mamy", "Rzeszów", "Kilka danych odrużynie", 15),
    createData("Koksy z Huty", "Kraków", "Kilka danych odrużynie", 32),
    createData("Wiemy że nie wiemy", "Warszawa", "Kilka danych odrużynie", 11),
    createData("Grubi Anorektycy", "Poznań", "Kilka danych odrużynie", 56),
];


function SimpleTable(props) {
    const {classes} = props;
    return (
        <Paper className={classes.root}>
            <Table>
                <TableHead>
                    <TableRow>
                        <TableCell className={classes.head}>ID:</TableCell>
                        <TableCell className={classes.head} numeric>Name:</TableCell>
                        <TableCell className={classes.head} numeric>City</TableCell>
                        <TableCell className={classes.head} numeric>Description</TableCell>
                        <TableCell className={classes.head} numeric>Headcount</TableCell>
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
                                <TableCell className={classes.innerRow} numeric>{n.city}</TableCell>
                                <TableCell className={classes.innerRow} numeric>{n.description}</TableCell>
                                <TableCell className={classes.innerRow} numeric>{n.headcount}</TableCell>
                            </TableRow>
                        );
                    })}
                </TableBody>
            </Table>
        </Paper>
    );
}

SimpleTable.propTypes = {
    classes: PropTypes.object.isRequired,
};
export default withStyles(styles)(SimpleTable);
