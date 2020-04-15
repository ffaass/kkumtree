package kr.ac.korea.kkumtree.store.api;

import kr.ac.korea.kkumtree.store.dto.Location;
import kr.ac.korea.kkumtree.store.dto.StoreDto;
import kr.ac.korea.kkumtree.store.service.FindStoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {
    private final FindStoreService findStoreService;

    public StoreController(FindStoreService findStoreService) {
        this.findStoreService = findStoreService;
    }


    @GetMapping("/stores/nearby")
    public ResponseEntity<List<StoreDto>> findNearbyStores(Location location) {
        return ResponseEntity.ok(findStoreService.findNearbyStores(location));
    }
}
