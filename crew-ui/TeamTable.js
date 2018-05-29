import React from 'react';
import {withStyles} from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import * as theme from "material-ui/styles/index";


{/*
   @author Wiktor Religo
 * @since 22.05.2018*/
}

const styles = {
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
        color: 'black',
        textAlign: 'left',
    }
};

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

class TeamTable extends React.Component {
    constructor() {
        super();
        this.state = {
            teamData: []
        }
    }

    componentDidMount() {
        this.fetchDataToTable();
    }

    fetchDataToTable() {
        fetch('http://localhost:9090/teams')
            .then(response => response.json())
            .then(data => {
                this.setState({teamData: data});
            });
    }

    render() {
        return (
            <Paper style={styles.root}>
                <Table>
                    <TableHead>
                        <TableRow>
                            <TableCell style={styles.head}>ID:</TableCell>
                            <TableCell style={styles.head}> Name:</TableCell>
                            <TableCell style={styles.head}>City:</TableCell>
                            <TableCell style={styles.head}>Description: </TableCell>
                            <TableCell style={styles.head}>Headcount</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {this.state.teamData.map(n => {
                            return (
                                <TableRow key={n.id}>
                                    <TableCell style={styles.innerRow} component="th" scope="row">
                                        {n.id}
                                    </TableCell>
                                    <TableCell numeric style={styles.innerRow}>{n.name}</TableCell>
                                    <TableCell numeric style={styles.innerRow}>{n.city}</TableCell>
                                    <TableCell numeric style={styles.innerRow}>{n.description}</TableCell>
                                    <TableCell numeric style={styles.innerRow}>{n.headcount}</TableCell>
                                </TableRow>
                            );
                        })}
                    </TableBody>
                </Table>
            </Paper>
        );
    }
}

export default withStyles(styles)(TeamTable);
