package geekbrains.home.des.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sells_tbl")
public class Sell {
    private static final String SEQUANCE_NAME = "sell_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUANCE_NAME)
    @SequenceGenerator(name = SEQUANCE_NAME, sequenceName = SEQUANCE_NAME, allocationSize = 1)
    @Column(name = "sell_id")
    private Long sellId;

    @Column(name = "created_fld")
    @CreatedDate
    private LocalDateTime created;

    @Column(name = "orderd_id")
    private Long orderID;

    @Column(name = "username_fld")
    private String username;

    @Column(name = "product_title_fld")
    private String productTitle;

    @Column(name = "amount_fld")
    private Long amount;

    @Column(name = "sum_fld")
    private BigDecimal sum;


}
