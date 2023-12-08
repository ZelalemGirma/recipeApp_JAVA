import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class RecipeReader {
    
        private List<User> Recipe;

    public RecipeReader(String csvFileNameRecipe) {
        Recipe = new ArrayList<>();
        loadUsersFromCSV(csvFileNameRecipe);
    }

    private void loadUsersFromCSV(String csvFileNameRecipe) {

        // Recipe Reader Start

        try (BufferedReader br = new BufferedReader(new FileReader(csvFileNameRecipe))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line by the CSV delimiter (usually a comma)
                String[] data = line.split(",");

                // Print the data from each row
                for (String item : data) {
                    System.out.print(item + "\t");
                }
                System.out.println(); // Move to the next line for the next row of data
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }

        // Recipe Reader End

    }
}
