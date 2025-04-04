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
let numbers = [1, 2, 3];
let doubled = numbers.map(num =>  {
  return num * 2;
});
let numbers = [1, 2, 3];
let doubled = numbers.map(num => return num * 2);

let numbers = [1, 2, 3];
let doubled = numbers.map(num =>  {
  if ( num % 2 == 0) {
    return num * num;
  }
  else  {
    return num;
  }
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

let numbers = [1, 2, 3, 4];
let sum = numbers.reduce((total, num) => {
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

// sorting
let numbers = [12, 4, 6, 18 , 0 ];
numbers.sort()   // it return 0 12 , 18 , 4 , 6
                  // decause it check the first value

// Correct Sorting (Ascending Order)
let numbers = [5, 1, 9, 3, 7];
numbers.sort((a, b) => a - b);
console.log(numbers);  // Output: [ 1, 3, 5, 7, 9 ]

//  Descending Order
let numbers = [5, 1, 9, 3, 7];
numbers.sort((a, b) => b - a);
console.log(numbers);  // Output: [ 9, 7, 5, 3, 1 ]
// or
let numbers = [5, 1, 9, 3, 7];
numbers.sort((a, b) => a - b).reverse();
console.log(numbers);  // Output: [ 9, 7, 5, 3, 1 ]

// Sorting Arrays of Objects
let students = [
  { name: "John", age: 25 },
  { name: "Alice", age: 20 },
  { name: "Bob", age: 30 }
];
 
students.sort((a, b) => a.age - b.age);
console.log(students);
// Output:
// [
//   { name: 'Alice', age: 20 },
//   { name: 'John', age: 25 },
//   { name: 'Bob', age: 30 }
// ]


let words = ["banana", "Apple", "orange", "Mango"];
words.sort((a, b) => a.toLowerCase().localeCompare(b.toLowerCase()));
console.log(words);  // Output: [ 'Apple', 'banana', 'Mango', 'orange' ]


/// mixed data type
let mixedArray = [10, "Banana", 5, "Apple", 3];
mixedArray.sort((a, b) => {
  if (typeof a === "string" && typeof b === "string") {
    return a.localeCompare(b);
  } else if (typeof a === "number" && typeof b === "number") {
    return a - b;
  }
  return 0;
});
console.log(mixedArray);  // Output: [ 3, 5, 10, 'Apple', 'Banana' ]


// Chaining methods to filter even numbers, double them, and sort the result
let numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
let result = numbers
  .filter(num => num % 2 === 0)  // Filter even numbers
  .map(num => num * 2)           // Double each even number
  .sort((a, b) => a - b);         // Sort the resulting array in ascending order
console.log(result);  // Output: [4, 8, 12, 16, 20]

// inseatd of sort
  .reduce((sum, num) => sum + num, 0);  // Sum up the numbers
  .forEach(num => console.log(num));  // Print each number
  .concat(arr2)       // Concatenate arr1 and arr2
  .slice(2, 5);       // Slice from index 2 to 4 (exclusive)
  .filter(num => num > 10)   // Filter numbers greater than 10
  .find(num => num > 20);     // Find the first number greater than 20
```
### undefined and null
```js
-- undefined
let name;
console.log(name);  // Output: undefined

function greet() {
  // No return statement, so it returns undefined by default
}

let result = greet();
console.log(result);  // Output: undefined

let person = { age: 25 };
console.log(person.name);  // Output: undefined (property doesn't exist)

-- null
let person = null;  // person explicitly has no value (null)
console.log(person);  // Output: null

let book = { title: "JavaScript" };
book.author = null;  // author property is explicitly set to null
console.log(book);  // Output: { title: "JavaScript", author: null }

let a;
let b = null;

console.log(a == b);      // Output: true (both are considered "empty")
console.log(a === b);     // Output: false (different types)
console.log(typeof a);    // Output: "undefined"
console.log(typeof b);    // Output: "object"

console.log(b + 5);       // 5
console.log(b + "Hello");       //nullHello
```
###  comparisons and booleans
```js
console.log(5 == "5");  // Output: true (because "5" is coerced to a number)
console.log(true == 1); // Output: true (because true is coerced to 1)

console.log(5 === "5");  // Output: false (because one is a number, the other is a string)
console.log(1 === true); // Output: false (because one is a number, the other is a boolean)

console.log(5 != "5");  // Output: false (because "5" is coerced to a number)
console.log(true != 1); // Output: false (because true is coerced to 1)


console.log(5 !== "5");  // Output: true (because one is a number, the other is a string)
console.log(1 !== true); // Output: true (because one is a number, the other is a boolean)

console.log(3 < 5);  // Output: true
console.log(5 <= 3);  // Output: false

console.log(null == undefined);  // Output: true
console.log(null === undefined); // Output: false

-- boolean
let isActive = true;
   -- falsy vlaue
console.log(Boolean(false));      // Output: false
console.log(Boolean(0));          // Output: false
console.log(Boolean(""));         // Output: false
console.log(Boolean(null));       // Output: false
console.log(Boolean(undefined));  // Output: false
console.log(Boolean(NaN));        // Output: false

    --  truthy values
console.log(Boolean("hello"));   // Output: true
console.log(Boolean(42));        // Output: true
console.log(Boolean({}));        // Output: true
console.log(Boolean([]));        // Output: true

console.log(true && true);   // Output: true
console.log(true || false);  // Output: true
console.log(!true);  // Output: false
```
### type conversion
```js
-- implecit
let result = "The answer is " + 42;
console.log(result);  // Output: "The answer is 42"

-- explecit
let num = 42;
let str1 = String(num);    // Converts number to string
console.log(str1);  // Output: "42"

let bool = true;
let str2 = bool.toString();  // Converts boolean to string
console.log(str2);  // Output: "true"

let obj = { name: "Alice" };
let str3 = `${obj}`;  // Template literal automatically converts to string
console.log(str3);  // Output: "[object Object]"

let num1 = Number(str);    // Converts string to number
console.log(num1);  // Output: 123

let str = "100px";
let num = parseInt(str);  // Extracts number from string
console.log(num);  // Output: 100

let str = "3.14px";
let num = parseFloat(str);  // Extracts floating point number
console.log(num);  // Output: 3.14

let str = "42";
let num = +str;  // Converts string to number
console.log(num);  // Output: 42

let num = 0;
let bool1 = Boolean(num);  // Converts 0 to false
console.log(bool1);  // Output: false

let str = "Hello";
let bool2 = Boolean(str);  // Converts non-empty string to true
console.log(bool2);  // Output: true

let obj = {};
let bool3 = !!obj;  // Converts object to true (since it's truthy)
console.log(bool3);  // Output: true

*** Type Conversion Behavior
let result = 5 + "5";  // Number 5 is converted to a string and then concatenated
console.log(result);  // Output: "55"

let result = "10" - 5;  // The string "10" is converted to a number and then subtracted
console.log(result);  // Output: 5

console.log(5 == "5");   // Output: true (loose equality)
console.log(5 === "5");  // Output: false (strict equality, types are different)
```
### conditional statements if - switch 
```js
let score = 85;
if (score >= 90) {
  console.log("Grade: A");
} else if (score >= 80) {
  console.log("Grade: B");
} else if (score >= 70) {
  console.log("Grade: C");
} else {
  console.log("Grade: F");
}
}

let age = 20;
let hasTicket = true;
if (age >= 18 && hasTicket)

let age = 20;
let result = age >= 18 ? "Adult" : "Minor";
console.log(result);  // Output: "Adult"\


let day = 3;
switch (day) {
  case 1:
    console.log("Monday");
    break;
  case 2:
    console.log("Tuesday");
    break;
  case 3:
    console.log("Wednesday");
    break;
  case 4:
    console.log("Thursday");
    break;
  case 5:
    console.log("Friday");
    break;
  default:
    console.log("Weekend");
}
```

### Loops
```js
for (let i = 0; i < 5; i++) {
  console.log(i);  // Output: 0, 1, 2, 3, 4
}

let i = 0;
while (i < 5) {
  console.log(i);  // Output: 0, 1, 2, 3, 4
  i++;
}

let i = 0;
do {
  console.log(i);  // Output: 0, 1, 2, 3, 4
  i++;
} while (i < 5);


// Used to loop over the keys of an object.
let person = {
  name: "Alice",
  age: 25,
  city: "New York"
};



for (let key in person) {
  console.log(key + ": " + person[key]);
}
// Output:
// name: Alice
// age: 25
// city: New York

// Best for iterating over iterable objects (e.g., arrays, strings, maps).
let numbers = [1, 2, 3, 4, 5];
for (let num of numbers) {
  console.log(num);  // Output: 1, 2, 3, 4, 5
}

let numbers = [1, 2, 3, 4, 5];
for (let num of numbers) {
  console.log(num);  // Output: 1, 2, 3, 4, 5
      if ..
          break;
          continue;
}

let fruits = ["apple", "banana", "cherry"];
fruits.forEach(function(fruit, index) {
  console.log(index + ": " + fruit);
});
// Output:
// 0: apple
// 1: banana
// 2: cherry

-- same
const x = (name,index) =>  console.log(index + ": " + name);
fruits.forEach(x)
```
### Normal functionn and Expression function
```js
function greet(name) {
  console.log("Hello, " + name);
}
greet("Alice"); // Output: Hello, Alice

// hoisting function
greet("Bob"); // Output: Hello, Bob
function greet(name) {
  console.log("Hello, " + name);
}


-- expression function -- Often used in callbacks or passed as arguments
const greet = function(name) {
  console.log("Hello, " + name);
};
greet("Bob"); // Output: Hello, Bob

greet("Charlie"); // Error: greet is not a function
const greet = function(name) {
  console.log("Hello, " + name);
};

// passed around
setTimeout(function() {
  console.log("This runs after 2 seconds");
}, 2000);

// arraw function
const greet = (name) => {
  console.log("Hello, " + name);
};
greet("Charlie"); // Output: Hello, Charlie
const greet = (name) => "Hello, " + name
console.log(greet("Charlie")); // Output: Hello, Charlie


-- parameters
function addNumbers(...numbers) {
  return numbers.reduce((sum, num) => sum + num, 0);
}
console.log(addNumbers(1, 2, 3, 4));  // Output: 10

--  only in normal funcvtion
function printArguments() {
  for (let i = 0; i < arguments.length; i++) {
    console.log(arguments[i]);
  }
}
printArguments("apple", "banana", "cherry");
// Output:
// apple
// banana
// cherry


function sum(a=100, b) {
  return a + b;
}
let result = sum(10, 20);  // 10 and 20 are arguments passed to the function.
console.log(result);  // Output: 30

let result = sum(undefined, 20); // or sum();
// 120

```
### object literal
```js
let person = {
  name: "Alice",
  age: 25,
  isStudent: false
};
console.log(person.name);      // Output: Alice
console.log(person["age"]);    // Output: 25


let car = {
  brand: "Toyota",
  model: "Corolla",
  year: 2020,
  features: ["Air Conditioning", "Bluetooth", "Backup Camera"],
  startEngine: function() {
    console.log(`${brand} Engine started`);
  }
};
car.startEngine();  // Output: Toyota Engine started

-- Shorthand Property Names (ES6)
let name = "John";
let age = 30;
let person = { name, age };  // shorthand for { name: name, age: age }
console.log(person);  // Output: { name: "John", age: 30 }

-- Computed Property Names (ES6)
let propName = "age";
let person = {
  [propName]: 25
};
console.log(person.age);  // Output: 25


-- this
console.log(this);  // In a browser, this logs the window object.

function greet() {
  console.log(this);
}
greet();  // In a browser, this refers to the window object.

let person = {
  name: "Alice",
  greet: function() {
    console.log(this.name);
  }
};
person.greet();  // Output: Alice


let person = {
  name: "Bob",
  greet: function() {
    let arrowFunc = () => {
      console.log(this.name);
    };
    arrowFunc();
  }
};
person.greet();  // Output: Bob


<button id="myButton">Click me</button>

<script>
  document.getElementById("myButton").addEventListener("click", function() {
    console.log(this);  // `this` refers to the button element.
  });
</script>

-- Using this with call, apply, and bind
-- call(): Invokes the function immediately and allows you to pass a specific this value and arguments.
function greet() {
  console.log(this.name);
}
let person = { name: "Alice" };
greet.call(person);  // Output: Alice


-- apply(): Similar to call(), but takes an array of arguments instead of individual arguments
function greet(city, country) {
  console.log(`${this.name} lives in ${city}, ${country}`);
}
let person = { name: "Bob" };
greet.apply(person, ["New York", "USA"]);  // Output: Bob lives in New York, USA


-- bind(): Returns a new function where this is permanently bound to the specified value
function greet() {
  console.log(this.name);
}
let person = { name: "Charlie" };
let boundGreet = greet.bind(person);
boundGreet();  // Output: Charlie

-- Class Constructors (ES6)
class Person {
  constructor(name) {
    this.name = name;
  }

  greet() {
    console.log(`Hello, my name is ${this.name}`);
  }
}

let person = new Person("Eve");
person.greet();  // Output: Hello, my name is Eve

```
### DOM 
- Document Object Model
- representation of an HTML document as a tree structure
- each node represents a part of the page (such as an element, text, or attribute
- DOM objects are created for every element, attribute, and piece of content within an HTML document
- tree
  - document
    - <html>
      - <head>
        - <title>
          - test: My title
      - <head>
        - <h1>
          - text : "haiii"
- in Inspect in console
  - document
  - document.getElementByClassName("card")
  - document.createAttri..
- querySelectors - to select first tag
  - documents.queryselector('h1')
  - documents.queryselector('.card') 
  - documents.queryselector('div.card') 
  - documents.queryselector('div > .card > p')   // copy element  in inspect
  - documents.queryselector('#card_id') 
- nexted querySelector
  - documents.queryselector('div').queryselector('.card')
- querySelectorALl - to select all tags and store as nodelist
  - documents.queryselectorAll('h1')
    - and result is indexable
- element by id class tag
  - result = documents.getElementsByTagName('h1')
    - result is indexable but not iterable
  - result = documents.getElementsByClassName('card')
    - result is indexable but not iterable
  - result = documents.getElementsById('card')
    - result is indexable but not iterable
- modify content
  - let result = document.getElementByClassName("card")
  - result.innerText = " new msg"
  - result.innerHTML = "<h1> new msg</h1>"
  - result.innerHTML += "<h1> new msg</h1>"
  - 
###
```js
// Document Object
console.log(document.title);  // Output: the title of the current HTML document

//  Element Object
let element = document.getElementById("myDiv");
console.log(element.textContent);  // Output: Hello, World!
-- modify
element.textContent = "New Content";  // Changes the text inside the div
element.style.color = "red";  // Changes the text color to red

// node obj
<p id="myText">This is a paragraph.</p>
let textNode = document.getElementById("myText").firstChild;
console.log(textNode.nodeValue);  // Output: This is a paragraph.


// Attribute obj
<img id="myImage" src="image.jpg" alt="A beautiful image">
let imgElement = document.getElementById("myImage");
console.log(imgElement.src);  // Access the src attribute of the image
imgElement.src = "newImage.jpg";  // Change the src attribute to a new image


// Event obj
<button id="myButton">Click me!</button>

<script>
  let button = document.getElementById("myButton");
  
  button.addEventListener("click", function(event) {
    console.log(event.type);  // Output: click
    console.log(event.target);  // Output: the button element
  });
</script>


// Accessing
let element = document.getElementById("myId");
let elements = document.getElementsByClassName("myClass");
let paragraphs = document.getElementsByTagName("p");
let firstDiv = document.querySelector("div");
let divs = document.querySelectorAll("div");



// Modifying DOM Elements:
let element = document.getElementById("myElement");
element.textContent = "New Text";  // Changes the text content
element.innerHTML = "<span>New HTML</span>";  // Changes the inner HTML

let element = document.getElementById("myElement");
element.style.color = "blue";  // Changes the text color to blue
element.style.fontSize = "20px";  // Changes the font size

let element = document.getElementById("myElement");
element.classList.add("newClass");  // Adds a class
element.classList.remove("oldClass");  // Removes a class
element.classList.toggle("active");  // Toggles a class

let button = document.getElementById("myButton");
button.addEventListener("click", function() {
  alert("Button clicked!");
});

let newDiv = document.createElement("div");   //  new dom
newDiv.textContent = "This is a new div!";
document.body.appendChild(newDiv);  // Adds the new div to the body


// DOM Traversal
let element = document.getElementById("myElement");
let parent = element.parentNode;  // Get the parent element
let firstChild = element.firstChild;  // Get the first child node

---
parentNode: Access the parent of an element
childNodes: Access the child nodes of an element
nextSibling: Access the next sibling of an element
previousSibling: Access the previous sibling of an element
```

### Async programming
- by default js is Async programming
- Asynchronous Concepts in JavaScript
  - Callback  
  - Promises
  - Async / Await
- Asynchronous Concepts in JavaScript
  - **Callback**
    - function containt the another function as para
    - when callback() is use it call the calller like function in para
    - callback is a function that is passed as an argument to another function and is executed after the completion of that function
    - Callbacks were traditionally used for asynchronous tasks
    - cons
      - Callback Hell
      -  multiple nested callbacks make the code difficult to read and maintain
      -  ` fetchData(function(data) {
            processData(data, function(result) {
              saveData(result, function(status) {
                console.log(status);
              });
            });
          });
          `
  - **Promises**
    - represents the eventual completion (or failure) of an asynchronous operation
    - some part is synchronius and some are Asynchronous
    - attach .then() for success and .catch() for errors
    - status
      - Pending: The initial state, neither fulfilled nor rejected
      - Fulfilled: The operation completed successfully
      - Rejected: The operation failed
        - async: A function declared with async always returns a promise
        - await: Used inside async functions to pause the execution until a promise is settled (resolved or rejected)
    - pros
      - Chaining Promises:
      - ` fetchData
          .then(result => {
            console.log(result);
            return "Next step data";  // Passing data to the next then
          })
          .then(nextResult => {
            console.log(nextResult);  // Output: Next step data
          })
          .catch(error => console.error(error)); `
  - **Async / Await**
    -  cleaner way to work with promises
    -  make asynchronous code look and behave more like synchronous code
```js
-- call back
// 1
function fetchData(callback) {
    console.log(2);
  setTimeout(() => {
      console.log(3);
    let data = "Data fetched!";
    console.log(4);
    callback(data);console.log(5);
  }, 1000); 
  console.log(6);
}
console.log(0);
fetchData(function(data) {
 console.log(1);
  console.log(data); 
      console.log(7);
});
// out put
0
2
6
3
4
1
Data fetched!
7
5

// callback(err,data) err = undefine when error occure, and use if in outer function to show err and data in diff formate

//2
const displayData = (callback) => {

    let request = new XMLHttpRequest()

    request.open('GET', 'https://jsonplaceholder.typicode.com/todos/11114141111')
    request.send()
    request.addEventListener('readystatechange', () => {

        if (request.readyState === 4 && request.status === 200) {
            callback(undefined, request.responseText);
        }else if(request.readyState === 4){
            callback("Error while calling the API", undefined);
        } 
    })

}

displayData((err, data) => {
    if(err){
        console.log(`An error occurred: ${err}`);
    }else{
        console.log(data);
    }
   
});



// Promise
// 1
let fetchData = new Promise((resolve, reject) => {
  let success = true; // Simulate whether the operation succeeds or fails

  setTimeout(() => {
    if (success) {
      resolve("Data fetched successfully!");
    } else {
      reject("Failed to fetch data.");
    }
  }, 1000);
});

fetchData
  .then(result => console.log(result))   // If successful
  .catch(error => console.error(error)); // If failed

// 2
const demo = () => {
    return new Promise((resolve, reject) => {
        resolve("Hello promise!!");
        //reject("Hello Reject!!")
    });

}
demo().then((data) => {
    console.log("output 2: "+ data); // Hello promise!!!
}).catch(err => {
    console.error('Error:', err);
});






// Async/Await
// 1
async function processTasks() {
  try {
    let data = await fetchData();   // Wait for data
    console.log(data);

    let processedData = await processData(data); // Wait for processing
    console.log(processedData);
    
    await saveData(processedData);  // Wait for data to be saved
    console.log("Data saved successfully!");
  } catch (error) {
    console.error("Error occurred:", error);
  }
}
processTasks();


// 2
const info = async () => {
    const response = await fetch('https://jsonplaceholder.typicode.com/todos/1')
    const data = await response.json()
    return data
}; 

info().then(data =>{ console.log(data)})
console.log(info());

console.log("Hello world")





// api call
let request = new XMLHttpRequest()

request.open('GET', 'https://jsonplaceholder.typicode.com/todos/1')
request.send()
request.addEventListener('readystatechange', () => {
    
    if (request.readyState === 4 && request.status === 200) {
        console.log(request.responseText)
    }
})

```
### Fetch call 
- use https://jsonplaceholder.typicode.com to pratice the request and response 
```
     fetch('https://jsonplaceholder.typicode.com/todos/1')
      .then(response => response.json())
      .then(json => console.log(json))
```
- or use XMLHttpRequest
```
   var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {          // when the resopse is get this code run 
        if (this.readyState == 4 && this.status == 200) {
           // Typical action to be performed when the document is ready:
           document.getElementById("demo").innerHTML = xhttp.responseText;
        }
    };
    xhttp.open("GET", "https://jsonplaceholder.typicode.com/todos/1", true);
    xhttp.send();

let request = new XMLHttpRequest()

request.open('GET', 'https://jsonplaceholder.typicode.com/todos/1')
request.send()
request.addEventListener('readystatechange', () => {
    
    if (request.readyState === 4 && request.status === 200) {
        console.log(request.responseText)
    }
})

```
- json - JavaScript Object Notation
