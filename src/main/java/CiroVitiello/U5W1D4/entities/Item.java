package CiroVitiello.U5W1D4.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@ToString
@NoArgsConstructor

public abstract class Item {
    protected int calories;
    protected double price;
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private long id;

    public Item(int calories, double price) {
        this.calories = calories;
        this.price = price;
    }

}
