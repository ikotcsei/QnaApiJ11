// https://www.w3schools.com/js/js_datatypes.asp

// Numbers:
let length = 16;
let weight = 7.5;

// Strings:
let color = "Yellow";
let lastName = "Johnson";

// Booleans
let x = true;
let y = false;

// Object:
const person = {firstName:"John", lastName:"Doe"};

// Array object:
const cars = ["Saab", "Volvo", "BMW"];

// Date object:
const date = new Date("2022-03-25");


//Json : typeof jsonPerson : object
const jsonPerson = {firstName:"John", lastName:"Doe", age:50, eyeColor:"blue", cars:["cadillac","wartburg"]};

const emptyObject = {};
console.log("empty object : " + emptyObject);




function typeIsDynamic(){
    let x;       // Now x is undefined
    console.log("let x "  + typeof x);
    x = 5;       // Now x is a Number
    console.log("x = 5 "  + typeof x);
    x = "John";  // Now x is a String
    console.log("x = \"John \" " + typeof x);
}