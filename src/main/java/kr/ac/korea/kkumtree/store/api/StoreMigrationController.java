package kr.ac.korea.kkumtree.store.api;

import kr.ac.korea.kkumtree.store.infrastructure.StoreCategoryRepository;
import kr.ac.korea.kkumtree.store.infrastructure.StoreRepository;
import kr.ac.korea.kkumtree.store.model.Store;
import kr.ac.korea.kkumtree.store.model.StoreCategory;
import lombok.Getter;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

@RestController
@RequestMapping("/stores")
@Profile("store_upload")
public class StoreMigrationController {
    private final WKTReader wktReader;
    private final StoreCategoryRepository storeCategoryRepository;
    private final StoreRepository storeRepository;

    public StoreMigrationController(StoreCategoryRepository storeCategoryRepository,
                                    StoreRepository storeRepository) {
        this.storeCategoryRepository = storeCategoryRepository;
        this.wktReader = new WKTReader();
        this.storeRepository = storeRepository;
    }

    @PostMapping
    public ResponseEntity<Void> uploadStores(@RequestBody StoreListUploadRequest request)
        throws ParseException {
        Map<String, StoreCategory> categoryByName = storeCategoryRepository.findAll()
            .stream()
            .collect(toMap(StoreCategory::getName, Function.identity()));
        List<Store> stores = new ArrayList<>();
        for (StoreUploadDto dto : request.getStores()) {
            Store store = new Store(
                dto.getName(),
                dto.getAddress(),
                dto.getTelNumber(),
                dto.getLatitude(),
                dto.getLongitude(),
                (Point) wktReader.read(String.format(
                    "POINT(%s %s)", dto.getLatitude(), dto.getLongitude())
                ),
                categoryByName.get(dto.getCategoryName())
            );
            stores.add(store);
        }
        storeRepository.saveAll(stores);
        return ResponseEntity.ok().build();
    }

    @Getter
    private static class StoreListUploadRequest {
        private List<StoreUploadDto> stores;
    }

    @Getter
    private static class StoreUploadDto {
        private String name;
        private String address;
        private String telNumber;
        private Double latitude;
        private Double longitude;
        private String categoryName;
    }
}
