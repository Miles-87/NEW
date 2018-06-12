import React from 'react';
import PropTypes from 'prop-types';
import {withStyles} from '@material-ui/core/styles';
import Avatar from '@material-ui/core/Avatar';

const styles = {
    row: {
        justifyContent: 'center',
        maxWidth: '30%',
    },
    avatar: {
        margin: 10,
    },
};

function ImageAvatars(props) {
    const {classes, teamName } = props;
    return (
        <div className={classes.row}>
            <Avatar alt="Remy Sharp" src="./avatar.png" className={classes.avatar}/>
            <p style={{color: 'red', fontWeight: 'bold'}}>{teamName}  </p>
        </div>
    );
}

ImageAvatars.propTypes = {
    classes: PropTypes.object.isRequired,
    teamName: PropTypes.object.isRequired,
};
export default withStyles(styles)(ImageAvatars);