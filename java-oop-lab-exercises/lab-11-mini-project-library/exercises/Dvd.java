// Assignment 11 (Lab 11) - Mini-Project
public class Dvd extends LibraryItem {
    private final int minutes;

    public Dvd(String id, String title, int minutes) {
        super(id, title);
        if (minutes <= 0) throw new IllegalArgumentException("Duration must be positive");
        this.minutes = minutes;
    }

    public int getMinutes() { return minutes; }

    @Override public int loanPeriodDays() { return 7; }
    @Override public String type()        { return "DVD"; }
    @Override public String extra()       { return String.valueOf(minutes); }

    @Override public String toString() {
        return String.format("[%s] %s - %d min (DVD, %d-day loan, %s)",
                getId(), getTitle(), minutes, loanPeriodDays(), isAvailable() ? "available" : "on loan");
    }
}
