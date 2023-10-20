package co.options;

import java.util.Scanner;

public class SetRow {
    public static void setRowFunction(int rowsPerPage) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter number of row(s) you want to display : ");
            int numberOfRows = Integer.parseInt(sc.nextLine());
            if (numberOfRows >0 && numberOfRows <= Write.stockManagementArrayList.size()){
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
