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
                            System.out.println("Access granted");
                            break;
                        }
                        else {
                            accessGranted = false;
                            System.out.println("Access denied, re-enter password, attempt: " + i + "/3");
                        }

                    }
                    security();
                    break;

                case 2:
                    System.out.print("Enter password: ");
                    passwordAttempt = read.nextLine();
                    for (int i = 1; i<4; i++) {
                        passwordAttempt = read.nextLine();
                        if (passwordAttempt.equals(password)) {
                            System.out.println("Access granted");
                            break;
                        }
                        else {
                            System.out.println("Access denied, re-enter password, attempt: " + i + "/3");
                        }

                    }


                    break;
                case 3:
                    System.out.println("Enter the name of the author: ");
                    search = read.nextLine();
                    for (int i = 0; i < inventory.length; i++) {
                        if (inventory[i].getAuthor().contains(search)){
                            System.out.println(inventory[i].toString());
                        }
                    }



                    break;



                case 4:

                    maxPrice = read.nextDouble();
                    for (int k=0; k < inventory.length; k++) {
                        if (inventory[k] != null && inventory[k].getPrice()<maxPrice) {
                            System.out.println("Book #" + (k+1) +inventory[k].toString()+ "\n");
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

        if (secure == 4) {
            System.out.println("Suspicious activity detected, the program will now shut down.");
            System.exit(0);
        }

    }




}
