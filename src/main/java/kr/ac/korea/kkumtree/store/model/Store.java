package kr.ac.korea.kkumtree.store.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.locationtech.jts.geom.Point;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Entity
@Table(name = "kkumtree_store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "telNumber")
    private String telNumber;

    @Column
    private Point location;

    @ManyToOne
    private StoreCategory storeCategory;
}
