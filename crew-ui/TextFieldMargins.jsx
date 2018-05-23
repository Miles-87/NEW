import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';

const styles = theme => ({
    container: {

        flexWrap: 'wrap',
    },
    textField: {
        marginLeft: theme.spacing.unit,
        marginRight: theme.spacing.unit,
        width: 200,
    },
});

const TextFieldMargins = props => {
    const { classes } = props;

    return (
        <modal>
        <div className={classes.container}>
            <TextField
                label="Name"
                id="margin-none"
                defaultValue="John"
                className={classes.textField}
                helperText="Pleas enter Your name"
            />
            <TextField
                label="Surname"
                id="margin-dense"
                defaultValue="Doe"
                className={classes.textField}
                helperText="Pleas enter Your surname"
                margin="dense"
            />
            <TextField
                label="Location"
                id="margin-normal"
                defaultValue="Warsaw"
                className={classes.textField}
                helperText="Pleas enter Your Location"
                margin="normal"
            />
            <TextField
                label="Email"
                id="margin-normal"
                defaultValue="example@email.com"
                className={classes.textField}
                helperText="Pleas enter Your email"
                margin="normal"
            />
            <TextField
                label="Status"
                id="margin-normal"
                defaultValue="Remote"
                className={classes.textField}
                helperText="Pleas enter is Your status"
                margin="normal"
            />
            <TextField
                label="Role"
                id="margin-normal"
                defaultValue="Admin"
                className={classes.textField}
                helperText="Pleas enter Your role in team"
                margin="normal"
            />
        </div>
    );
};

TextFieldMargins.propTypes = {
    classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(TextFieldMargins);
