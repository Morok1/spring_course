package module2.example;

public class A {
    private B bDependency;
// 1 alternative
//    public A() {
//        this.bDependency = new B();
//    }

//    2 alternative
//dependency injection
    public A(B bDependency) {
        this.bDependency = bDependency;
    }
}
