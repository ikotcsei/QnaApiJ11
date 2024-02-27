import React, { Component } from 'react';
import Alllinks from './alllinks.js';
import axios from 'axios';
import {
      BrowserRouter as Router,
      Route,
      Routes,
      Link
} from 'react-router-dom';
import './styles.css';
import Example from './slideshow.js';

import { testOnMobilePhone, testServerUrl, productionURL } from './globals.js';



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

        axios.get(testOnMobilePhone + "/jsontest",{
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
      <Router>
         <div>
            <nav>
                      <ul>
                     <li>
                       <Link to="/start">Start</Link>
                     </li>
                     <li>
                        <Link to="/alllinks">Alllinks</Link>
                      </li>
                   </ul>
                 </nav>

            <div className="question">{this.state.tetel.question}</div>
            <div className="answer" dangerouslySetInnerHTML={{__html: this.state.tetel.htmlAnswer}}></div>

            <Example input={this.state.tetel.images} />

            <div className="links">{LinkList(this.state.tetel.links)}</div>

            <div>{PictureList(this.state.tetel.images)}</div>

                    <Routes>
                      <Route path="/start" element={<Start />} />
                      <Route path="/alllinks" element={<Alllinks />} />
                    </Routes>

         </div>
      </Router>


      );

   }


}



function Start() {
  return (
      <div style={{ padding: 20 }}>
        <h2>Start</h2>
        <p>designpatterns <br />
           basicalgos <br />
           sysdesign.... <br />
        </p>
      </div>
    );
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

    const linkItems = propsList.map( (piclink) =>    <li> <img className="image" src={piclink} width="800" height="700" /> </li> );
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