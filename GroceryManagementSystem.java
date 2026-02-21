
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
