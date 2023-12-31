import java.util.*;
class Member {
    String Name;
    int Age;
    int PhoneNumber;
    private HashMap<Integer, ArrayList<Long>> issuedBooks = new HashMap<>();
    int extradays = 0;
    public Member(String Name, int Age, int PhoneNumber) {
        this.Name = Name;
        this.Age = Age;
        this.PhoneNumber = PhoneNumber;
    }
    public int getUid() {
        return this.PhoneNumber;
    }
    public String getName(){
        return this.Name;
    }
    // Getter for the entire issuedBooks HashMap
    public HashMap<Integer, ArrayList<Long>> getIssuedBooks() {// int Uid : [long issuetime, long return time]
        return issuedBooks;
    }
    public void myBooks(Library library) {
        HashMap<Integer, ArrayList<Long>> issuedBooks = getIssuedBooks();
    
        if (issuedBooks.isEmpty()) {
            System.out.println("You have not issued any books.");
        } else {
            System.out.println("Books issued by " + Name + ":");
            for (Map.Entry<Integer, ArrayList<Long>> entry : issuedBooks.entrySet()) {
                int bookId = entry.getKey();
                ArrayList<Long> timestamps = entry.getValue();
    
                Book book = library.findBookById(bookId); // Get book details from the library
    
                if (book != null) {
                    System.out.println("Book ID: " + bookId);
                    System.out.println("Title: " + book.getBookTitle());
                    System.out.println("Author(s): " + String.join(", ", book.getAuthors()));
                    System.out.println("Issue Time: " + new Date(timestamps.get(0))); // Convert to human-readable date
                    System.out.println("Return Time: " + new Date(timestamps.get(1))); // Convert to human-readable date
                    System.out.println("-------------------------");
                } else {
                    System.out.println("Book with ID " + bookId + " not found in the library.");
                }
            }
        }
    }
    
    
    // Method to initialize issueTime and returnTime for all books
    public void initializeIssuedBooks(int bookListSize) {
        for (int i = 1; i <= bookListSize; i++) {
            addIssuedBook(i, 0L, 0L);
        }
    }
    public int getExtradays() {
        return this.extradays;
    }
    public void setExtradays(int extradays) {
        this.extradays = extradays;
    }
    // Method to add issue time and return time for a specific book
    public void addIssuedBook(int bookId, long issueTime, long returnTime) {
        ArrayList<Long> timePair = new ArrayList<>();
        timePair.add(issueTime);
        timePair.add(returnTime);
        issuedBooks.put(bookId, timePair);
    }
    // Method to remove a specific book entry from issuedBooks
    public void removeIssuedBook(int bookId) {
        issuedBooks.remove(bookId);
    }
}