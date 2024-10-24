public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] =
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (qtyOrdered == MAX_NUMBERS_ORDERED){
            System.out.println("The cart is full!");
        }

        else {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered += 1;

            System.out.println("The disc has been added!");
            if (qtyOrdered == MAX_NUMBERS_ORDERED){
                System.out.println("The cart is full!");
            }
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        boolean check = false;
        for(int i = 0; i < MAX_NUMBERS_ORDERED; i++){
            if (itemsOrdered[i] == disc){
                DigitalVideoDisc tmp[] = itemsOrdered.clone();

                for (int j = 0, k = 0; j< qtyOrdered; j++){
                    if (itemsOrdered[j] != disc){
                        tmp[k] = itemsOrdered[j];
                        k++;
                    }
                }
                itemsOrdered = tmp.clone();
                System.out.println("The disc has been removed!");
                qtyOrdered--;
                check = true;
                break;
            }
        }
        if(!check){
            System.out.println("The disc is not in the cart!");
        }
    }

    public float totalCost(){
        float cost = 0;
        for (int i = 0; i < qtyOrdered; i++){
            cost += itemsOrdered[i].getCost();
        }
        return cost;
    }
}
