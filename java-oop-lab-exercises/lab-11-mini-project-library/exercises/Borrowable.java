// Assignment 11 (Lab 11) - Mini-Project: interface
public interface Borrowable {
    void borrow(Member member) throws ItemNotAvailableException;
    void giveBack();
}
