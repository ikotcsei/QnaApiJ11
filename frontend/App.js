import React, { Component } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';


class App extends Component{

    state = {
        persons: [],
        szam : 1,

      }

    componentDidMount() {

        axios.get("http://localhost:8081/jsontest",{
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

      return(
         <div>
            <h1>{this.state.persons.question}</h1>
            <div className="content" dangerouslySetInnerHTML={{__html: this.state.persons.htmlAnswer}}></div>
            <pre>{JSON.stringify(this.state.persons, null, 2)}</pre>

            <div>{LinkList(this.state.persons.links)}</div>

         </div>


      );

   }


}

//function rendering the list of links
function LinkList(propsList) {

    if(isEmpty(propsList) || objectIsUndefined(propsList)){
        return;
    }
    console.log("proplista :  " + propsList);

    const linkItems = propsList.map( (link) =>    <li> <a href={link}> {link} </a> </li> );
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