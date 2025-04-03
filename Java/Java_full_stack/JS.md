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
```
###

###

###

###
