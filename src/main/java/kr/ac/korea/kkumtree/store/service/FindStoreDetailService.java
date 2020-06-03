package kr.ac.korea.kkumtree.store.service;

import kr.ac.korea.kkumtree.store.dto.StoreDetailDto;
import kr.ac.korea.kkumtree.store.infrastructure.BenefitRepository;
import kr.ac.korea.kkumtree.store.infrastructure.MenuRepository;
import kr.ac.korea.kkumtree.store.infrastructure.StoreRepository;
import kr.ac.korea.kkumtree.store.model.Benefit;
import kr.ac.korea.kkumtree.store.model.Menu;
import kr.ac.korea.kkumtree.store.model.Store;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindStoreDetailService {
    private final StoreRepository storeRepository;
    private final MenuRepository menuRepository;
    private final BenefitRepository benefitRepository;

    public FindStoreDetailService(StoreRepository storeRepository,
                                  MenuRepository menuRepository,
                                  BenefitRepository benefitRepository) {
        this.storeRepository = storeRepository;
        this.menuRepository = menuRepository;
        this.benefitRepository = benefitRepository;
    }

    public StoreDetailDto findById(Long id) {
        Store store = storeRepository.findById(id)
            .orElseThrow(StoreNotFoundException::new);

        List<Menu> menus = menuRepository.findAllByStore(store);
        List<Benefit> benefits = benefitRepository.findAllByStore(store);
        return StoreDetailDto.of(store, menus, benefits);
    }
}
