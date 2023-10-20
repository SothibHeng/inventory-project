package co.options;

import co.inventory.InventoryProduct;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.time.LocalDate;
import java.util.*;

public class Write {

    static List<InventoryProduct> stockManagementArrayList = new ArrayList<>();
    static InventoryProduct stockManagement = new InventoryProduct();
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void writeFunction() {
        int randomNumber = random.nextInt(20) + 1;
        stockManagement.setDate(LocalDate.now());
        Integer proID = stockManagement.setProductId(randomNumber);
        System.out.println("Product ID : " + proID);
        System.out.print("Product's name : ");
        String proName = stockManagement.setProductName(scanner.next());
        System.out.print("Product's Price : ");
        Integer proPrice = stockManagement.setProductUnitPrice(scanner.nextInt());
        System.out.print("Product's Qty : ");
        Integer proQty = stockManagement.setProductQty(scanner.nextInt());
        addItem(new InventoryProduct(proID, proName, proPrice, proQty, LocalDate.now()));
        Table table = getTable();
        System.out.println(table.render());
        System.out.print("Are you sure want to add this record? [Y/y] or [N/n]: ");
        String userInput = scanner.next();
        if (userInput.equals("Y") || Objects.equals(userInput, "y")) {
            System.out.println("~".repeat(30));
            System.out.println(stockManagement.getProductId() + " was added successfully! ");
            System.out.println("~".repeat(30));
        } else if (userInput.equals("N") || Objects.equals(userInput, "n")) {
            removeItem(stockManagement);
            System.out.println("Product is not added");
        }
    }

    private static Table getTable() {
        Table table = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.SURROUND);
        table.addCell("ID" + " ".repeat(20) + ": " + stockManagement.getProductId());
        table.addCell("Name" + " ".repeat(18) + ": " + stockManagement.getProductName());
        table.addCell("Unit Price" + " ".repeat(12) + ": " + stockManagement.getProductUnitPrice());
        table.addCell("Qty" + " ".repeat(19) + ": " + stockManagement.getProductQty());
        table.addCell("Imported Date" + " ".repeat(9) + ": " + stockManagement.getDate());
        return table;
    }
    public static void addItem(InventoryProduct stockManagement) {
        stockManagementArrayList.add(stockManagement);
    }

    public static void removeItem(InventoryProduct stockManagement) {
        stockManagementArrayList.remove(stockManagement);
    }
}


