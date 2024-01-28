//https://www.w3schools.com/jsref/jsref_sort.asp
//https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/sort

function arrayTests(){
    //      this is an array , will sort is
          var arr = [ 1, 3, 2];
          console.log(arr.sort());
    //      print the first, last item
          console.log(arr[0]);
          console.log(arr[arr.length-1]);

          var a = ["a", "b", "c"];
          a.forEach(function(entry) {
            console.log(entry);
          });


    // print one by one , copy an array, remove item
}


const friendsArray = [
    {
        name: "John",
        age: 19,
    },
    {
        name: "Candy",
        age: 18,
    },
    {
        name: "mandy",
        age: 20,
    },
];

//helyett 1 api pontot hivni parameterezve
const urlArray = [
    {name : "http://localhost/designpatterns"},
     {name: "http://localhost/basicalgos"},
      {name: "http://localhost/sysdesign"},
];
