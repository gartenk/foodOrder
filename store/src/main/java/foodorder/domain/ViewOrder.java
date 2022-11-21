package foodorder.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name="ViewOrder_table")
@Data
public class ViewOrder {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;


}