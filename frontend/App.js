import React, { Component } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import './styles.css';


class App extends Component{

    state = {
        persons: [],
        szam : 1,
//        const queryParameters = new URLSearchParams(window.location.search),
//          const type = queryParameters.get("type"),
//          const name = queryParameters.get("name")

      }

    componentDidMount() {

        axios.get("http://localhost:8080/jsontest",{
                       headers: {
                       "Access-Control-Allow-Origin" : "*"  }
                       }
        ).then(res => {
            const persons = res.data;
            console.log(persons);
            this.setState({ persons });
        })
        .catch((error) => {
              console.log(error.message)
        })

    }

   render(){

      const links = this.state.persons.links;
//      console.log(this.state.type);
//      console.log(this.state.type);

      return(
         <div>
            <div className="question">{this.state.persons.question}</div>
            <div className="answer" dangerouslySetInnerHTML={{__html: this.state.persons.htmlAnswer}}></div>


            <div className="links">{LinkList(this.state.persons.links)}</div>
            <div>{PictureList(this.state.persons.images)}</div>

         </div>


      );

   }


}

function prettyJson(jsonObj){
    return <pre>{JSON.stringify(jsonObj, null, 2)}</pre>;
}

//function rendering the list of links
function LinkList(propsList) {

    if(isEmpty(propsList) || objectIsUndefined(propsList)){
        return;
    }

    const linkItems = propsList.map( (link) =>    <li> <a href={link}> {link} </a> </li> );
    return (
        <ul>{linkItems}</ul>
    );

}

//<img src="mypicture.png">
function PictureList(propsList) {

    if(isEmpty(propsList) || objectIsUndefined(propsList)){
        return;
    }
//    console.log("proplista :  " + propsList);

    const linkItems = propsList.map( (piclink) =>    <li> <img src={piclink} /> </li> );
    return (
        <ul>{linkItems}</ul>
    );

}



function isEmpty( list ){
    if( list && list.length ){
            return false;
    }
    return true;
}

function jsonIsEmpty( jsonObj ){
    return isEmpty(Object.entries( jsonObj ));
}

function objectIsUndefined( object ){
    if( object === undefined){
        return 1;
    }
    return 0;
}




export default App;