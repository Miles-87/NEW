import React from 'react';
import {withStyles} from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import PropTypes from 'prop-types';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';


const styles = theme => ({
    root: {
        width: '10%',
        marginTop: theme.spacing.unit * 3,
        overflowX: 'auto',
        color: 'red',
    },
    table: {
        minWidth: '100',
    },
    innerRow: {
        fontSize: '15',
        color: 'red',
        textAlign: 'left',
    },
    head: {
        fontSize: '15',
        color: 'black',
        textAlign: 'left',
    },
    deleted: {
        textAlign: 'center',
        fontSize: '20px',
    },
    innerLastRow: {
        textAlign: 'center',
    },
    deleteIcon: {
        backgroundColor: '#1e90ff',
        border: 'none',
        color: '#f8f8ff',
        padding: '10px',
        fontSize: '15px',
        cursor: 'pointer',
    },
    anIcon: {
        marginLeft: '10px',
    }



});

let id = 0;

export function dataTable(firstName, lastName, location, email, status, role) {
    id += 1;
    return {id, firstName, lastName, location, email, status, role};
}


class NextPersonTable extends React.Component {
    constructor() {
        super();
        this.state = {
            personData: []
        }
    }

    updateTableWithNewData() {
        this.fetchTableData()
    };

    componentDidMount() {
        this.props.onRef(this);
        this.fetchTableData();
    }

    fetchTableData() {
        fetch('http://localhost:9090/people')
            .then(response => response.json())
            .then(data => {
                this.setState({personData: data});
            });
    }

    deletePersonFromBase(personId) {
        console.log("by id: " + personId);
        fetch('http://localhost:9090/people/' + personId,
            {method: 'DELETE',})
            .then(
                res => this.fetchTableData()
            )
            .catch(err => console.error(err))
    }


    render() {
        const {classes} = this.props;

        return (
            <Paper>
                <Table>
                    <TableHead>
                        <TableRow>
                            <TableCell className={this.props.classes.head} component="th"
                                       scope="row">ID:</TableCell>
                            <TableCell className={this.props.classes.head} component="th"
                                       scope="row">Name:</TableCell>
                            <TableCell className={this.props.classes.head} component="th"
                                       scope="row">Lastname:</TableCell>
                            <TableCell className={this.props.classes.head} component="th"
                                       scope="row">Location:</TableCell>
                            <TableCell className={this.props.classes.head} component="th"
                                       scope="row">Email:</TableCell>
                            <TableCell className={this.props.classes.head} component="th"
                                       scope="row">Status:</TableCell>
                            <TableCell className={this.props.classes.head} component="th"
                                       scope="row">Role:</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {this.state.personData.map(n => {
                            return (
                                <TableRow key={n.id}>
                                    <TableCell component="th" scope="row">
                                        {n.id}
                                    </TableCell>
                                    <TableCell className={this.props.classes.innerRow} component="th"
                                               scope="row">{n.firstName}</TableCell>
                                    <TableCell className={this.props.classes.innerRow} component="th"
                                               scope="row">{n.lastName}</TableCell>
                                    <TableCell className={this.props.classes.innerRow} component="th"
                                               scope="row">{n.location}</TableCell>
                                    <TableCell className={this.props.classes.innerRow} component="th"
                                               scope="row">{n.email}</TableCell>
                                    <TableCell className={this.props.classes.innerRow} component="th"
                                               scope="row">{n.status}</TableCell>
                                    <TableCell className={this.props.classes.innerRow} component="th"
                                               scope="row">{n.role}</TableCell>
                                    <TableCell numeric style={styles.innerLastRow}>
                                        <button onClick={e => {
                                            this.deletePersonFromBase(n.id);
                                        }} style={styles.deleteIcon}>Delete <i className="fa fa-trash" style={styles.anIcon}
                                        ></i>
                                        </button>
                                    </TableCell>

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
    classes: PropTypes.object.isRequired
};

export default withStyles(styles)(NextPersonTable);
