package kr.ac.korea.kkumtree.store.model;


import lombok.AccessLevel;
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


@Getter
@NoArgsConstructor
@Entity
@Table(name = "kkumtree_store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "telNumber", nullable = false)
    private String telNumber;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Column
    private Point location;

    @ManyToOne
    private StoreCategory storeCategory;

    public Store(String name,
                 String address,
                 String telNumber,
                 Point location,
                 StoreCategory storeCategory) {
        this.name = name;
        this.address = address;
        this.telNumber = telNumber;
        this.location = location;
        this.storeCategory = storeCategory;
    }
}
