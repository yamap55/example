'use strict';

{
  // const and let
  var a = "a";
  var a = "aa"; // OK

  let b = "b";
  //let b = "bb"; // NG

  b = "bb"; // OK

  const c = "c";
  // c = "cc" // NG
}

{
  // arrow function expression
  const func1 = (a, b) => console.log("a, b");
  const func2 = c => console.log("c");
  const func3 = (d, e) => {return "d,e"};
  func1();
  func2();
  console.log(func3());
}

{
  // Template literals
  const a = "a";
  console.log(`a : ${a}`);
}

// Math.pow
console.log(6 ** 2); // 36

// for of
for (const arg of [1,3,5]) {
  console.log(arg); // 1, 3, 5
}

// default args
{
  function func(a,b="bb") {
    console.log(b);
  }
  func(); // bb
}

// Rest parameters
{
  function test(a, ...b) {
    console.log(a, b);
  }
  test(); // undefined []
  test(1, 2, 3);// 1 [2, 3]
}
// Shorthand property names
{
  const hoge = "hogehoge";
  const huga = 9999;
  const obj = {hoge, huga};
  console.log(obj); // {hoge: "hogehoge", huga: 9999}
}

// method
{
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
}

// Destructuring assignment
{
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
}

// Spread syntax
{
  const array = ["aa", "bb", "cc"];
  function func(a, b, c) {
    console.log(a, b, c);
  }
  func(...array); // aa bb cc

  const [x, ...rest] = array;
  console.log(rest); // ["bb", "cc"]
  console.log(x); // aa
}

// Promise
{
  function setTimeoutAsync(time, occurError = false) {
    return new Promise((resolve, reject) => {
      if (occurError) {
        reject(new Error("error!"));
      } else {
        setTimeout(() => {
          resolve(`${time} since milliseconds`);
        }, time);
      }
    });
  }

  setTimeoutAsync(1000).then((text) => {
    console.log(text); // 1000 since milliseconds
  });

  setTimeoutAsync(1000, true).catch((err) => {
    console.log(err.message); // error!
  });

  setTimeoutAsync(1000).then((text) => {
    console.log(text);
    return "hoge"; // return value next then execute
  }).then((text) => {
    console.log(text);
    return setTimeoutAsync(1500);
  }).then((text) => {
    console.log(text);
    return setTimeoutAsync(2000, true); // next is catch
  }).then((text) => {
    console.log("don't output"); //
  }).catch((err) => {
    console.log(err.message);
  });
}
{
  // class
  class HogeClass {
    constructor(arg) {
      this.arg = arg;
      console.log(`constructor : ${arg}`);
    }

    static staticMethod() {
      console.log("static method");
    }

    methodA() {
      console.log(`methodA : ${this.arg}`);
    }
  }

  HogeClass.staticMethod(); // static method
  // console.log(HogeClass.methodA()); // error

  const hoge = new HogeClass("a"); // constructor : a
  console.log(hoge); // HogeClass {arg : 'a'}
  // hoge.staticMethod(); // error
  hoge.methodA(); // methodA : a

  class PiyoClass extends HogeClass {
    constructor(arg) {
      super(arg); // parent class' constructor
      console.log("piyo constructor");
    }

    static piyoStaticMethod() {
      console.log("piyo static method");
    }

    piyoMethod() {
      console.log("piyo method");
    }
  }

  PiyoClass.staticMethod(); // static method
  PiyoClass.piyoStaticMethod(); // piyo static method

  const piyo = new PiyoClass("b"); // constructor : b, piyo constructor
  console.log(piyo); // PiyoClass {arg: "b"}
  piyo.methodA(); // methodA : b
  piyo.piyoMethod(); // piyo method
}
