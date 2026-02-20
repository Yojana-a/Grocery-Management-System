public static void printInventory(String[] names, double[] prices, int[] stocks){
    for(int i=0; i<names.length; i++){
        if(names[i]!=null){
            System.out.println("Item: "+ names[i]);
            System.out.println("Price: "+prices[i]);
            System.out.println("Stock "+stocks[i]);
        }
    }
}
