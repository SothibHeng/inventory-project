package co.options;

import co.inventory.InventoryProduct;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Search {
    public static void searchFunction(int currentPage, int rowsPerPage) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Search product by keyword: ");
        String searchKeyword = scanner.nextLine().toLowerCase();

        List<InventoryProduct> matchingProducts = new ArrayList<>();

        for (InventoryProduct product : Write.stockManagementArrayList) {
            String productName = product.getProductName().toLowerCase();

            if (productName.contains(searchKeyword)) {
                matchingProducts.add(product);
            }
        }

        int totalPages = (int) Math.ceil((double) matchingProducts.size() / rowsPerPage);
        if (matchingProducts.isEmpty()) {
            System.out.println("No products found containing the keyword '" + searchKeyword + "'.");
        } else {
            if (currentPage < 1) {
                currentPage = 1;
            } else if (currentPage > totalPages) {
                currentPage = totalPages;
            }

            int startIndex = (currentPage - 1) * rowsPerPage;
            int endIndex = Math.min(startIndex + rowsPerPage, matchingProducts.size());

            Table tableDisplay = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER);
            tableDisplay.addCell(" ".repeat(2) + "ID" + " ".repeat(2));
            tableDisplay.addCell(" ".repeat(2) + "Name" + " ".repeat(2));
            tableDisplay.addCell(" ".repeat(2) + "Unit Price" + " ".repeat(2));
            tableDisplay.addCell(" ".repeat(2) + "Qty" + " ".repeat(2));
            tableDisplay.addCell(" ".repeat(2) + "Imported Date" + " ".repeat(2));

            for (int i = startIndex; i < endIndex; i++) {
                InventoryProduct product = matchingProducts.get(i);
                tableDisplay.addCell(" ".repeat(2) + product.getProductId().toString());
                tableDisplay.addCell(" ".repeat(2) + product.getProductName());
                tableDisplay.addCell(" ".repeat(2) + product.getProductUnitPrice().toString());
                tableDisplay.addCell(" ".repeat(2) + product.getProductQty().toString());
                tableDisplay.addCell(" ".repeat(2) + product.getDate().toString());
            }

            System.out.println(tableDisplay.render());
            System.out.println("~ ".repeat(60));

            System.out.println("Page " + currentPage + " of " + totalPages + " ".repeat(40) + "Total matching products: " + matchingProducts.size());
            System.out.println("~ ".repeat(60));
        }
    }
}
