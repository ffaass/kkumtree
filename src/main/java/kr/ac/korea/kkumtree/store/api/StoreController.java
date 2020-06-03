package kr.ac.korea.kkumtree.store.api;

import kr.ac.korea.kkumtree.common.ApiResponse;
import kr.ac.korea.kkumtree.store.dto.Location;
import kr.ac.korea.kkumtree.store.dto.StoreDetailDto;
import kr.ac.korea.kkumtree.store.service.FindStoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {
    private final FindStoreService findStoreService;

    public StoreController(FindStoreService findStoreService) {
        this.findStoreService = findStoreService;
    }


    @GetMapping("/stores/nearby")
    public ApiResponse<StoreListResponse> findNearbyStores(Location location) {
        return ApiResponse.ok(new StoreListResponse(findStoreService.findNearbyStores(location)));
    }

}
