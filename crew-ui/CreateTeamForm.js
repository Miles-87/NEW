import React from 'react';
import PropTypes from 'prop-types';
import {withStyles} from '@material-ui/core/styles';
import Input from '@material-ui/core/Input';
import InputLabel from '@material-ui/core/InputLabel';
import FormHelperText from '@material-ui/core/FormHelperText';
import FormControl from '@material-ui/core/FormControl';

const styles = theme => ({
    container: {
        width: '70%',
        backgroundColor: '#FFFDE7',
        margin: 'auto',
        display: 'flex',
        flexWrap: 'wrap',
        justifyContent: 'center',
    },
    formControl: {
        margin: theme.spacing.unit,
    },
});

class CreateTeamForm extends React.Component {
    constructor() {
        super();
        this.state = {
            name: 'Uzupełnij pole',
        };
    }

    render() {
        const {classes} = this.props;

        return (
            <div className={classes.container}>
                <FormControl className={classes.formControl}>
                    <InputLabel htmlFor="name-simple">Team name: </InputLabel>
                    <Input id="name-simple" value={this.state.name} onChange={this.handleChange}/>
                    <FormHelperText id="name-error-text">Required ! </FormHelperText>
                </FormControl>
                <FormControl className={classes.formControl}>
                    <InputLabel htmlFor="name-helper">Description:</InputLabel>
                    <Input id="name-helper" value={this.state.name} onChange={this.handleChange}/>
                    <FormHelperText id="name-helper-text">Short text about your team</FormHelperText>
                </FormControl>
                <FormControl className={classes.formControl}>
                    <InputLabel htmlFor="name-simple">City</InputLabel>
                    <Input id="name-simple" value={this.state.name} onChange={this.handleChange}/>
                    <FormHelperText>Headquarters</FormHelperText>
                </FormControl>
                <FormControl className={classes.formControl} error aria-describedby="name-error-text">
                    <InputLabel htmlFor="name-error">Headcount: </InputLabel>
                    <Input id="name-error" value={this.state.name} onChange={this.handleChange}/>
                    <FormHelperText id="name-error-text">Required number ! </FormHelperText>
                </FormControl>
            </div>
        );
    }
}

CreateTeamForm.propTypes = {
    classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(CreateTeamForm);