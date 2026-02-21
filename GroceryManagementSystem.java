import java.util.Scanner; 
 /**
     * The GroceryManagementSystem class provides utility methods
     * for managing grocery inventory operations such as restocking items.
     *
     * This implementation uses parallel arrays where:
     * - names[] stores item names
     * - stocks[] stores corresponding stock quantities
     *
     * Index positions in both arrays represent the same grocery item.
     */


public class GroceryManagementSystem {

    
    /**
    * This is the main method that runs the Grocery Management System menu.
    * It makes the parallel arrays for item names, prices,
    * and stock amounts, then displays a menu
    * letting the user: view the inventory, restock an item,
    * and exit the program.
    * The menu runs until the user exits out of it.
    */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //the parallel arrays
        String[] itemNames = new String[10];
        double[] itemPrices = new double[10];
        int[] itemStocks = new int[10];

        //some data to start with
        itemNames[0] = "Nutella";
        itemPrices[0] = 2.39;
        itemStocks[0] = 5;

        itemNames[1] = "Turkey";
        itemPrices[1] = 4.99;
        itemStocks[1] = 10;

        itemNames[2] = "Apples";
        itemPrices[2] = 2.79;
        itemStocks[2] = 15;

        int choice = 0;

        while(choice != 3){
            System.out.println("\n---- Grocery Menu ----");
            System.out.println("1) View Inventory");
            System.out.println("2) Restock Item");
            System.out.println("3) Exit");
            System.out.print("Choose an option: ");

            choice = input.nextInt();

            switch(choice){
                case 1:
                    printInventory(itemNames,itemPrices,itemStocks);
                    break;
                case 2:
                    System.out.print("Enter item name: ");
                    String target = input.next();

                    System.out.print("Enter amount to add: ");
                    int amount=input.nextInt();

                    restockItem(itemNames,itemStocks,target,amount);
                    break;

                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
        input.close();
    }
     /**
     * Prints all non-null grocery items in the inventory.
     *
     * Each item’s name, price, and stock quantity are displayed.
     * Only array positions where names[i] is not null are printed.
     *
     * @param names   Array of grocery item names
     * @param prices  Array of item prices
     * @param stocks  Array of stock quantities
     */
    
    public static void printInventory(String[] names, double[] prices, int[] stocks){

        for(int i=0; i<names.length; i++){
            if(names[i]!=null){
                System.out.println("Item: "+ names[i]);
                System.out.println("Price: "+prices[i]);
                System.out.println("Stock "+stocks[i]);
            }
        }
    }

    /**
     * Restocks a specific grocery item by increasing its stock quantity.
     *
     * This method searches for the target item (case-insensitive) 
     * in the names array. If found, it increases the stock value 
     * at the corresponding index in the stocks array.
     *
     * If the item is not found, a message is printed.
     *
     * @param names   An array of grocery item names.
     * @param stocks  An array of stock quantities corresponding to each item.
     * @param target  The name of the item to restock.
     * @param amount  The quantity to add to the existing stock.
     */

    public static void restockItem(String[] names, int[] stocks, String target, int amount) {
        boolean found = false;

        for (int i = 0; i < names.length; i++) {
            if (names[i] != null && names[i].equalsIgnoreCase(target)) {
                stocks[i] += amount;
                System.out.println("Restocked " + target + ". New stock: " + stocks[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Item not found.");
        }
    }
}
