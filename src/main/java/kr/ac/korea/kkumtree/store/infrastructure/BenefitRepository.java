package kr.ac.korea.kkumtree.store.infrastructure;

import kr.ac.korea.kkumtree.store.model.Benefit;
import kr.ac.korea.kkumtree.store.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BenefitRepository extends JpaRepository<Benefit, Long> {
    List<Benefit> findAllByStore(Store store);
}
