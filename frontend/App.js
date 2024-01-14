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

        console.log(Object.keys(this.state.persons));
    }

   render(){
      console.log("links lista  type: " + typeof this.state.persons.links);
      console.log(Object.keys(this.state.persons));
      console.log("links lista : " + this.state.persons.links);
      const links = this.state.persons.links;
      const reptiles = ['alligator', 'snake', 'lizard'];

     {/* if (typeof links === undefined ) {
         console.log("undefined : ");
      }else {
         console.log("defined" + links);
      }*/}

      return(
         <div>
            <h1>{this.state.persons.question}</h1>
            <div className="content" dangerouslySetInnerHTML={{__html: this.state.persons.htmlAnswer}}></div>

         </div>


      );

   }


}
export default App;