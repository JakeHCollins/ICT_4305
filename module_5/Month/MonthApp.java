import java.util.ArrayList;
import java.util.HashMap;

public class MonthApp {
    public static void main(String[] args) {

        // Code now shows all three collection types to meet assignment requirements
        @SuppressWarnings("unchecked")
        Month<Integer>[] monthNumberArray = new Month[12];
        @SuppressWarnings("unchecked")
        Month<String>[] monthNameArray = new Month[12];

        
        String[] monthNames = { "January", "February", "March", "April", "May", "June",
                                "July", "August", "September", "October", "November", "December" };

        for (int i = 0; i < 12; i++) {
            monthNumberArray[i] = new Month<>(i + 1);
            monthNameArray[i] = new Month<>(monthNames[i]);
        }

        // Added section to show use of ArrayLists
        ArrayList<Month<Integer>> monthNumberList = new ArrayList<>();
        ArrayList<Month<String>> monthNameList = new ArrayList<>();

        // Populate ArrayLists with data from arrays
        for (int i = 0; i < 12; i++) {
            monthNumberList.add(monthNumberArray[i]);
            monthNameList.add(monthNameArray[i]);
        }

        // Code now uses clear HashMap key/value pairing between integer and string months
        HashMap<Integer, String> monthMap = new HashMap<>();
        for (int i = 0; i < 12; i++) {
            monthMap.put(monthNumberList.get(i).getMonth(), monthNameList.get(i).getMonth());
        }

        // Added a print output for arrays
        System.out.println("Array Output:");
        for (int i = 0; i < 12; i++) {
            System.out.println(monthNumberArray[i].getMonth() + " = " + monthNameArray[i].getMonth());
        }

        // Added a print output for ArrayLists
        System.out.println("\nArrayList Output:");
        for (int i = 0; i < 12; i++) {
            System.out.println(monthNumberList.get(i).getMonth() + " = " + monthNameList.get(i).getMonth());
        }

        // Added a print output for HashMap
        System.out.println("\nHashMap Output:");
        for (int i = 1; i <= 12; i++) {
            System.out.println(i + " = " + monthMap.get(i));
        }
    }
}
