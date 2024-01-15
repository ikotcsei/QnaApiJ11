import React, { Component } from 'react';
import axios from 'axios';

class App extends Component{

    state = {
        persons: [],
        szam : 1,

      }

    componentDidMount() {
        console.log("component did mount, call to localhost");

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

        console.log(Object.keys(this.state.persons));
    }

   render(){


//      var alist;
//
//      if( isEmpty(alist) ){
//                    console.log("links list is empty.");
//                    if(alist === undefined){
//                        console.log("list is undefined.");
//                    }
//                  } else{
//                    console.log("links list is not empty");
//      }




//      console.log("links lista  type: " + typeof this.state.persons.links);
//      console.log(Object.keys(this.state.persons));
//      console.log("links lista : " + this.state.persons.links);
      const links = this.state.persons.links;
      const reptiles = ['alligator', 'snake', 'lizard'];

//        objectMethods(this.state.persons);


      return(
         <div>
            <h1>{this.state.persons.question}</h1>
            <div className="content" dangerouslySetInnerHTML={{__html: this.state.persons.htmlAnswer}}></div>
            <pre>{JSON.stringify(this.state.persons, null, 2)}</pre>

         </div>


      );

   }


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

//https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/keys
function objectMethods( list ){
    console.log("Object.keys");
    console.log(Object.keys(list));
    console.log("Object.values");
    console.log(Object.values(list));



}

function runTests(){

    const object1 = {
        a: 'somestring',
        b: 42,
    };

    var object2 ={};

    if( jsonIsEmpty(object1) ){
        console.log("jsonObj is empty.");
    } else{
        console.log("jsonObj is not empty");
    }

    if( jsonIsEmpty(object2) ){
            console.log("jsonObj is empty.");
          } else{
            console.log("jsonObj is not empty");
    }

    var obji1;
            var obji2 = 2;

            if(objectIsUndefined(obji1)){
                console.log("undefined object .");
            } else{
              console.log("object is definded.")
            }

            if(objectIsUndefined(obji2)){
                        console.log("undefined object .");
            }else{
                       console.log("object is definded.")
            }
}


export default App;