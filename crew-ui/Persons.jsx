import React from 'react';
import NextPersonTable from './NextPersonTable.js';
import DialogPanel from "./DialogPanel";
import {NavigationMenu} from "./TeamPage.js";


{/*
   @author Mateusz Michonski
   @author Wiktor Religo 
 * @since 21.05.2018*/
}

class Persons extends React.Component {

    constructor() {
        super();
        this.personAddedCallback = () => {
            this.tableRef.updateTableWithNewData();
        }
    }


    render() {
        return (
            <div>
                <NavigationMenu/>
                <NextPersonTable onRef={ref => {
                    (this.tableRef = ref);
                }}
                />
                <DialogPanel onSave={this.personAddedCallback}/>
            </div>

        );
    }

}
export default Persons;

