
function LinkList(propsList) {

    if(isEmpty(propsList) || objectIsUndefined(propsList)){
        return;
    }

    const linkItems = propsList.map( (link) =>    <li> <a href={link.url}> {link.name} </a> </li> );
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

export default LinkList;