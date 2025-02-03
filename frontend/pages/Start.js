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
        <h2>todo</h2>
        <p>
           - hozzaadni  sorbant, legyszi ! <br/>
                -be : endpointok    <br/>
                -fe : 4 lap fetch + css <br/>
           -  fetch api and genarate links <br/>
           -  wait 4 server response until render <br/>
        </p>
      </div>
    );
}

export default Start;