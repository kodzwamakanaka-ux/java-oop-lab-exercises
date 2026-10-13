// Assignment 11 (Lab 11) - Mini-Project: core service (collections, streams, exceptions, file I/O)
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private final Map<String, LibraryItem> items = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();

    // ---------- adding ----------
    public void addItem(LibraryItem item) {
        if (items.containsKey(item.getId())) throw new IllegalArgumentException("Duplicate item id: " + item.getId());
        items.put(item.getId(), item);
    }

    public void addMember(Member member) {
        if (members.containsKey(member.getId())) throw new IllegalArgumentException("Duplicate member id: " + member.getId());
        members.put(member.getId(), member);
    }

    // ---------- borrow / return ----------
    public Loan borrow(String memberId, String itemId, LocalDate today)
            throws ItemNotAvailableException, MemberLimitExceededException {
        Member member = members.get(memberId);
        if (member == null) throw new IllegalArgumentException("No such member: " + memberId);
        LibraryItem item = items.get(itemId);
        if (item == null) throw new IllegalArgumentException("No such item: " + itemId);

        if (!item.isAvailable()) {
            throw new ItemNotAvailableException("'" + item.getTitle() + "' is already on loan");
        }
        if (!member.canBorrow()) {
            throw new MemberLimitExceededException(member.getName() + " already has " + Member.MAX_LOANS + " loans");
        }

        item.borrow(member);                              // marks the item unavailable
        Loan loan = new Loan(memberId, item, today);
        member.addLoan(loan);
        return loan;
    }

    public void giveBack(String itemId) {
        LibraryItem item = items.get(itemId);
        if (item == null) throw new IllegalArgumentException("No such item: " + itemId);

        for (Member m : members.values()) {
            for (Loan loan : m.getLoans()) {
                if (loan.getItem().getId().equals(itemId)) {
                    m.removeLoan(loan);
                    item.giveBack();
                    return;
                }
            }
        }
        throw new IllegalArgumentException("Item " + itemId + " is not currently on loan");
    }

    // ---------- queries (streams) ----------
    public List<Loan> overdueLoans(LocalDate today) {
        return members.values().stream()
                .flatMap(m -> m.getLoans().stream())
                .filter(l -> l.isOverdue(today))
                .sorted(Comparator.comparing(Loan::getDueDate))
                .toList();
    }

    public List<LibraryItem> searchByTitle(String text) {
        return items.values().stream()
                .filter(i -> i.getTitle().toLowerCase().contains(text.toLowerCase()))
                .sorted(Comparator.comparing(LibraryItem::getTitle))
                .toList();
    }

    public List<LibraryItem> allItems() {
        return items.values().stream().sorted(Comparator.comparing(LibraryItem::getId)).toList();
    }

    public List<Member> allMembers() {
        return members.values().stream().sorted(Comparator.comparing(Member::getId)).toList();
    }

    // ---------- persistence (CSV) ----------
    public void save(Path dir) throws IOException {
        Files.createDirectories(dir);

        List<String> itemLines = new ArrayList<>();
        for (LibraryItem i : allItems()) {
            itemLines.add(i.type() + "," + i.getId() + "," + i.getTitle() + "," + i.extra());
        }
        Files.write(dir.resolve("items.csv"), itemLines);

        List<String> memberLines = new ArrayList<>();
        List<String> loanLines = new ArrayList<>();
        for (Member m : allMembers()) {
            memberLines.add(m.getId() + "," + m.getName());
            for (Loan l : m.getLoans()) {
                loanLines.add(m.getId() + "," + l.getItem().getId() + "," + l.getLoanDate());
            }
        }
        Files.write(dir.resolve("members.csv"), memberLines);
        Files.write(dir.resolve("loans.csv"), loanLines);
    }

    public void load(Path dir) throws IOException {
        Path itemsFile = dir.resolve("items.csv");
        Path membersFile = dir.resolve("members.csv");
        Path loansFile = dir.resolve("loans.csv");

        if (Files.exists(itemsFile)) {
            for (String line : Files.readAllLines(itemsFile)) {
                if (line.isBlank()) continue;
                String[] p = line.split(",", 4);
                if (p[0].equals("BOOK")) addItem(new Book(p[1], p[2], p[3]));
                else                     addItem(new Dvd(p[1], p[2], Integer.parseInt(p[3])));
            }
        }
        if (Files.exists(membersFile)) {
            for (String line : Files.readAllLines(membersFile)) {
                if (line.isBlank()) continue;
                String[] p = line.split(",", 2);
                addMember(new Member(p[0], p[1]));
            }
        }
        if (Files.exists(loansFile)) {
            for (String line : Files.readAllLines(loansFile)) {
                if (line.isBlank()) continue;
                String[] p = line.split(",");
                Member m = members.get(p[0]);
                LibraryItem item = items.get(p[1]);
                if (m == null || item == null) continue;
                item.setAvailable(false);
                m.addLoan(new Loan(p[0], item, LocalDate.parse(p[2])));
            }
        }
    }
}
