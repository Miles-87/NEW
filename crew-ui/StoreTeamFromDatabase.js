import React from 'react';

class StoreTeamFromDatabase extends React.Component {
    constructor() {
        super();
        this.state = {
            teams: []
        };
    }

    componentDidMount() {
        fetch('http://localhost:8080/teams')
            .then(response => response.json())
            .then(teamData => this.setState({
                teams: teamData,
            }));
    }
}

export default StoreTeamFromDatabase;