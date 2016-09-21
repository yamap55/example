'use strict';

// const and let
const a = "a";
// a = "b" // error
let b = "b";
b = "c"; // OK

// Template literals
console.log(`a : ${a}`);

// Math.pow
console.log(6 ** 2); // 36

// for of
for (const arg of [1,3,5]) {
  console.log(arg); // 1, 3, 5
}

// default args
function func(a,b="bb") {
  console.log(b);
}
func(); // bb

// Rest parameters
function test(a, ...b) {
  console.log(a, b);
}
test(); // undefined []
test(1, 2, 3);// => 1 [2, 3]
