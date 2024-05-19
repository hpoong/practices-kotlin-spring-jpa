package com.hopoong.jpa.entity

import javax.persistence.*


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Table(name = "hcc_item")
abstract class Item (

    @Id
    @GeneratedValue
    @Column(name = "hcc_item_id")
    val id: Long = 0L,

    var name: String,

    var price: Int,

    var stockQuantity: Int,

    @ManyToMany(mappedBy = "items")
    var categories: MutableList<Category> = ArrayList()
)