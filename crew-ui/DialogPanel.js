import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import AddIcon from '@material-ui/icons/Add';
import Save from "@material-ui/icons/es/Save";
import Delete from "@material-ui/icons/es/Delete";
import {dataTable} from "./NextPersonTable";

class DialogPanel extends React.Component {
    constructor() {
        super();
        this.state = {
            open: false,
            name: '',
            lastname: '',
            location: '',
            email: '',
            status: '',
            role: '',
        };
        this.handleClickOpen = () => {
            this.setState({open: true});
        };

        this.handleClose = () => {
            this.setState({open: false});
            this.publish();
        };
    }

    handleChanges({target}) {
        this.setState(
            {
                [target.name]: target.value
            }
        )

    }
    addPersonToDatabase(personProps) {
        fetch('http://localhost:9090/people',
            {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': '*',
                    'mode': 'no-corse',
                },
                body: JSON.stringify(personProps)
            }).then(
            resp => window.location.reload()
        ).catch(err => console.error(err))
    }


    publish() {
        console.log("Data:" + this.state.name, this.state.lastname, this.state.location, this.state.email, this.state.status, this.state.role);
        //dataTable.push(createData(this.state.name, this.state.lastname, this.state.location, this.state.email, this.state.status, this.state.role));
        // ReactDOM.render(<Persons/>, document.getElementById('app'));
        this.addPersonToDatabase(dataTable(this.state.name, this.state.lastname, this.state.location, this.state.email, this.state.status, this.state.role));
    }



    render() {
        return (
            <div style={{marginTop: '15px'}}>
                <Button variant="raised" color="primary" aria-label="add"
                        onClick={this.handleClickOpen}><AddIcon/></Button>
                <Dialog
                    open={this.state.open}
                    onClose={this.handleClose}
                    aria-labelledby="form-dialog-title"
                >
                    <DialogTitle id="form-dialog-title">Adding person to table: </DialogTitle>
                    <DialogContent>
                        <DialogContentText>
                            Pleas fill data.
                        </DialogContentText>
                        <TextField
                            autoFocus
                            margin="dense"
                            name="name"
                            label="Name"
                            type="text"
                            fullWidth
                            value={this.state.name}
                            onChange={this.handleChanges.bind(this)}

                        />
                        <TextField
                            autoFocus
                            margin="dense"
                            name="lastname"
                            label="Lastname"
                            type="text"
                            fullWidth
                            value={this.state.lastname}
                            onChange={this.handleChanges.bind(this)}

                        />
                        <TextField
                            autoFocus
                            margin="dense"
                            name="location"
                            label="Location"
                            type="text"
                            fullWidth
                            value={this.state.location}
                            onChange={this.handleChanges.bind(this)}

                        />
                        <TextField
                            autoFocus
                            margin="dense"
                            name="email"
                            label="Email"
                            type="text"
                            fullWidth
                            value={this.state.email}
                            onChange={this.handleChanges.bind(this)}

                        />
                        <TextField
                            autoFocus
                            margin="dense"
                            name="status"
                            label="Status"
                            type="text"
                            fullWidth
                            value={this.state.status}
                            onChange={this.handleChanges.bind(this)}

                        />
                        <TextField
                            autoFocus
                            margin="dense"
                            name="role"
                            label="Role"
                            type="text"
                            fullWidth
                            value={this.state.role}
                            onChange={this.handleChanges.bind(this)}

                        />
                    </DialogContent>
                    <DialogActions>
                        <Button variant="raised" onClick={this.handleClose} color="secondary">
                            Cancel
                            <Delete/>
                        </Button>
                        <Button variant="raised" size="small" onClick={this.handleClose} color="primary">
                            Save
                            <Save/>
                        </Button>
                    </DialogActions>
                </Dialog>
            </div>
        );
    }
}

export default DialogPanel;

