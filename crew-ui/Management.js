import React from 'react';
import {NavigationMenu} from "./TeamPage";
import Board from "./dnd-components/Board.js";

{/*
   @author Wiktor Religo
 * @since 05.06.2018*/
}

class Management extends React.Component {
    constructor() {
        super()
    }

    render() {
        return (
            <div>
                <NavigationMenu/>
                <Board/>
            </div>
        );
    }
}
export default Management;
