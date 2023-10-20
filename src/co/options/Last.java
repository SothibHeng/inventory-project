package co.options;

public class Last {
    public static void lastFunction(int currentPage, int rowsPerPage) {
        int totalPages = (int) Math.ceil((double) Write.stockManagementArrayList.size() / rowsPerPage);
        if (currentPage == totalPages) {
            System.out.println("You are already on the last page.");
        } else {
            currentPage = totalPages;
            Display.displayFunction(currentPage, rowsPerPage);
        }
    }
}
