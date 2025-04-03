# Javascript
- why js
  - front end
  - backend
  - mobile app deve
  - game deve - not strong
  - AI
  - Robotics
  - IOT
- in vs code add material icon theme
- alert("..);
- console.log("..");
- comments
  - //
  - /*  ..   */
### Variables
  - var
    - old way
    - Function scope
    - can reclare
  - let 
    - modern way
    - block scope (like inside loop or if )
    - can't redeclar in same scope
  - const
    - for constand storage
###  Data type
  - string
  - Number
  - Boolean
  - Undefined
  - Null
  - Object  { : }
  - Array  []
  - Function
### Types
  - alert(typeof [ 12,34])
### BIDMAS
  - Brackets
  - Indices*,**
  - Division and Multiplication (from left to right)
  - Addition and Subtraction (from left to right)
### string
```js
  let message = firstName + " " + lastName;
  console.log(message.length);  // Output: 5 -  property not a method
  console.log(message[0]);  // Output: H
  let str = "hello";
  console.log(str.toUpperCase()); // Output: "HELLO"
  console.log(str.toLowerCase()); // Output: "hello"
  console.log(str.charAt(1)); // Output: "e"
  console.log(str.includes("world")); // Output: false
  let str = "Hello, world!";
  console.log(str.indexOf("world")); // Output: 7
  console.log(str.slice(0, 5));
  console.log(str.substring(0, 5)); // Output: "Hello"
  console.log(str.replace("world", "JavaScript")); // Output: "Hello, JavaScript!"
  let str = "apple,banana,cherry";
  let arr = str.split(",");
  console.log(arr);  // Output: ["apple", "banana", "cherry"]
  console.log(str.trim()); // Output: "Hello, world!"
  console.log(str.repeat(3)); // Output: "abcabcabc"
```
### String template
  - Template literals are enclosed by backticks (`) rather than single (') or double quotes (")
```js
 let name = "Alice";
 let age = 25;
 let message = `Hello, my name is ${name} and I am ${age} years old. ${age + 10} `;
 let message = `This is a multiline
 string that spans
 multiple lines.`;
 console.log(message);
    This is a multiline
    string that spans
    multiple lines.


function tag(strings, ...expressions) {
  console.log(strings); // Array of strings
  console.log(expressions); // Array of expressions
}

let name = "Alice";
let age = 25;

tag`Hello, my name is ${name} and I am ${age} years old.`;
// Output:
// [ 'Hello, my name is ', ' and I am ', ' years old.' ]
// [ 'Alice', 25 ]
```
### Array
```js
let colors = ["red", "green", "blue"];
console.log(colors[0]);  // Output: "red"  (first element)
console.log(colors[2]);  // Output: "blue" (third element)

let mixed = [10, "20", 30.23];

let numbers = [10, 20, 30];
numbers[1] = 25;  // Changing second element
console.log(numbers);  // Output: [10, 25, 30]

console.log(fruits.length);  // Output: 3

numbers.push(4);  
console.log(numbers);  // Output: [1, 2, 3, 4]


let last = numbers.pop(); 
console.log(last);      // Output: 4
console.log(numbers);   // Output: [1, 2, 3]
 
let first = numbers.shift();  // remove first element
console.log(first);     // Output: 1
console.log(numbers);   // Output: [2, 3]

numbers.unshift(1);
console.log(numbers);   // Output: [1, 2, 3]

let result = arr1.concat(arr2);
console.log(result);  // Output: [1, 2, 3, 4]

let sliced = numbers.slice(1, 4);
console.log(sliced);  // Output: [2, 3, 4]

let numbers = [1, 2, 3, 4];
numbers.splice(2, 1, 5, 6);  // At index 2, remove 1 item and add 5 and 6
console.log(numbers);  // Output: [1, 2, 5, 6, 4]

let fruits = ["apple", "banana", "cherry"];
fruits.forEach(function(fruit) {
  console.log(fruit);
});

let numbers = [1, 2, 3];
let doubled = numbers.map(function(num) {
  return num * 2;
});
console.log(doubled);  // Output: [2, 4, 6]

let numbers = [1, 2, 3, 4, 5];
let evenNumbers = numbers.filter(function(num) {
  return num % 2 === 0;
});
console.log(evenNumbers);  // Output: [2, 4]

let numbers = [1, 2, 3, 4];
let sum = numbers.reduce(function(total, num) {
  return total + num;
}, 0);
console.log(sum);  // Output: 10

let numbers = [5, 10, 15, 20];
let found = numbers.find(function(num) {
  return num > 10;
});
console.log(found);  // Output: 15

let numbers = [1, 2, 3, 4];
let hasEven = numbers.some(function(num) {
  return num % 2 === 0;
});
console.log(hasEven);  // Output: true

let numbers = [2, 4, 6, 8];
let allEven = numbers.every(function(num) {
  return num % 2 === 0;
});
console.log(allEven);  // Output: true

let nestedArray = [[1, 2], [3, 4], [5, 6]];
console.log(nestedArray[0]);  // Output: [1, 2]
console.log(nestedArray[1][1]);  // Output: 4

// array destructing
let colors = ["red", "green", "blue"];
let [first, second] = colors;
console.log(first);  // Output: "red"
console.log(second); // Output: "green"


```
### undefined and null
```js


```
###

###

###

###

###

###

###

###
