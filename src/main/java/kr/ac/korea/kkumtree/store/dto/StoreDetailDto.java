package kr.ac.korea.kkumtree.store.dto;


import kr.ac.korea.kkumtree.store.model.Benefit;
import kr.ac.korea.kkumtree.store.model.Menu;
import kr.ac.korea.kkumtree.store.model.Store;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class StoreDetailDto {
    private Long id;
    private String name;
    private String address;
    private String telNumber;
    private Double latitude;
    private Double longitude;
    private String category;
    private String categoryImgUrl;
    private List<MenuDto> menus;
    private List<BenefitDto> benefits;

    public static StoreDetailDto of(Store store,
                                    List<Menu> menus,
                                    List<Benefit> benefits) {
        return StoreDetailDto.builder()
            .id(store.getId())
            .name(store.getName())
            .address(store.getAddress())
            .category(store.getStoreCategory().getName())
            .latitude(store.getLatitude())
            .longitude(store.getLongitude())
            .telNumber(store.getTelNumber())
            .categoryImgUrl(store.getStoreCategory().getImageUrl())
            .menus(menus.stream()
                .map(menu -> MenuDto.builder()
                    .id(menu.getId())
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .build())
                .collect(toList()))
            .benefits(benefits.stream()
                .map(benefit -> BenefitDto.builder()
                    .id(benefit.getId())
                    .name(benefit.getName())
                    .description(benefit.getDescription())
                    .build())
                .collect(toList()))
            .build();
    }

    @Getter
    @Builder(access = AccessLevel.PRIVATE)
    static class MenuDto {
        private Long id;
        private String name;
        private long price;
    }

    @Getter
    @Builder(access = AccessLevel.PRIVATE)
    static class BenefitDto {
        private Long id;
        private String name;
        private String description;
    }
}
