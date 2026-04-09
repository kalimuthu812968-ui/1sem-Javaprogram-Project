SOURCE CODE :
import java.util.Scanner;

public class SupermarketBillingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;
        double grandTotal = 0, totalDiscount = 0, gst;

        System.out.println("====== SUPERMARKET BILLING SYSTEM ======");

        System.out.print("Enter number of items: ");
        n = sc.nextInt();
        sc.nextLine();

        // Bill Header
        System.out.println("\n---------------- BILL ----------------");
        System.out.printf("%-12s %-10s %-10s %-10s %-10s\n",
                "Item", "Qty/Wt", "Rate", "Discount", "Final");

        for (int i = 1; i <= n; i++) {

            System.out.println("\nItem " + i);

            System.out.print("Enter item name: ");
            String itemName = sc.nextLine();

            System.out.print("Enter rate (per unit / per kg): ");
            double rate = sc.nextDouble();

            System.out.print("Enter type (1 = Quantity, 2 = Weight in kg): ");
            int type = sc.nextInt();

            double amount = 0;
            String qtyDisplay = "";

            //  Quantity Billing
            if (type == 1) {
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();
                amount = rate * qty;
                qtyDisplay = qty + " pcs";
            }

            //  Weight Billing (like rice, fruits)
            else if (type == 2) {
                System.out.print("Enter weight (kg): ");
                double weight = sc.nextDouble();
                amount = rate * weight;
                qtyDisplay = String.format("%.2f kg", weight);
            }

            //   Manual Discount (only for selected items)
            System.out.print("Is discount available? (1-Yes / 0-No): ");
            int hasDiscount = sc.nextInt();

            double discount = 0;

            if (hasDiscount == 1) {
                System.out.print("Enter discount percentage: ");
                double percent = sc.nextDouble();
                discount = amount * percent / 100;
            }

            double finalAmount = amount - discount;

            totalDiscount += discount;
            grandTotal += finalAmount;

            sc.nextLine(); // clear buffer

            // Print item row
            System.out.printf("%-12s %-10s %-10.2f %-10.2f %-10.2f\n",
                    itemName, qtyDisplay, rate, discount, finalAmount);
        }

        // GST Calculation
        gst = grandTotal * 0.05;
        double finalBill = grandTotal + gst;

        // Final Bill Summary
        System.out.println("\n-----------------------------------------------");
        System.out.printf("Total Discount : %.2f\n", totalDiscount);
        System.out.printf("GST (5%%)       : %.2f\n", gst);
        System.out.printf("Final Amount   : %.2f\n", finalBill);
        System.out.println("-----------------------------------------------");
        System.out.println("     Thank You! Visit Again      ");

        sc.close();
    }
}
