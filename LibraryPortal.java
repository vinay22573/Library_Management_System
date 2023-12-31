import java.util.*;
package mylibrary;
public class LibraryPortal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library IIITDL = new Library();//Instantiating Library class
        Librarian Rajendra = new Librarian(IIITDL);//Instantiating Librarian Class
        System.out.println("Library Portal Initialized…");
        while (true) {
            
            System.out.println("---------------------------------");
            System.out.println("1. Enter as a librarian");
            System.out.println("2. Enter as a member");
            System.out.println("3. Exit");
            System.out.println("---------------------------------");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    librarianMenu(Rajendra, IIITDL);
                    break;
                case 2:
                    memberMenu(IIITDL,Rajendra);
                    break;
                case 3:
                    System.out.println("Thanks for visiting!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void librarianMenu(Librarian Rajendra, Library IIITDL) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---------------------------------");
            // System.out.println("Librarian Menu:");
            System.out.println("1. Register a member");
            System.out.println("2. Remove a member");
            System.out.println("3. Add a book");
            System.out.println("4. Remove a book");
            System.out.println("5. View all members along with their books and fines to be paid");
            System.out.println("6. View all books");
            System.out.println("7. Back");
            System.out.println("---------------------------------");
            System.out.print("Enter your choice: ");
            int librarianChoice = scanner.nextInt();

            switch (librarianChoice) {
                
                case 1:
                    System.out.println("Enter the name of Member:");
                    scanner.nextLine(); // Consume the newline character
                    String name = scanner.nextLine();
                    System.out.println("Enter the age of Member:");
                    int age = scanner.nextInt();
                    // There is a problem in the code as i am unable to enter the full number
                    System.out.println("Enter the phoneNumber of Member:");
                    int phoneNumber = scanner.nextInt();
                    Rajendra.registerMember(name, age, phoneNumber);
                    break;

                case 2:
                    System.out.println("Enter the phoneNumber of the member whom you have to remove.");
                    int Uid = scanner.nextInt();
                    Rajendra.removeMember(Uid);
                    break;
                case 3:
                    System.out.println("Enter BookId");
                    int Bookid = scanner.nextInt();
    
                    System.out.println("Enter number of  Authors");
                    int na  = scanner.nextInt();
                    String[] Authors = new String[na];
                    scanner.nextLine();
                    for(int i = 0 ; i<na;i++){
                        String a = scanner.nextLine();
                        Authors[i] = a;
                    }
                    System.out.println("Enter number of copies of book");
                    int n = scanner.nextInt();
                    System.out.println("Enter title of the book");
                    scanner.nextLine();
                    String Title = scanner.nextLine();
                    Rajendra.addBook(Bookid, n, Authors, Title);
                    break;
                case 4:
                    int bookid = scanner.nextInt();
                    Rajendra.removeBook(bookid);
                    break;
                case 5:
                    Rajendra.displayMembersWithBooksAndFines(IIITDL);
                    break;
                case 6:
                    Rajendra.listBooks();
                    break;
                case 7:
                    return; 
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void memberMenu(Library IIITDL,Librarian Rajendra) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name of Member to login:");
        String Name = scanner.nextLine();
        System.out.println("Enter phoneNumber to login:");
        int numb = scanner.nextInt();
        if(!IIITDL.MemberExist(Name, numb)){
            System.out.print("Member with Name:" + Name);
            System.out.print(" and PhoneNumber:"+  numb);
            System.out.println(" does not exist.");
        
        }

        else{
            while (true) {
            System.out.println("---------------------------------");
            System.out.println("Member Menu:");
            System.out.println("1. List Available Books");
            System.out.println("2. List My Books");
            System.out.println("3. Issue a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Pay Fine");
            System.out.println("6. Back");
            System.out.println("---------------------------------");
            System.out.print("Enter your choice: ");
            int memberChoice = scanner.nextInt();

            switch (memberChoice) {

                case 1:
                    Rajendra.listBooks();
                    break;
                case 2:
                    IIITDL.findMemberByPhoneNumber(numb).myBooks(IIITDL);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Enter bookId of the book:");
                    int bookid = scanner.nextInt();
                    Rajendra.issueBook(bookid,numb);
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("Enter bookid which you want to return:");
                    int bOOkid = scanner.nextInt();
                    Rajendra.returnBook(bOOkid, numb);
                    break;
                case 5:
                    Rajendra.payFine(numb);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        }
    }
}
