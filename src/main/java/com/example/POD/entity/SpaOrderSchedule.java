package com.example.POD.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="SPA_ORDER_SCHEDULE")
@NoArgsConstructor
public class SpaOrderSchedule {
    @Column(name="schedule_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long scheduleId;

    @Column(name="order_id")
    private long orderId;

    @Column(name="order_detail_id")
    private long orderDetailId;

    @Column(name="product_name")
    private String productName;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private ChainCustomer chainCustomer;

    /* @Column(name="customer_name")
    private String customerName; */

    @Column
    private int duration;

    @Column(name="shop_id")
    private long shopId;

    @Column(name="schedule_date")
    private String scheduleDate;

    @Column(name="schedule_end")
    private String scheduleEnd;

    @Column(name="technical_staff_id")
    private String technicalStaffId;

    @Column(name="sale_staff_id")
    private String saleStaffId;

    @Column
    private String note;

    @Column
    private int status;

    @Column(name="created_date", updatable = false) //current timestamp
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name="modified_date") //current timestamp
    @UpdateTimestamp
    private LocalDateTime modifiedDate;

    @Column(name="checkin_date") //current timestamp
    private LocalDateTime checkinDate;

    @Column(name="checkout_date")
    private LocalDateTime checkoutDate;

    @Column(name="product_id")
    private long productId;

    @OneToOne(mappedBy = "spaOrderSchedule")
    private Feedback feedback;
}
