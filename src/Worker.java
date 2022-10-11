public class Worker {
    int id;
    int salary;
    String firstName;
    String lastName;

    @Override
    public String toString() {
        return String.format("id: %d, fn: %s, ln: %s, s: %d", id, firstName, lastName, salary);
    }

    @Override
    public boolean equals(Object obj) {
        Worker w = (Worker) obj;
        return id == w.id && firstName == w.firstName;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
