'use strict';

const a = "a";
// a = "b" // error
let b = "b";
b = "c"; // OK

console.log(`a : ${a}`);

// ----

console.log(6 ** 2); // 36

// ----

for (const arg of [1,3,5]) {
  console.log(arg); // 1, 3, 5
}
