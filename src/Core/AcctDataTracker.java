package Core;

import java.io.*;

public class AcctDataTracker {

    public static void outputAccounts(Object accounts) throws IOException {
        ObjectOutputStream output;
        output = new ObjectOutputStream(new FileOutputStream("accounts.csv"));
        output.writeObject(accounts);
        System.out.println("A full list of accounts fot the application can be found under the location where this program was saved.");
    }

    public static Object readAccounts() throws IOException, ClassNotFoundException {
        ObjectInputStream input;
        input = new ObjectInputStream(new FileInputStream("accounts.csv"));
        return input.readObject();
    }
}
