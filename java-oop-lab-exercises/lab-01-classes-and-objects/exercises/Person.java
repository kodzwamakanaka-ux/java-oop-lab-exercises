// Assignment 1 (Lab 1) - Exercise 5 (Challenge)
public class Person {
    String name;
    Address address;   // a Person HAS-A Address (may be null)

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public static void main(String[] args) {
        Person withAddress = new Person("Tariro", new Address("12 Main St", "Harare"));
        System.out.println(withAddress.name + " lives in " + withAddress.address.city);

        Person noAddress = new Person("Farai", null);
        try {
            // Chained dot on a null reference throws NullPointerException
            System.out.println(noAddress.address.city);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + noAddress.name + " has no address");
        }

        // Safe version
        String city = (noAddress.address != null) ? noAddress.address.city : "unknown";
        System.out.println("Safe lookup: " + city);
    }
}
