package kr.ac.korea.kkumtree.store.service;

import kr.ac.korea.kkumtree.store.dto.Location;
import kr.ac.korea.kkumtree.store.dto.StoreDetailDto;
import kr.ac.korea.kkumtree.store.dto.StoreDto;
import kr.ac.korea.kkumtree.store.infrastructure.StoreRepository;
import kr.ac.korea.kkumtree.store.model.Store;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.util.GeometricShapeFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class FindStoreService {
    private static final double EQUATORIAL_RADIUS = 6378137.0;

    private final StoreRepository storeRepository;

    public FindStoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<StoreDto> findNearbyStores(Location location, int diameter) {
        Geometry circle = createCircle(
            Double.parseDouble(location.getLatitude()),
            Double.parseDouble(location.getLongitude()),
            calculateRadius(diameter));
        List<Store> storesWithInCircle = storeRepository.findAllWithInGeometry(circle);
        return storesWithInCircle.stream()
            .map(StoreDto::of)
            .collect(toList());
    }

    private Geometry createCircle(double x, double y, double radius) {
        GeometricShapeFactory shapeFactory = new GeometricShapeFactory();
        shapeFactory.setNumPoints(32);
        shapeFactory.setCentre(new Coordinate(x, y));
        shapeFactory.setSize(radius * 2);
        return shapeFactory.createCircle();
    }


    private static double calculateRadius(int meters) {
        return (meters * 360) / (2 * Math.PI * EQUATORIAL_RADIUS);
    }

}
