// Couple.java

public class Couple {
    // Fields
    private Person bride;
    private Person groom;

    // Constructor
    public Couple(Person bride, Person groom) {
        this.bride = bride;
        this.groom = groom;
    }

    // Get methods
    public Person getBride() {
        return bride;
    }

    public Person getGroom() {
        return groom;
    }

    public static void main(String[] args) {
        // Example usage
        Person bride = new Person("Alice", "Smith");
        Person groom = new Person("Bob", "Johnson");

        Couple couple = new Couple(bride, groom);

        System.out.println("Bride's Name: " + couple.getBride().getFirstName() + " " + couple.getBride().getLastName());
        System.out.println("Groom's Name: " + couple.getGroom().getFirstName() + " " + couple.getGroom().getLastName());
    }
}
