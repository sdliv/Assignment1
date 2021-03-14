package bank;

import common.AccountOperations;
import java.rmi.RemoteException;
import java.rmi.server.*;

public class AccountImpl extends UnicastRemoteObject implements AccountOperations {
    private String _name = "John Raymond";
    private Money _balance;

    public AccountImpl() throws RemoteException {
        super();
        this._balance = new Money();
    }

    public Money getBalance() {
        return _balance;
    }

    public void setBalance(Money balance) {
        this._balance = balance;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public double withdraw(double amount) {
        if (_balance != null && _balance.balance >= 0) {
            _balance.balance = _balance.balance - amount;
        }
        System.out.println("AccountImpl server: got request from client");
        System.out.println("Withrawing remotely in server");
        System.out.println("Amount returned to you: " + amount);
        System.out.println("New Balance: " + _balance.balance);
        return _balance.balance;
    }

    public double deposit(double amount) {
        if (_balance != null) {
            _balance.balance = _balance.balance + amount;
        }
        System.out.println("AccountImpl server: got request from client");
        System.out.println("Depositing remotely in server");
        System.out.println("Amount being deposited: " + amount);
        System.out.println("New Balance: " + _balance.balance);
        return _balance.balance;
    }
}