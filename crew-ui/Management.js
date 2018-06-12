import React from 'react';
import Board from "./testUtils/Board";
import {NavigationMenu} from "./TeamPage";

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
            </div>
        );
    }
}
export default Management;
