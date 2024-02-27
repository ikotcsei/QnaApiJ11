import React, { Component ,useState ,useEffect }  from 'react';
import { Link } from "react-router-dom";
import axios from "axios";

import { testOnMobileURL } from './globals.js';

//add function component call to backend
//https://codedamn.com/news/reactjs/axios-network-requests

//query api for links to generate ,
function Alllinks() {
    // State to store the fetched data
    const [data, setData] = useState([]);

    const urls = useState(urlArray);

    console.log("hello from func. commponent");
    console.log(urls);
    console.log(urlArray);



    // Call fetchData on component mount
    useEffect(() => {

      axios.get(testOnMobilePhone + "jsontest",{
                             headers: {
                             "Access-Control-Allow-Origin" : "*"  }
                             }
              ).then(res => {
                  setData(res.data);
              })
              .catch((error) => {
                    console.log(error.message)
              })

      console.log("use effect data : " + data);
      console.log(globalsVarTest)
    }, []);



    return (
        <div>
            <div>
                Not working, will be used with dynamic routing.
                {
                    urls[0].map(url => (<Link className="genLink"  to={url.name}> {url.name} </Link> ))
                }
                <div><br /></div>
             </div>
        </div>
    );

}



//helyett 1 api pontot hivni parameterezve
const urlArray = [
    {name : "http://localhost/designpatterns"},
     {name: "http://localhost/basicalgos"},
      {name: "http://localhost/sysdesign"},
];


export default Alllinks;