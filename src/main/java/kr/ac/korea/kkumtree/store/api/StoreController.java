package kr.ac.korea.kkumtree.store.api;

import kr.ac.korea.kkumtree.common.ApiResponse;
import kr.ac.korea.kkumtree.store.dto.Location;
import kr.ac.korea.kkumtree.store.service.FindStoreDetailService;
import kr.ac.korea.kkumtree.store.service.FindStoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {
    private final FindStoreService findStoreService;
    private final FindStoreDetailService findStoreDetailService;


    public StoreController(FindStoreService findStoreService,
                           FindStoreDetailService findStoreDetailService) {
        this.findStoreService = findStoreService;
        this.findStoreDetailService = findStoreDetailService;
    }


    @GetMapping("/stores/nearby")
    public ApiResponse<StoreListResponse> findNearbyStores(Location location) {
        return ApiResponse.ok(new StoreListResponse(findStoreService.findNearbyStores(location)));
    }

    @GetMapping("/stores/{id}")
    public ApiResponse<StoreResponse> findStore(@PathVariable Long id) {
        return ApiResponse.ok(new StoreResponse(findStoreDetailService.findById(id)));
    }
}
