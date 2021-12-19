import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age = OptionalInt.empty();
    protected String address;

    public Person(String name, String surname) {
       this.name = name;
       this.surname = surname;
    }

    public Person(String name, String surname, int age) {
       this(name, surname);
       this.age = OptionalInt.of(age);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
       if (age.isPresent()) {
           return age;
       } else {
           return OptionalInt.empty();
       }
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public String getAddress() {
        return hasAddress() ? address : "Адрес не указан";
    }

    public boolean hasAddress() {
        return address != null;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
       if (age.isPresent()) {
           age = OptionalInt.of(age.getAsInt() + 1);
       }
    }

    public PersonBuilder newChildBuilder() {
       return new PersonBuilder()
               .setSurname(surname)
               .setAddress(getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    @Override
    public String toString() {
        return "Person {" +
                "name = " + name +
                ", surname = " + surname +
                ", age = " + (age.isPresent() ? age.getAsInt() : "Возраст не указан") +
                ", city = " + getAddress() +
                '}';
    }
}
