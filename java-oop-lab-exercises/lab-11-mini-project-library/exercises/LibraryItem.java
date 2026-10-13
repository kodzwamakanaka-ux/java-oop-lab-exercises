// Assignment 11 (Lab 11) - Mini-Project: abstract base class (abstraction + encapsulation)
public abstract class LibraryItem implements Borrowable {
    private final String id;
    private final String title;
    private boolean available = true;

    protected LibraryItem(String id, String title) {
        if (id == null || id.isBlank())       throw new IllegalArgumentException("Item id required");
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Title required");
        this.id = id.trim();
        this.title = title.trim().replace(",", " ");   // commas would break the CSV files
    }

    public abstract int loanPeriodDays();   // each subclass decides (polymorphism)
    public abstract String type();          // "BOOK" or "DVD" (used for CSV)
    public abstract String extra();         // author or duration (used for CSV)

    public String getId()        { return id; }
    public String getTitle()     { return title; }
    public boolean isAvailable() { return available; }
    void setAvailable(boolean available) { this.available = available; }

    @Override
    public void borrow(Member member) throws ItemNotAvailableException {
        if (!available) throw new ItemNotAvailableException("'" + title + "' is already on loan");
        available = false;
    }

    @Override
    public void giveBack() { available = true; }

    @Override
    public String toString() {
        return String.format("[%s] %s - %s (%s, %d-day loan, %s)",
                id, title, extra(), type(), loanPeriodDays(), available ? "available" : "on loan");
    }
}
