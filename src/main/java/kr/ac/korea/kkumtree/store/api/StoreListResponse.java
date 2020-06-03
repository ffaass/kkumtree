package kr.ac.korea.kkumtree.store.api;

import kr.ac.korea.kkumtree.store.dto.StoreDto;
import lombok.Getter;

import java.util.List;

@Getter
public class StoreListResponse {
    private List<StoreDto> stores;

    public StoreListResponse(List<StoreDto> stores) {
        this.stores = stores;
    }
}
