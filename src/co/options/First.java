package co.options;

public class First {
    public static void firstPageFunction(int currentPage, int rowsPerPage) {
        if (currentPage == 1) {
            System.out.println("You are already on the first page.");
        } else {
            currentPage = 1;
            Display.displayFunction(currentPage, rowsPerPage);
        }
    }
}
