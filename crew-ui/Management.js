import React from 'react';
import Card from "./Card.jsx";
import {NavigationMenu} from "./TeamPage";


{/*
   @author Wiktor Religo
 * @since 05.06.2018*/
}


export class Management extends React.Component {
    constructor() {
        super()
        this.state = {
            items: [
                {no: "1", text: <Card/>},
                {no: "2", text: <Card/>},
                {no: "3", text: <Card/>},
                {no: "4", text: <Card/>}
            ],
            rightContainer: [],
            leftContainer: []
        }


        this.onDragStart = (event, value) => {
            event.dataTransfer.dropEffect = "move";
            event.dataTransfer.setData("text/plain", value);
        }

        this.allowDrop = event => {
            event.preventDefault();
        }

        this.onDropLeft = event => {
            event.preventDefault();
            let {leftContainer} = this.state;
            const data = event.dataTransfer.getData("text/plain");

            this.state.items.map((obj) => {
                if (obj.no == data) {
                    leftContainer.push(obj.text);
                    this.state.items.pop(data)
                    this.setState({leftContainer});
                    this.setState(
                        {
                            items: this.state.items
                        }
                    )
                }
            })
        }

        this.onDropRight = event => {
            event.preventDefault();
            const data = event.dataTransfer.getData("text/plain");
            let {rightContainer} = this.state;
            this.state.items.map((obj) => {
                if (obj.no == data) {
                    rightContainer.push(obj.text);
                    this.state.items.pop(data)
                    this.setState({rightContainer});
                    this.setState(
                        {
                            items: this.state.items
                        }
                    )
                }
            })
        }

    }

    render() {
        const {items, leftContainer, rightContainer} = this.state;

        return (
            <div>
                <NavigationMenu/>
                <div style={secondStyles.droppable}>
                    <div style={secondStyles.left} onDragOver={this.allowDrop} onDrop={this.onDropLeft}>Left Container
                        {
                            leftContainer.map(itm => {
                                return <p>{itm}</p>
                            })
                        }
                    </div>
                    <div style={secondStyles.right} onDragOver={this.allowDrop} onDrop={this.onDropRight}>Right Container
                        {
                            rightContainer.map(itm => {
                                return <p>{itm}</p>
                            })
                        }
                    </div>
                    <div style={secondStyles.mainInner}>Main
                        <div style={{marginTop: '55px'}}>
                            <div style={{display: 'inline-block'}}>
                                {
                                    items.map((item) => {
                                        return <p draggable="true"
                                                  onDragStart={(e) => this.onDragStart(e, item.no)}>{item.text}</p>
                                    })
                                }
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export const styling = {
    list: {
        backgroundColor: '#3f51b5',
        width: '100%',
        minWidth: 450,
        minHeight: 75,
    },
    link: {
        textDecoration: 'none',
    },
    button: {
        marginLeft: 20,
        marginRight: 20,
        width: 200,
        paddingLeft: '25px',
        border: '1.5px solid #00BFFF',
        color: 'white',
        textAlign: 'center',
        letterSpacing: 1.8,
        fontWeight: 'bold',
    }
}

export const secondStyles = {
    left: {
        marginLeft: '50px',
        marginTop: '50px',
        width: '350px',
        height: '850px',
        border: '3px solid white',
        float: 'left'

    },
    right: {
        marginTop: '50px',
        width: '350px',
        height: '850px',
        border: '3px solid white',
        float: 'left',
        marginLeft: '40px'
    },
    mainInner: {
        marginTop: '50px',
        width: '450px',
        height: '850px',
        border: '1px solid #DCDCDC',
        float: 'right',
        marginRight: '25px'
    },
    droppable: {
        marginTop: 20,
        width: '75%',
        display: 'inline-block',
        height: '1000px',
        backgroundColor: 'grey',
    },
    para: {
        marginRight: '11px',
        border: '1px solid #DCDCDC',
        padding: '12px 16px',
        borderRadius: '50%',
        width: '75px',
        float: 'left'
    }
}


export default Management;
