package kr.ac.korea.kkumtree.store.api;

import kr.ac.korea.kkumtree.store.dto.StoreDetailDto;
import lombok.Getter;

@Getter
public class StoreResponse {
    private StoreDetailDto store;

    public StoreResponse(StoreDetailDto store) {
        this.store = store;
    }
}
