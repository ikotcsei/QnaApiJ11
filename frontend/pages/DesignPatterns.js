import LinkList from './common.js';
import { Link } from 'react-router-dom';
import { useLoaderData } from 'react-router-dom';

function DesignPatterns(){

    const tetel = useLoaderData();
    console.log(tetel);

    return (
          <div>
              <div className="question">{tetel.question}</div>
              <div className="answer" dangerouslySetInnerHTML={{__html: tetel.htmlAnswer}}></div>
              <div className="links">{LinkList(tetel.links)}</div>
              <div>{PictureList(tetel.images)}</div>
          </div>
        );

}

//function rendering the list of links
//<a target="_self" href="https://www.youtube.com" >YT player</a>
//function LinkList(propsList) {
//
//    if(isEmpty(propsList) || objectIsUndefined(propsList)){
//        return;
//    }
//
//    const linkItems = propsList.map( (link) =>    <li> <a href={link.url}> {link.name} </a> </li> );
//    return (
//        <ul>{linkItems}</ul>
//    );
//
//}


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


export default DesignPatterns;