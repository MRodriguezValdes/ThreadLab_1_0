public class Product extends ProtectedCounter {
    String description;

    public Product(String description) {
        super();
        this.description=description;
    }

    public void produce(Boolean sync , Boolean positiveStock){
        if(sync){
            this.incSync(positiveStock);
        }else {
            this.inc(positiveStock);
        }

    }
    public void consume(Boolean sync , Boolean positiveStock){
        if(sync){
            this.decSync(positiveStock);
        }else {
            this.dec(positiveStock);
        }

    }

    public int getStock(){
        return this.getValue();
    }



}
