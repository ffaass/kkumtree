package kr.ac.korea.kkumtree.store.api;

import kr.ac.korea.kkumtree.store.infrastructure.StoreRepository;
import kr.ac.korea.kkumtree.store.model.Store;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stores")
@Profile("migration")
public class StoreMigrationController {
    private final WKTReader wktReader;
    private final StoreRepository storeRepository;

    public StoreMigrationController(StoreRepository storeRepository) {
        this.wktReader = new WKTReader();
        this.storeRepository = storeRepository;
    }

    @GetMapping
    public void test(@RequestParam("lat") String lat,
                     @RequestParam("lon") String lon) throws ParseException {
        Store store = Store.builder()
            .address("asd")
            .name("테스트" + lat)
            .storeCategory(null)
            .telNumber("010-0101-1010")
            .location((Point) wktReader.read(String.format(
                "POINT(%s %s)", lat, lon)
            ))
            .build();
        storeRepository.save(store);
    }
}
