package client;

import common.AccountOperations;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;


public class AccountClient {
    public static void main(String[] args) {
        try {
            Scanner readObj = new Scanner(System.in);
            String location = "//in-csci-rrpc01:2324/RemoteAccountImpl";
//            String location = "rmi://localhost/RemoteAccountImpl";
            double withdrawAmount = 25.00;
            double depositAmount = 100.00;
            AccountOperations stub = (AccountOperations)Naming.lookup(location);
            System.out.println("Client calling server");
            System.out.println("Amount deposited: " + depositAmount);
            System.out.println("New Balance: " + stub.deposit(depositAmount));
            System.out.println("Amount withdrawn: " + withdrawAmount);
            System.out.println("New Balance: " + stub.withdraw(withdrawAmount));
            System.out.println();
        } catch(Exception e) {
            System.out.println("Client err: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
