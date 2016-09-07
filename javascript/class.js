class Hoge {
  constructor() {
    console.log("constructor");
  }

  method() {
    console.log("method");
  }

  static staticMethod() {
    console.log("staticMethod");
  }
}

Hoge.staticMethod(); // staticMethod
const hoge = new Hoge(); // constructor
hoge.method(); // method
