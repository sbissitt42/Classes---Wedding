import java.time.LocalDate;

public class Wedding {
    // Fields
    private LocalDate weddingDate;
    private Couple couple;
    private String location;

    // Constructor
    public Wedding(Couple couple, LocalDate weddingDate, String location) {
        this.couple = couple;
        this.weddingDate = weddingDate;
        this.location = location;
    }

    // Get methods
    public Couple getCouple() {
        return couple;
    }

    public LocalDate getWeddingDate() {
        return weddingDate;
    }

    public String getLocation() {
        return location;
    }

    public static void main(String[] args) {
        // Example usage
        Person bride = new Person("Alice", "Smith");
        Person groom = new Person("Bob", "Johnson");
        Couple couple = new Couple(bride, groom);

        LocalDate weddingDate = LocalDate.of(2024, 5, 15);
        String location = "Smalltown VFW Hall";

        Wedding wedding = new Wedding(couple, weddingDate, location);

        System.out.println("Couple: " + wedding.getCouple().getBride().getFirstName() + " and " +
                wedding.getCouple().getGroom().getFirstName());
        System.out.println("Wedding Date: " + wedding.getWeddingDate());
        System.out.println("Location: " + wedding.getLocation());
    }
}
