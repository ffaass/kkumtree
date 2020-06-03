package kr.ac.korea.kkumtree.store.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "kkumtree_benefit")
public class Benefit {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Store store;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;
}
