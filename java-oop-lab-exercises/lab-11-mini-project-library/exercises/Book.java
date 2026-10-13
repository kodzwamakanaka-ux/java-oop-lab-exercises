// Assignment 11 (Lab 11) - Mini-Project
public class Book extends LibraryItem {
    private final String author;

    public Book(String id, String title, String author) {
        super(id, title);
        if (author == null || author.isBlank()) throw new IllegalArgumentException("Author required");
        this.author = author.trim().replace(",", " ");
    }

    public String getAuthor() { return author; }

    @Override public int loanPeriodDays() { return 14; }
    @Override public String type()        { return "BOOK"; }
    @Override public String extra()       { return author; }
}
