package cz.blackblog.website;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;

// this class is used for authenticating users against native user database
public class NativeAuthenticator {
    private final HashMap<String, String> userDatabase;


    public NativeAuthenticator(String pathToUserDatabase) {
        this.userDatabase = new HashMap<String, String>();
        // read file into hashmap
        try {
            FileInputStream fis = new FileInputStream(pathToUserDatabase);
            Scanner sc = new Scanner(fis);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(":");
                this.userDatabase.put(parts[0], parts[1]);
            }
        }catch (Exception e) {
            System.out.println("Error reading user database file: " + e.getMessage());
        }
    }

    // returns true if user is authenticated
    public boolean authenticate(String username, String password) {
        if (this.userDatabase.containsKey(username)) {
            return this.userDatabase.get(username).equals(password);
        }
        return false;
    }

}
