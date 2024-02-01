//https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/JSON/parse

//get a json array item to a javascript array

{/* prettypring json function*/}
function prettyJson(jsonInput){
    return <pre>{JSON.stringify(jsonInput, null, 2)}</pre>
}