// Assignment 3 (Lab 3) - Exercise 4 (Intermediate)
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* DESIGN CHOICES:
   1. 'final class'      -> no subclass can add mutable state or override getters to break immutability.
   2. 'private final' fields -> assigned once in the constructor, never changed afterwards.
   3. No setters         -> state cannot change after construction.
   4. Defensive copy of the hobbies list in the constructor AND an unmodifiable view in the getter,
      so neither the caller's original list nor the returned list can alter our state.
   Benefits: thread-safe, safe to share and to use as a map key. */
public final class ImmutablePerson {
    private final String name;
    private final int age;
    private final List<String> hobbies;

    public ImmutablePerson(String name, int age, List<String> hobbies) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name required");
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative");
        this.name = name;
        this.age = age;
        this.hobbies = Collections.unmodifiableList(new ArrayList<>(hobbies));
    }

    public String getName()          { return name; }
    public int getAge()              { return age; }
    public List<String> getHobbies() { return hobbies; }

    // "Changing" a person returns a NEW object
    public ImmutablePerson withAge(int newAge) {
        return new ImmutablePerson(name, newAge, hobbies);
    }

    public static void main(String[] args) {
        List<String> hobbies = new ArrayList<>(List.of("chess", "football"));
        ImmutablePerson p = new ImmutablePerson("Rudo", 20, hobbies);

        hobbies.add("gaming");   // does not affect p
        System.out.println(p.getName() + " " + p.getAge() + " " + p.getHobbies());

        ImmutablePerson older = p.withAge(21);
        System.out.println(p.getAge() + " vs " + older.getAge());
    }
}
