import { Link } from 'react-router-dom';
import { testOnMobilePhone, testServerUrl, productionURL, currentServerURL } from '../globals.js';

async function fetchMoviesBadStatus() {
  const response = await fetch(currentServerURL + 'jsontest');

  if (!response.ok) {
    const message = `An error has occured: ${response.status}`;
    throw new Error(message);
  }

  const tetelJson = await response.json();
  console.log("tetel json : " + JSON.stringify(tetelJson));
  return tetelJson;
}

function Start() {
  return (
      <div>
        <h2>Start, kell ez nekem ?</h2>
        <p>
           -   beegetve 4 alap : sysdsgn, javaalap, basicalgos, designpatterns <br/>
                -be : endpointok    <br/>
                -fe : 4 lap fetch + css <br/>
           -  fetch api and genarate links <br/>
           -  wait 4 server response until render <br/>
//        <h2>
//            <Link to="/designpatterns">designpatterns </Link><br />
//            <Link to="/basicalgos">basicalgos </Link><br />
//            <Link to="/sysdesign">sys design </Link><br />
//            <Link to="/javabasic">java basic </Link><br />
//        </h2>
        </p>
      </div>
    );
}

export default Start;