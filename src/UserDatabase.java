import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
     private List<User> users;

    public UserDatabase(String csvFileName) {
        users = new ArrayList<>();
        loadUsersFromCSV(csvFileName);
    }

    private void loadUsersFromCSV(String csvFileName) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(csvFileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    users.add(new User(parts[0], parts[1]));
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
