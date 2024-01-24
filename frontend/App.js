import React, { Component } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import './styles.css';
import Example from './slideshow.js';

// !!!!!!!!!!!!!!!!!!!!!!!!   CTRL + F5 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
const productionURL = "http://ezittegybukfenc.de:8080/QA/";

const testServerURL = "http://localhost:8080";

const testServerURL2 = "http://localhost:8081";

//need to set crossorigins on the backend for the phone
const testOnMobilePhone ="http://192.168.0.153:8080";

class App extends Component{
    /*
        tetel  = Object{
            question
            answer
            ...
            links []    array
            images[]   array
         }
    */

    state = {
        tetel: [],
        szam : 1,

      }

    componentDidMount() {

        axios.get(testServerURL + "/jsontest",{
                       headers: {
                       "Access-Control-Allow-Origin" : "*"  }
                       }
        ).then(res => {
            const tetel = res.data;
            console.log(tetel);
            this.setState({ tetel });
        })
        .catch((error) => {
              console.log(error.message)
        })

    }

   render(){

      const links = this.state.tetel.links;
      console.log("tetel.images = imageList.input : " + this.state.tetel.images)

      return(
         <div>
            <div className="question">{this.state.tetel.question}</div>
            <div className="answer" dangerouslySetInnerHTML={{__html: this.state.tetel.htmlAnswer}}></div>

            <Example input={this.state.tetel.images} />

            <div className="links">{LinkList(this.state.tetel.links)}</div>

            <div>{PictureList(this.state.tetel.images)}</div>

         </div>


      );

   }


}

function prettyJson(jsonObj){
    return <pre>{JSON.stringify(jsonObj, null, 2)}</pre>;
}

//function rendering the list of links
//<a target="_self" href="https://www.youtube.com" >YT player</a>
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

    const linkItems = propsList.map( (piclink) =>    <li> <img src={piclink} width="800" height="700" /> </li> );
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