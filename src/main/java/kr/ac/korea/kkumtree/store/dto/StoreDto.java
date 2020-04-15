package kr.ac.korea.kkumtree.store.dto;

import kr.ac.korea.kkumtree.store.model.Store;
import kr.ac.korea.kkumtree.store.model.StoreCategory;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.locationtech.jts.geom.Point;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class StoreDto {
    private Long id;
    private String name;
    private String address;
    private String telNumber;
    private double latitude;
    private double longitude;



    public static StoreDto of(Store store) {
        return StoreDto.builder()
            .id(store.getId())
            .address(store.getAddress())
            .latitude(store.getLocation().getCoordinate().getX())
            .longitude(store.getLocation().getCoordinate().getY())
            .telNumber(store.getTelNumber())
            .build();
    }
}
