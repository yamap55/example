var obj1 = function(){};
obj1.hoge = "hoge";
obj1.huga = function(){console.log("huga");};
obj1.piyo = ()=>{console.log("piyo");};
obj1.prototype.hogehoge = function(){console.log("hogehoge");};

console.log(obj1.hoge); // hoge
obj1.huga(); // huga
obj1.piyo(); // piyo

typeof obj1.hogehoge === "undefined"; // true

var obj = new obj1();
obj.hogehoge() // hogehoge

typeof obj.hoge === "undefined"; // true
typeof obj.huga === "undefined"; // true
typeof obj.piyo === "undefined"; // true

class Hoge {
  constructor(data){
    this.data = data;
  }
  method1() {
    console.log("method1");
  }
}
var hoge = new Hoge();
console.log(hoge.data); // a
hoge.method1(); // method1