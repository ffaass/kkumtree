package kr.ac.korea.kkumtree.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kkumtree_store_category")
public class StoreCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "imageUrl", nullable = false, length = 1000)
    private String imageUrl;

    @Column
    private String name;
}
