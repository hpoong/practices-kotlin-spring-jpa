package com.hopoong.jpa.entity

import org.hibernate.annotations.Comment
import javax.persistence.*


@Entity
@Table(name = "hcc_category")
class Category (

    // ************* Column

    @Comment("PK")
    @Id @GeneratedValue
    @Column(name = "hcc_category_id")
    var id: Long,

    @Comment("카테고리이름")
    var name: String,

    @Comment("부모 카테고리 FK")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hcc_parent_id")
    var parent: Category,



    // *************

    @ManyToMany
    @JoinTable(
        name = "hcc_category_item",
        joinColumns = [JoinColumn(name = "hcc_category_id")],
        inverseJoinColumns = [JoinColumn(name = "hcc_item_id")]
    )
    var items: MutableList<Item> = ArrayList(),


    @Comment("상품 카테고리 Table")
    @OneToMany(mappedBy = "parent")
    var child: MutableList<Category> = ArrayList(),

)