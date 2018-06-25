import React, {Component} from 'react';
import TeamAsList from './TeamAsList.js';
import {DragDropContext} from 'react-dnd';
import HTML5Backend from 'react-dnd-html5-backend';

{/*
   @author Wiktor Religo
 * @since 07.06.2018*/
}

class Board extends Component {

    constructor() {
        super()
        this.state = {
            dataStore: [],
            teamStore: [],
        }
    }






    
    render() {


        const style = {
            board: {
                display: "flex",
                justifyContent: "space-around",
                paddingTop: "20px"
            }
        };

        const listOne = [
            {id: 1, teamPosition: "Developer", personName: "Krystian Wolski"},
            {id: 2, teamPosition: "Tester", personName: "Ala Mala"},
            {id: 3, teamPosition: "Grafik", personName: " John Smith"},
            {id: 10, teamPosition: "UIX", personName: " John Smith2"},
            {id: 11, teamPosition: "Motywator", personName: " Tomek Baby"},
        ];

        const listTwo = [
            {id: 4, teamPosition: "Grafik", personName: "Olga Wojga"},
            {id: 5, teamPosition: "Developer", personName: "Tomek Wariat"},
            {id: 6, teamPosition: "Tester", personName: "Wiktor Byc"}
        ];

        const listThree = [
            {id: 7, teamPosition: "Tester", personName: "Maciek Wójcik"},
            {id: 8, teamPosition: "Developer", personName: "Wojtek Tkacz"},
            {id: 9, teamPosition: "Grafik", personName: "Bartek Bóbr"}
        ];

        return (
            <div style={style.board}>
                <TeamAsList teamName={"Ninjas"} id={1} list={listOne}/>
                <TeamAsList teamName={"Grube Baby"} id={2} list={listTwo}/>
                <TeamAsList teamName={"Mistrzowie Jedi"} id={3} list={listThree}/>
            </div>
        );
    }
}

export default DragDropContext(HTML5Backend)(Board);