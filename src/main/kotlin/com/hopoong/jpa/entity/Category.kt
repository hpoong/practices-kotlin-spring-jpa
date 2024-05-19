package com.hopoong.jpa.entity

import javax.persistence.*


@Entity
@Table(name = "hcc_category")
class Category (

    @Id @GeneratedValue
    @Column(name = "hcc_category_id")
    var id: Long,

    var name: String,

    @ManyToMany
    @JoinTable(
        name = "hcc_category_item",
        joinColumns = [JoinColumn(name = "hcc_category_id")],
        inverseJoinColumns = [JoinColumn(name = "hcc_item_id")]
    )
    var items: MutableList<Item> = ArrayList(),


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hcc_parent_id")
    var parent: Category,

    @OneToMany(mappedBy = "parent")
    var child: MutableList<Category> = ArrayList()
)