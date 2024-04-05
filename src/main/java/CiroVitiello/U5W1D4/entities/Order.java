package CiroVitiello.U5W1D4.entities;

import CiroVitiello.U5W1D4.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;
import java.util.List;
import java.util.Random;

@Getter
@Setter
@ToString
public class Order {
    private int number;
    private OrderStatus status;
    private int numberOfPeople;
    private LocalTime takenHour = LocalTime.now();
    private double total;
    private Table table;
    private List<Item> items;
    private double tax;

    public Order(int number, OrderStatus status, Table table, List<Item> items, double tax) {
        this.number = number;
        this.status = status;
        this.table = table;
        this.items = items;
        this.tax = tax;
        setRandomNumberOfPeople();
        setTotalAmount();
    }

    public void setRandomNumberOfPeople() {
        Random random = new Random();
        this.numberOfPeople = random.nextInt(1, this.table.getNumberOfPeople() + 1);
    }

    public void setTotalAmount() {
        this.total = this.numberOfPeople * this.tax + this.items.stream().mapToDouble(items -> items.getPrice()).sum();
    }

    ;

//    public void printOrder(){
//        System.out.println("-----ORDER-----");
//        System.out.println("order number " + this.number);
//        System.out.println("number of people " + this.numberOfPeople);
//        System.out.println("table " + this.table);
//        System.out.println("total " + this.total);
//    }

}
