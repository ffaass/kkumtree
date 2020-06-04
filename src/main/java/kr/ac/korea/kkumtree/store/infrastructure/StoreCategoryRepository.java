package kr.ac.korea.kkumtree.store.infrastructure;

import kr.ac.korea.kkumtree.store.model.StoreCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreCategoryRepository extends JpaRepository<StoreCategory, Long> {
}
