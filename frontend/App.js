import React, { Component } from 'react';
import axios from 'axios';

class App extends Component{

    state = {
        persons: []
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
//            this.setState({ persons });
        })
    }

   render(){
      console.log(typeof persons);

      return(
         <div>
            <h1>Hello Geeks</h1>
         </div>
      );

   }


}
export default App;