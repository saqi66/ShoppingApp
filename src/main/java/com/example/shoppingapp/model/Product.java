package com.example.shoppingapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "desk")
    private String desk;
    @Column(name = "sku")
    private String SKU;
    @Column(name = "category")
    private String category;
    @Column(name = "price")
    private float price;
    @Column(name = "discount_id")
    private Long discountId;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date createdAt;
    @UpdateTimestamp
    @Column(name = "modified_at")
    private Date modifiedAt;


    @ManyToOne
    @JoinColumn(name = "discount_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Discount discount;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private CardItem cardItem;
}
