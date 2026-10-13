// Assignment 11 (Lab 11) - Mini-Project
import java.time.LocalDate;

public class Loan {
    private final String memberId;
    private final LibraryItem item;
    private final LocalDate loanDate;

    public Loan(String memberId, LibraryItem item, LocalDate loanDate) {
        this.memberId = memberId;
        this.item = item;
        this.loanDate = loanDate;
    }

    public String getMemberId()   { return memberId; }
    public LibraryItem getItem()  { return item; }
    public LocalDate getLoanDate(){ return loanDate; }
    public LocalDate getDueDate() { return loanDate.plusDays(item.loanPeriodDays()); }

    public boolean isOverdue(LocalDate today) { return today.isAfter(getDueDate()); }

    @Override
    public String toString() {
        return "Loan{member=" + memberId + ", item='" + item.getTitle() + "', due=" + getDueDate() + "}";
    }
}
