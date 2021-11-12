package com.banking;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BankAccount obj1 = new BankAccount("XYZ", "S9002");
        obj1.showMenu();
    }
}


class BankAccount
{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname, String cid)
    {
        customerName = cname;
        customerId = cid;
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }
        void withdraw(int amount)
        {
            if(amount != 0)
            {
                balance = balance-amount;
                previousTransaction = -amount;
            }
        }

        void getPreviousTransaction()
        {
            if(previousTransaction > 0)
            {
                System.out.println("Deposited Successfully"+previousTransaction);
            }
            else if(previousTransaction < 0)
            {
                System.out.println("Withdrawn"+ Math.abs(previousTransaction));
            }
            else
            {
                System.out.println("No transaction occured");
            }
    }

        void showMenu()
        {
            char option = '\0';
            Scanner dc = new Scanner(System.in);

            System.out.println("Welcome "+customerName);
            System.out.println("Your ID is "+customerId);
            System.out.println("\n");
            System.out.println("A. Check balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous transaction");
            System.out.println("E. EXIT");

            do {
                System.out.println("************************************************************************************************************************");
                System.out.println("Enter an Option");
                System.out.println("************************************************************************************************************************");
                option = dc.next().charAt(0);
                System.out.println("\n");

                switch(option)
                {
                    case 'A':
                        System.out.println("------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Your balance = "+balance);
                        System.out.println("------------------------------------------------------------------------------------------------------------------");
                        System.out.println("\n");
                        break;

                    case 'B':
                        System.out.println("------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Enter the amount you want to deposit: ");
                        System.out.println("------------------------------------------------------------------------------------------------------------------");
                        int amount = dc.nextInt();
                        deposit(amount);
                        System.out.println("\n");
                        break;

                    case 'C':
                        System.out.println("------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Enter the amount to withdraw: ");
                        System.out.println("------------------------------------------------------------------------------------------------------------------");
                        int amount2 = dc.nextInt();
                        withdraw(amount2);
                        System.out.println("\n");
                        break;

                    case 'D':
                        System.out.println("------------------------------------------------------------------------------------------------------------------");
                        getPreviousTransaction();
                        System.out.println("------------------------------------------------------------------------------------------------------------------");
                        System.out.println("\n");
                        break;

                    case 'E':
                        System.out.println("************************************************************************************************************************");
                        break;

                    default:
                        System.out.println("Invalid option please enter it again");
                        break;

                }
            }
            while(option != 'E');
            System.out.println("Thank you for using our services");
        }
}
