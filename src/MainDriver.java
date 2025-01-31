import java.util.Scanner;
import java.util.jar.JarOutputStream;

// --------------------------------------------------------
// Assignment #0
// Question: (include question/part number, if applicable)
// Written by: ABED-ELMOUHSEN CHERKAWI 40323359
// --------------------------------------------------------
public class MainDriver {
    public static void main(String[] args) {


        double maxPrice;
        int choice, innerChoice, maxBooks;
        final String password = "249";
        String  passwordAttempt, search;

        Book[] inventory;

        Scanner read = new Scanner(System.in);

        System.out.println("Welcome to the COMP249 bookstore!");
        System.out.println("Please enter the maximum number of books for the store: ");

        maxBooks = read.nextInt();
        inventory = new Book[maxBooks];




        do {
            System.out.print(" What do you want to do?" +
                    "   \n1. Enter new books (password required) " +
                    "   \n2. Change information of a book (password required) " +
                    "   \n3. Display all books by a specific author " +
                    "   \n4. Display all books under a certain a price. " +
                    "   \n5. Quit " +
                    " \nPlease enter your choice >");
            choice = read.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter password: ");
                    passwordAttempt = read.nextLine();
                    for (int i = 1; i<4; i++) {
                        passwordAttempt = read.nextLine();
                        if (passwordAttempt.equals(password)) {

                            accessGranted = true;
                            security();

                            System.out.println("Access granted");
                            System.out.println("Enter how many books you want to add: ");

                            int addBooks = read.nextInt();


                            for (int k=Book.findNumberOfCreatedBooks()  ; k < (Book.findNumberOfCreatedBooks() + addBooks); k++) {
                                inventory[k] = new Book();
                                read.nextLine();

                                System.out.print("Enter the title for book #" + (k+1) + ": ");
                                String title = read.nextLine();
                                inventory[k].setTitle(title);
                                System.out.print("Enter the author for book #" + (k+1) + ": ");
                                inventory[k].setAuthor(read.nextLine());
                                System.out.print("Enter the ISBN for book #" + (k+1) + ": ");
                                inventory[k].setISBN(read.nextLong());
                                System.out.print("Enter the price for book #" + (k+1) + ": ");
                                inventory[k].setPrice(read.nextDouble());

                                System.out.println("Book #" + (k+1) +" :\n"+ inventory[k].toString()+ "\n");
                            }

                            inventory[0].setBookCount(addBooks);
                            break;
                        }
                        else {
                            accessGranted = false;
                            System.out.println("Access denied, re-enter password, attempt: " + i + "/3");
                            security();
                        }

                    }

                    break;

                case 2:
                    System.out.print("Enter password: ");
                    passwordAttempt = read.nextLine();
                    for (int i = 1; i<4; i++) {
                        passwordAttempt = read.nextLine();
                        if (passwordAttempt.equals(password)) {
                            accessGranted = true;
                            System.out.println("Access granted");
                            System.out.print("\nEnter the book # you wish to modify: ");
                            int modifyBooks = read.nextInt()-1;

                                if (inventory[modifyBooks] != null) {
                                    System.out.println(inventory[modifyBooks].toString());

                                    System.out.println("What information would you like to change? " +
                                            "\n1. author " +
                                            "\n2. title " +
                                            "\n3. ISBN " +
                                            "\n4. price " +
                                            "\nAny other number to Quit " +
                                            "\nEnter your choice >");

                                    switch (read.nextInt()) {
                                        case 1:
                                            System.out.print("Enter new author: ");
                                            read.nextLine();
                                            inventory[modifyBooks].setAuthor(read.nextLine());
                                            System.out.println("Author updated successfully!");
                                            break;
                                            case 2:
                                                System.out.print("Enter new title: ");
                                                read.nextLine();
                                                inventory[modifyBooks].setTitle(read.nextLine());
                                                System.out.println("Title updated successfully!");
                                                break;
                                                case 3:
                                                    System.out.print("Enter new ISBN: ");
                                                    inventory[modifyBooks].setISBN(read.nextLong());
                                                    System.out.println("ISBN updated successfully!");
                                                    break;
                                                    case 4:
                                                        System.out.print("Enter new price: ");
                                                        inventory[modifyBooks].setPrice(read.nextDouble());
                                                        System.out.println("Price updated successfully!");
                                                        break;
                                                        default:
                                                            break;
                                    }




                                    break;
                                }

                                else{
                                    System.out.println("Book #" + modifyBooks + " not found, there are " +Book.findNumberOfCreatedBooks()+ " \nbooks in total, try again!\n");
                                }












                            break;
                        }
                        else {
                            System.out.println("Access denied, re-enter password, attempt: " + i + "/3");
                            accessGranted = false;
                            security();
                        }

                    }


                    break;
                case 3:
                    System.out.println("Enter the name of the author: ");
                    read.nextLine();
                    search = read.nextLine();
                    for (int i = 0; i < Book.findNumberOfCreatedBooks(); i++) {
                        if (inventory[i].getAuthor().toLowerCase().contains(search.toLowerCase())) {
                            System.out.println(inventory[i].toString());
                        }
                    }



                    break;



                case 4:
                    System.out.print("Enter a maximum price: ");
                    maxPrice = read.nextDouble();
                    for (int k=0; k < Book.findNumberOfCreatedBooks(); k++) {
                        if (inventory[k] != null && inventory[k].getPrice()<maxPrice) {
                            System.out.println("Book #" + (k+1) +":\n"+inventory[k].toString()+ "\n");
                        }

                    }
                    break;



                case 5:
                    System.out.println("Thank you for using COMP249 bookstore!");
                    break;

            }





        } while (choice != 5);





    }


    public static int secure = 0;
    public static boolean accessGranted;
    public static void security(){
        if (accessGranted) {
            secure = 0;
        }
        else {
            secure++;
        }

        if (secure == 12) {
            System.out.println("Suspicious activity detected, the program will now shut down.");
            System.exit(0);
        }

    }




}
