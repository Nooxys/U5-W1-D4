package CiroVitiello.U5W1D4.entities;

import CiroVitiello.U5W1D4.enums.TableStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Table {
    private int numberOfTable;
    private int numberOfPeople;
    private TableStatus status;
}
