package com.example.POD.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="CHAIN_EMPLOYMENT_PROFILE",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "phone", "chain_id" }) })
@NoArgsConstructor
public class ChainEmploymentProfile {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "sys_user_id")
    private long sysUserId;

    @Column(name = "chain_id")
    private long chainId;

    @Column(name = "shop_id")
    private long shopId;

    @Column
    private String name;

    @Column
    private String phone;

    @Column
    @Lob
    private byte[] image;

    @Column(name = "update_time")
    @UpdateTimestamp
    private LocalDateTime updateTime;

    @Column(name = "check_free")
    @Value("${some.key:1}")
    private int checkFree;

    @Column(name = "checkin_time")
    private LocalDateTime checkinTime;

    @OneToOne(mappedBy = "chainEmploymentProfile")
    private Feedback feedback;
}
