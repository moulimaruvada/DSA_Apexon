public class D {

    public static void main(String[] args) {
        I obj = new C();
        // I obj2 = new I();
        I obj2 = new B();
        A obj3 = new B();
        A obj4 = new A();

        obj4.foo();
        obj3.foo();
    }
}
