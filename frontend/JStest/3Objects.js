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
    console.log(Object.values( list ));
    console.log("Object.entries");
    console.log(Object.entries( list ))

//    https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/is
//check if object are the same

    console.log(Object.is('1', 1));
    // Expected output: false

    console.log(Object.is(NaN, NaN));
    // Expected output: true

    console.log(Object.is(-0, 0));
    // Expected output: false

    const obj = {};
    console.log(Object.is(obj, {}));
    // Expected output: false

    var a = new Object(undefined);
    var b = new Object(null);

    console.log(a === b);


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