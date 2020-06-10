package kr.ac.korea.kkumtree.store.dto;

import kr.ac.korea.kkumtree.store.model.Store;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

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
    private String category;
    private String categoryImgUrl;

    public static StoreDto of(Store store) {
        return StoreDto.builder()
            .id(store.getId())
            .name(store.getName())
            .address(store.getAddress())
            .latitude(store.getLocation().getCoordinate().getX())
            .longitude(store.getLocation().getCoordinate().getY())
            .telNumber(store.getTelNumber())
            .category(store.getStoreCategory().getName())
            .categoryImgUrl(store.getStoreCategory().getImageUrl())
            .build();
    }
}
