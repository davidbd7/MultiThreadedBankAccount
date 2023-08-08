/****************************************************************************
* David Daniel
* CS149
* August 3rd, 2023
*
* Abstract: Main method for multithreaded Bank Account. The main takes in user input for withdrawing and depositing to a 
* bank account that starts with 1000 dollars. You can click w to withdraw, d to deposit, and q to quit. It then prints the 
* final bank account balance. 
*
***************************************************************************/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccountThread bankAccount = new BankAccountThread(1000.0);

        //scanner initation
        Runnable userInteraction = () -> {
            Scanner scanner = new Scanner(System.in);
            //handles user input in while loop
            while (true) {
                System.out.println("Enter 'd' to deposit, 'w' to withdraw, or 'q' to quit:");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("q")) {
                    break;
                } else if (choice.equalsIgnoreCase("d")) {
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.depositAmount(depositAmount);
                } else if (choice.equalsIgnoreCase("w")) {
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    bankAccount.withdrawAmount(withdrawalAmount);
                }
            }
        };

        //creation of thread
        Thread userInteractionThread = new Thread(userInteraction, "UserInteraction");

        userInteractionThread.start();

        try {
            userInteractionThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //prints final balance
        System.out.println("Final account balance: " + bankAccount.getAccountBalance());
    }
}
