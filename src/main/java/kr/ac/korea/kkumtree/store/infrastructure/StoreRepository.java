package kr.ac.korea.kkumtree.store.infrastructure;

import kr.ac.korea.kkumtree.store.model.Store;
import org.locationtech.jts.geom.Geometry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {

    @Query("select s from Store s where within(s.location, :geometry) = true")
    List<Store> findAllWithInGeometry(@Param("geometry") Geometry geometry);
}
