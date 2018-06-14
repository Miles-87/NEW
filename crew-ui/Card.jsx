import React from 'react';
import PropTypes from 'prop-types';
import {withStyles} from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';
import Avatar from "./Avatar";

{/*
   @author Wiktor Religo
 * @since 07.06.2018*/
}
const styles = theme => ({
    card: {
        display: 'flex',
        backgroundColor: '#87CEFA',
    },
    details: {
        display: 'flex',
        flexDirection: 'column',
    },
    content: {
        flex: '1 0 auto',
    },
});

function TeamCard(props) {
    const {teamName, name, position, classes} = props;

    return (
        <div style={{boxShadow: '6px -4px 27px -2px rgba(0,0,0,1)'}}>
            <Card className={classes.card}>
                <Avatar teamName={teamName}/>
                <div className={classes.details}>
                    <CardContent className={classes.content}>
                        <Typography variant="headline">
                            {name}
                        </Typography>
                        <Typography variant="subheading" color="textSecondary">
                            {position}
                        </Typography>
                    </CardContent>

                </div>
            </Card>
        </div>
    );
}

TeamCard.propTypes = {
    classes: PropTypes.object.isRequired,
    theme: PropTypes.object.isRequired,
    name: PropTypes.object.isRequired,
    position: PropTypes.object.isRequired,
    teamName: PropTypes.object.isRequired,
};

export default withStyles(styles, {withTheme: true})(TeamCard);