// Lab 4 - Program 4.2 (from the lab manual)
class A {
    A() { System.out.println("A constructor"); }
}
class B extends A {
    B() { System.out.println("B constructor"); }   // implicit super() -> A()
}
class C extends B {
    C() { System.out.println("C constructor"); }   // implicit super() -> B()
}
public class Chain {
    public static void main(String[] args) {
        new C();
    }
}
