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

// Shorthand property names
const hoge = "hogehoge";
const huga = 9999;
const obj = {hoge, huga};
console.log(obj); // {hoge: "hogehoge", huga: 9999}

// method
const object1 = {
  hoge : "hogehoge",

  method1() {
    console.log(`method1 : ${this.hoge}`);
  },

  method2(args) {
    console.log(`method2 : ${this.hoge} : ${args}`);
  }
}

console.log(object1.method1()); // method1 : hogehoge
console.log(object1.method2("arg")); // method2 : hogehoge : arg

// Destructuring assignment
const array = [10, 20, 30, 40];
const object2 = {aa : "aaa", bb : "bbb", cc: "ccc"};

const [arg1, arg2, ...argN] = array;
console.log(arg1, arg2, argN); // 10 20 [30, 40]

var {aa, cc} = object2
console.log(aa, cc); // aaa ccc

const {aa : hoge2, cc : huga2} = object2
console.log(hoge2, huga2); // aaa ccc

function func2({aaa, bbb} = {aaa : 11, bbb : 22}) {
  console.log(aaa, bbb);
}
func2(); // 11 22
func2({aaa : 111, bbb : 222, ccc : 333}); // 111 222
