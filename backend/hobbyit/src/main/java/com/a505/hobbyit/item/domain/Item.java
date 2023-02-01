package com.a505.hobbyit.item.domain;

import com.a505.hobbyit.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name = "item")
public class Item extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Long itemTypeId;

    @Column(nullable = false, length = 16)
    private String name;

    @Column(name = "rqd_point", nullable = false)
    private int requiredPoint;

    @Column(nullable = false)
    private String imgUrl;
}
