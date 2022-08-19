package Classes;

import Enums.Product;
import Enums.Status;

import java.util.concurrent.atomic.AtomicInteger;

public class Opportunity {

    //counter used to attach a new unique ID for every object instantiated.
    private static final AtomicInteger counter = new AtomicInteger(0);
    //attributes
    private int id;
    private Product product;
    private Contact decisionMaker;
    private Status status;

    //constructor
    public Opportunity(Product product, Contact decisionMaker, Status status) {
        id = counter.incrementAndGet(); //this setter give the object instantiated a unique ID, counting the past ones.
        setProduct(product);
        setDecisionMaker(decisionMaker);
        setStatus(status);
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    //getters
    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public Status getStatus() {
        return status;
    }
}
