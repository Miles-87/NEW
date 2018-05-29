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
    innerRow: {
        fontSize: '15',
        color: 'black',
        textAlign: 'left',
    }

});

let id = 0;

export function dataTable(firstName, lastName, location, mail, status, role) {
    id += 1;
    return {id, firstName, lastName, location, mail, status, role};
}


class NextPersonTable extends React.Component {
    constructor() {
        super();
        this.state = {
            personData: []
        }
    }

    componentDidMount() {
        this.fetchTableData();
    }

    fetchTableData() {
        fetch('http://localhost:9090/people')
            .then(response => response.json())
            .then(data => {
                this.setState({personData: data});
            });
    }

    render() {
        return (
            <Paper>
                <Table>
                    <TableHead>
                        <TableRow>
                            <TableCell style={styles.head}>ID:</TableCell>
                            <TableCell style={styles.head}>Name:</TableCell>
                            <TableCell style={styles.head}>Lastname</TableCell>
                            <TableCell style={styles.head}>Location</TableCell>
                            <TableCell style={styles.head}>Email</TableCell>
                            <TableCell style={styles.head}>Status</TableCell>
                            <TableCell style={styles.head}>Role</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {this.state.personData.map(n => {
                            return (
                                <TableRow key={n.id}>
                                    <TableCell style={styles.innerRow} component="th" scope="row">
                                        {n.id}
                                    </TableCell>
                                    <TableCell numeric style={styles.innerRow}>{n.firstName}</TableCell>
                                    <TableCell numeric style={styles.innerRow}>{n.lastName}</TableCell>
                                    <TableCell numeric style={styles.innerRow}>{n.location}</TableCell>
                                    <TableCell numeric style={styles.innerRow}>{n.email}</TableCell>
                                    <TableCell numeric style={styles.innerRow}>{n.status}</TableCell>
                                    <TableCell numeric style={styles.innerRow}>{n.role}</TableCell>
                                </TableRow>
                            );
                        })}
                    </TableBody>
                </Table>
            </Paper>
        );
    }
}

NextPersonTable.propTypes = {
    classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(NextPersonTable);
