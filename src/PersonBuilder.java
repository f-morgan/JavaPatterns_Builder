public class PersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String address;


    public PersonBuilder setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            throw new IllegalStateException("Нет имени или фамилии");
        }
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname != null) {
            this.surname = surname;
        } else {
            throw new IllegalStateException("Нет имени или фамилии");
        }
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Неверно указан возраст");
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        if (address != null) {
            this.address = address;
        } else {
            this.address = "Адрес неизвестен";
        }
        return this;
    }

    public Person build() {
        Person person;
        if (name == null || surname == null) {
            throw new IllegalStateException("Нет имени или фамилии");
        }
        if (age >= 0) {
            person = new Person(name, surname, age);
        } else {
            person = new Person(name, surname);
        }

        if (address != null) {
            person.setAddress(address);
        }

        return person;
    }




}
