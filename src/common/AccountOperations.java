package common;
import java.rmi.*;

public interface AccountOperations extends Remote {
    public double withdraw(double amount) throws RemoteException;
    public double deposit(double amount) throws RemoteException;
}
