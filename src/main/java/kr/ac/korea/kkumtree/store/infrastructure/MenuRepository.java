package kr.ac.korea.kkumtree.store.infrastructure;

import kr.ac.korea.kkumtree.store.model.Menu;
import kr.ac.korea.kkumtree.store.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findAllByStore(Store store);
}
