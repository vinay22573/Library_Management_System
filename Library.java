import java.util.*;
class Library {
    private ArrayList<Book> BookList;
    private int[] count;//iska kya kaam hai
    private ArrayList<Member> members;

    //Constructor
    public Library() {
        this.BookList = new ArrayList<>();
        this.count = new int[0];
        this.members = new ArrayList<>();
    }

    public String BookReturn(int bookId, int phoneNumber) {
        // Check if the book is available in the library
        Book book = findBookById(bookId);

        // Check if the book is issued to the member
        Member member = findMemberByPhoneNumber(phoneNumber);
        if (member == null) {
            return "Member not found.";
        } else if (!member.getIssuedBooks().containsKey(bookId)) {
            return "This book is not issued to you.";
        } else {
            long issueTime = member.getIssuedBooks().get(bookId).get(0); // Get the issue time in milliseconds
            long returnTime = System.currentTimeMillis(); // Current time when the book is returned

            // Calculate the fine based on the time difference (assuming 1 second = 1 day)
            long diffMillis = returnTime - issueTime;
            int diffDays = (int) (diffMillis / 1000); // Convert milliseconds to days
            book.Copies++;

            if (diffDays > 10) {
                int extraDays = diffDays - 10;
                member.setExtradays(member.getExtradays() + extraDays);
            }

            member.removeIssuedBook(bookId);
            return "Book returned successfully.";
        }
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.BookList = bookList;
    }

    public void setCount(int[] count) {
        this.count = count;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public ArrayList<Book> getBookList() {
        return BookList;
    }

    public int[] getCount() {
        return count;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    // Easiest Methods
    public void listMembers() {
        System.out.println("List of Registered Members:");
        for (Member member : members) {
            System.out.println("Name: " + member.Name);
            System.out.println();  // Add an empty line between members for clarity
        }
    }

    public String issueBook(int bookId, int phoneNumber) {
        // Check if the book is available in the library
        Book book = findBookById(bookId);
        if (book == null) {
            return "Book not found.";
        }
        // Find the member by phone number
        Member member = findMemberByPhoneNumber(phoneNumber);
        if (member == null) {
            return "Member not found.";
        }

        // Check if the book is already issued to the member
        else if (member.getIssuedBooks().containsKey(bookId)) {
            return "This book is already issued to you.";
        }

        // Issue the book
        else if (book.Copies > 0) {
            book.Copies--; // Decrement the available copies
            
            member.addIssuedBook(bookId, System.currentTimeMillis(),0L); // Store the issue time in milliseconds
            return "Book issued successfully.";
        } else {
            return "All copies of the book are already issued.";
        }
    }
    public String returnBook(int bookId, int phoneNumber) {
        // Check if the book is available in the library
        Book book = findBookById(bookId);

        // Check if the book is issued to the member
        Member member = findMemberByPhoneNumber(phoneNumber);
        if (member == null) {
            return "Member not found.";
        } else if (!member.getIssuedBooks().containsKey(bookId)) {
            return "This book is not issued to you.";
        } else {
            long issueTime = member.getIssuedBooks().get(bookId).get(0); // Get the issue time in milliseconds
            long returnTime = System.currentTimeMillis(); // Current time when the book is returned

            // Calculate the fine based on the time difference (assuming 1 second = 1 day)
            long diffMillis = returnTime - issueTime;
            int diffDays = (int) (diffMillis / 1000); // Convert milliseconds to days
            book.Copies++;

            if (diffDays > 10) {
                int extraDays = diffDays - 10;
                member.setExtradays(member.getExtradays() + extraDays);
            }

            member.removeIssuedBook(bookId);
            return "Book returned successfully.";
        }
    }

    public void Payfine(int phoneNumber) {
        int fineAmount = Calculatefine(phoneNumber);

        if (fineAmount == -1) {
            System.out.println("Member not found.");
        } else if (fineAmount == 0) {
            System.out.println("You have no fines to pay.");
        } else {
            // Deduct the fine from the member (assuming you have a method to deduct it)
            // member.payFine(fineAmount);
            Member member = findMemberByPhoneNumber(phoneNumber);
            if (member != null) {
                member.setExtradays(0); // Set extradays to zero when fines are paid
            }
            System.out.println("Fine paid successfully. Amount: $" + fineAmount);
        }
    }
    
    // Implement the fine calculation logic here
    public int Calculatefine(int phoneNumber) {
        Member member = findMemberByPhoneNumber(phoneNumber);
        if (member == null) {
            return -1; // Member not found
        }

        HashMap<Integer, ArrayList<Long>> issuedBooks = member.getIssuedBooks();
        int totalFine = 0;

        for (Map.Entry<Integer, ArrayList<Long>> entry : issuedBooks.entrySet()) {
            int bookId = entry.getKey();
            ArrayList<Long> timestamps = entry.getValue();
            long issueTime = timestamps.get(0);
            long returnTime = timestamps.get(1);

            // Calculate fine for this book
            long diffMillis = returnTime - issueTime;
            int diffDays = (int) (diffMillis / 1000 ); // Convert milliseconds to days

            if (diffDays > 10) {
                int extraDays = diffDays - 10;
                int fine = extraDays * 3; // $3 per extra day
                totalFine += fine;
            }
        }

        return totalFine;
    }
    public boolean MemberExist(String name, int phoneNumber) {
        for (Member member : members) {
            if (member.getName().equals(name) && member.getUid() == phoneNumber) {
                return true;
            }
        }
        return false;
    }
    


    // Helper methods to find book by ID and member by phone number
    public Book findBookById(int bookId) {
        for (Book book : BookList) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public Member findMemberByPhoneNumber(int phoneNumber) {
        for (Member member : members) {
            if (member.getUid() == phoneNumber) {
                return member;
            }
        }
        return null;
    }
}