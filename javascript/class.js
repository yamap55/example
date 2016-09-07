class Hoge {

  constructor(param) {
    this.param = param;
    console.log("constructor");
  }

  // コンストラクタは1つのみ
  // Uncaught SyntaxError: A class may only have one constructor
  // constructor() {}

  method() {
    console.log("method");
  }

  static staticMethod() {
    console.log("staticMethod");
  }

  set param(param) {
    console.log("setter");
    this._param = param;
  }

  get param() {
    console.log("getter");
    return this._param;
  }
}

Hoge.staticMethod(); // staticMethod
const hoge = new Hoge("param"); // setter, constructor
hoge.method(); // method
hoge.param = "param2"; // setter
console.log(hoge.param); // getter, param2
