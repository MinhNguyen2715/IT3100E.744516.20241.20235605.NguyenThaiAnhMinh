public class Store {
    private DigitalVideoDisc[] itemsInStore
            = new DigitalVideoDisc[10000000];

    private int disc_cnt = 0;

    public void addDVD(DigitalVideoDisc disc){
        if (disc_cnt == 10000000){
            System.out.println("The store is full!");
        }

        else {
            itemsInStore[disc_cnt] = disc;
            disc_cnt ++;

            System.out.println("The disc has been added!: "+ disc.toString());
            if (disc_cnt == 10000000){
                System.out.println("The cart is full!");
            }
        }
    }

    public void removeDVD(DigitalVideoDisc disc){
        boolean check = false;
        for(int i = 0; i < 10000000; i++){
            if (itemsInStore[i] == disc){
                DigitalVideoDisc tmp[] = itemsInStore.clone();

                for (int j = 0, k = 0; j< disc_cnt; j++){
                    if (itemsInStore[j] != disc){
                        tmp[k] = itemsInStore[j];
                        k++;
                    }
                }
                itemsInStore = tmp.clone();
                System.out.println("The disc has been removed from store!: " + disc.toString());
                disc_cnt--;
                check = true;
                break;
            }
        }
        if(!check){
            System.out.println("The disc is not in the store!");
        }
    }
}
