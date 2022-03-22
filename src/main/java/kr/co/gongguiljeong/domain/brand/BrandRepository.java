package kr.co.gongguiljeong.domain.brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    @Query(value = "SELECT " +
            "gb.brand_code, gb.brand_name_kr, gb.brand_name_eng, gb.brand_color, gb.brand_introduction, gb.brand_link, gb.brand_state, " +
            "gb.created_date, gb.modified_date " +
            "FROM brand gb " +
            "ORDER BY gb.brand_code", nativeQuery = true)
    List<Brand> findAll();
}
