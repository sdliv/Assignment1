package bank;

import common.AccountOperations;

import java.rmi.Naming;

public class RemoteAccount {
    public static void main (String[] args) {

        try {
            AccountOperations remote_obj = new AccountImpl();
            String location = "//in-csci-rrpc01:2324/RemoteAccountImpl";
//            String location = "rmi://localhost/RemoteAccountImpl";
            Naming.rebind(location,remote_obj);
            System.out.println("Server is ready");
        } catch (Exception e) {
            System.out.println("Server err:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
