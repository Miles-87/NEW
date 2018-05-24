import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import Save from "@material-ui/icons/es/Save";
import Delete from "@material-ui/icons/es/Delete";

class DialogPanel extends React.Component {
    constructor() {
        super()
        this.state = {
            open: false,
            name: '',
            description: '',
            city: '',
            headcount: '',
        };
        this.handleClickOpen = () => {
            this.setState({open: true});
        };

        this.handleClose = () => {
            this.setState(
                {
                    open: false,
                    name: 'Test',
                    description: 'Test2',
                    city: 'Kraków',
                    headcount: '22',
                },
            )
            ;

        };
    }


    render() {
        return (
            <div style={{marginTop: '15px'}}>
                <Button variant="raised" color="secondary" aria-label="add" onClick={this.handleClickOpen}>Add Team</Button>
                <Dialog
                    open={this.state.open}
                    onClose={this.handleClose}
                    aria-labelledby="form-dialog-title"
                >
                    <DialogTitle id="form-dialog-title">Adding Team to table: </DialogTitle>
                    <DialogContent>
                        <DialogContentText>
                            Please fill the form with correct data about your Team.
                        </DialogContentText>
                        <TextField
                            autoFocus
                            margin="dense"
                            id="name"
                            label="Name of the team"
                            type="text"
                            fullWidth
                        />
                        <TextField
                            autoFocus
                            margin="dense"
                            id="city"
                            label="City"
                            type="text"
                            ref={this.city}
                            fullWidth
                        />
                        <TextField
                            autoFocus
                            margin="dense"
                            id="description"
                            label="Description"
                            type="text"
                            fullWidth
                        />
                        <TextField
                            autoFocus
                            margin="dense"
                            id="headcount"
                            label="Headcount"
                            type="number"
                            fullWidth
                        />
                    </DialogContent>
                    <DialogActions>
                        <Button variant="raised" color="secondary" onClick={this.handleClose} color="secondary">
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