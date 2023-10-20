package co.options;

import co.inventory.InventoryProduct;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.time.LocalDate;
import java.util.Scanner;

public class Delete {
    public static void deleteFunction() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID of the product you want to delete: ");
        Integer productId = Integer.parseInt(sc.nextLine());
        for (InventoryProduct product : Write.stockManagementArrayList) {
            if (product.getProductId().equals(productId)) {
                Table table = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND);
                table.addCell(" ID            : " + product.getProductId() + " ".repeat(10));
                table.addCell(" Name          : " + product.getProductName() + " ".repeat(10));
                table.addCell(" Unit price    : " + product.getProductUnitPrice() + " ".repeat(10));
                table.addCell(" Qty           : " + product.getProductQty() + " ".repeat(10));
                table.addCell(" Imported Date : " + LocalDate.now() + " ".repeat(10));
                System.out.println(table.render());
                System.out.print("Are you sure to add this record? [Y/y] or [N/n] : ");
                String options = sc.nextLine();
                switch (options) {
                    case "y", "Y" -> {
                        Write.stockManagementArrayList.remove(product);
                        System.out.println("Product with ID " + productId + " deleted successfully.");
                        return;
                    }
                    case "n", "N" -> {
                        System.out.println("Product is not deleted");
                        return;
                    }
                    default -> System.out.println("Invalid options");
                }
            }
        }
    }
}
