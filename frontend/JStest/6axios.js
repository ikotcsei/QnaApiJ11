//anxios error handling like a boss
//https://dev.to/mperon/axios-error-handling-like-a-boss-333d



function checkIfJsonResponseIsOKorHasError(){

    const fetchPromise = fetch(url, { method: 'PUT', ...yourParams });

    fetchPromise.then(response => {
      if (response.ok()){
        //Your request was successful
        const jsonPromise = response.json();
        jsonPromise.then(data => {
          console.log("Successful request, parsed json body", data);
        }).catch(error => {
          //error handling for json parsing errors (empty body etc.)
          console.log("Successful request, Could not parse body as json", error);
        })
      } else {
        //Your request was not successful
        /*
         You can check the body of the response here anyways. Maybe your api does return a json error?
        */
      }
    }).catch(error => {
      //error handling for fetch errors
    }))

}