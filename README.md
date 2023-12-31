This is a java code for Library management System where we were asked to implement the following :
Instructions
Develop a Library Management System application using Object-Oriented Programming (OOP) principles.
Make appropriate classes that represent different entities and functionalities within the library system.
Design a menu-driven interface for users to interact with the library system.
Ensure that your code works for all possible scenarios.
If the code does not compile using Maven, you will get a zero.

Implement a library system for IIITD. You can use the interface either as a librarian or as a student. A librarian manages members/students and books of the library. A librarian can view, register or remove members. They can also view books, add a book, remove a book, issue a book and collect dues/fines. The fine is applied as 3 rupees per day post the return due date of a book. Assume the due date for all books to be 10 days after the issue date. If a member is returning a book after the due date, the book will be returned and a balance will be due on the member. Before issuing a new book the balance should be paid by the member to the librarian. A member can view all available books, borrow a book, return a book, view their own books, and pay dues.There may be multiple copies of a single book. A member can only borrow a book if there is an available copy of the book which is not issued. A member can hold at most 2 books at a time. 

Functionalities:
1. Add Book:
   Allow a librarian to add a new book to the library.
   Take input for book details (title, author, total copies).

2. Remove Book:
Allow a librarian to remove a book from the library.
Take input for book ID.

3. Register Member:
Allow a librarian to add a new member to the library.
Take input for member details (name, age, etc). 
The Phone Number can act as an unique input to identify the members uniquely.

4. Remove Member:
    Allow a librarian to remove a member from the library.
   Take input for member ID. Here also, we can take input as username and phone no etc. 

5. Enter as a member 
Takes the member name and phone number as input and logs in as the particular member, if already registered . 
If not registered, gives an error message. 

6. Issue Book:
   Allow a member to borrow a book from the library, given his penalty amount is zero. If he owes the library penalty money, he should first clear that before issuing a new book. 
   Display available books and take input for book ID.

7. Return Book:
   Allow a member to return a borrowed book.
   Display borrowed books and take input for book ID.

8. List Books:
   Display a list of all available books in the library.

9. List Members:
   Display a list of all registered members of the library.

10. Calculate Fine:
    Calculate and display the fine amount for a book if it's returned after the due date (10 days). Here for ease of testing, take 1 sec = 1 day. 

11. Exit:
     Terminate the application.

Guidelines:
Implement input validation to handle incorrect or invalid user inputs.
Ensure proper error handling and display user-friendly error messages.
Apply OOP principles to improve code organization and readability.

Submission:
Submit File Name format: A1_RollNumber.zip

Important:
The code should be composed and presented using Maven. Additionally, please provide a Readme document that comprehensively outlines the procedures for executing your code. Ensure that the pom.xml file is included in your submission as well. These requirements are essential to facilitate the evaluation of your submission. If any of these is missing, you will get a zero. 

SAMPLE RUN 

Library Portal Initialized….
---------------------------------
Enter as a librarian	
Enter as a member
Exit
---------------------------------
1
---------------------------------
Register a member
Remove a member
Add a book
Remove a book
View all members along with their books and fines to be paid
View all books
Back
---------------------------------
1
---------------------------------
Name: Rick Dunphy
Age: 21
Phone no: 9999999993
---------------------------------
Member Successfully Registered with <Member ID>!
---------------------------------
3 
---------------------------------
Book title: Harry Potter 
Author: J.K. Rowling
Copies: 2
---------------------------------
Book Added Successfully!
---------------------------------
Register a member
Remove a member
Add a book
Remove a book
View all members along with their books and fines to be paid
View all books
Back
---------------------------------
6
---------------------------------
Book ID - 1
Name - Harry Potter
Author - JK Rowling
	
Book ID - 2
Name - Harry Potter
Author - JK Rowling
---------------------------------
---------------------------------
Register a member
Remove a member
Add a book
Remove a book
View all members along with their books and fines to be paid
View all books
Back
---------------------------------
7
---------------------------------
Enter as a librarian
Enter as a member
Exit
---------------------------------
2
Name : Rick Dunphy
Phone No: 9999999990
Member with Name: Rick Dunphy and Phone No: 9999999990 doesn't exist. 
---------------------------------
Enter as a librarian
Enter as a member
Exit
          ---------------------------------
2
Name: Rick Dunphy
Phone No: 9999999993

Welcome Rick. Member ID: <MemberID>
---------------------------------
List Available Books
List My Books
Issue book
Return book
Pay Fine
Back
---------------------------------
3
---------------------------------
Book ID: 1
Book Name: Harry Potter
---------------------------------
Book Issued Successfully!
---------------------------------
List Available Books
List My Books
Issue book
Return book
Pay Fine
Back
---------------------------------
4
---------------------------------
Enter Book ID: 1

---------------------------------
Book ID: 1 successfully returned. 12 Rupees has been charged for a delay of 4 days. 

---------------------------------
List Available Books
List My Books
Issue book
Return book
Pay Fine
Back
---------------------------------
5
---------------------------------
You had a total fine of Rs. 12. It has been paid successfully!
---------------------------------
List Available Books
List My Books
Issue book
Return book
Pay Fine
Back
---------------------------------
6
---------------------------------
Enter as a librarian
Enter as a member
Exit
---------------------------------
3
---------------------------------
Thanks for visiting!
---------------------------------
