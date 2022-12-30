console.log("hello world!");
console.log("Hello world!")

let obj = {
    x: 0,
    y: 0,
}

interface MyInterface {
    x: number;
    y: number;
}

function implementingMyInterface(something: MyInterface) {
    console.log(something.x);
    console.log(something.y);
}

implementingMyInterface(obj);


