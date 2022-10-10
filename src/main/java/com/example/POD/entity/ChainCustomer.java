package com.example.POD.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name="CHAIN_CUSTOMER")
@NoArgsConstructor
public class ChainCustomer {
    @Column(name="customer_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;

    @Column(name="chain_id")
    private long chainId;

    @Column(name="shop_id")
    private long shopId;

    @Column(name="customer_name")
    private String customerName;

    @Column(name="customer_phone")
    private String customerPhone;

    @Column
    private int gender;

    @Column(name="customer_address")
    private String customerAddress;

    @Column(name="customer_dob")
    private String customerDob;

    @Column(name="customer_note")
    private String customerNote;

    @Column(name="customer_email")
    private String customerEmail;

    @Column(name="customer_facebook")
    private String customerFacebook;

    @Column(name="customer_zalo")
    private String customerZalo;

    @Column(name="customer_branch")
    private String customerBranch;

    @Column(name="customer_source")
    private int customerSource;

    @Column(name="customer_old_new")
    private int customerOldNew;

    @Column(name="customer_rank")
    private int customerRank;

    @Column(name="created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name="modified_date")
    @UpdateTimestamp
    private LocalDateTime modifiedDate;

    @Column(name="status")
    @Value("${some.key:1}")
    private int status;

    @Column(name="customer_ward_id")
    private int customerWardId;

    @Column(name="customer_ward_name")
    private String customerWardName;

    @Column(name="customer_district_id")
    private int customerDistrictId;

    @Column(name="customer_district_name")
    private String customerDistrictName;

    @Column(name="customer_province_id")
    private int customerProvinceId;

    @Column(name="customer_province_name")
    private String customerProvinceName;

    @OneToMany(mappedBy = "chainCustomer", cascade = CascadeType.ALL)
    private Set<SpaOrderSchedule> spaOrderSchedules;
}
