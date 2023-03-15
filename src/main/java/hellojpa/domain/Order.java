package hellojpa.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
// 굳이 ORDERS 로 하는 이유는 DB 중에서  order by 때문에 order 가 예약어로 걸려있는 경우가 있기 때문.
// 그래서 ORDERS 로 많이 씀.
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId;
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
