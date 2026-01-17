package support

/**
 * Employee extends Person and represents an employee with an additional `id` field.
 * Natural ordering via `compareTo` should first defer to Person's comparison (for example
 * by name/age) and then break ties using `id`. This ensures consistent ordering between
 * Person and Employee instances when a compareTo implementation is provided.
 */
class Employee extends Person {
    int id

    Employee(int employeeId, String name, int age) {
        super(name, age)
        this.id = employeeId
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (o == null || getClass() != o.class) return false
        if (!super.equals(o)) return false

        Employee employee = (Employee) o

        if (id != employee.id) return false

        return true
    }

    int hashCode() {
        int result = super.hashCode()
        result = 31 * result + id
        return result
    }

    @Override
    int compareTo(Person o) {
        if (this.is(o)) return 0

        int personCmp = super.compareTo(o)
        if (personCmp != 0) {
            return personCmp
        }

        if (o instanceof Employee) {
            return this.id <=> ((Employee) o).id
        }

        return 0
    }
}
