package support

class Person {
    String name
    int age

    Person(String name, int age) {
        this.name = name
        this.age = age
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (o == null || getClass() != o.class) return false

        Person p = (Person) o
        return age == p.age && name == p.name
    }

    int hashCode() {
        int result
        result = (name != null ? name.hashCode() : 0)
        result = 31 * result + age
        return result
    }
}