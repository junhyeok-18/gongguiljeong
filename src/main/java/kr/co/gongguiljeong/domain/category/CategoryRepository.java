package kr.co.gongguiljeong.domain.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT " +
            "gc.category_code, gc.category_name_kr, gc.category_name_eng, gc.category_color, gc.category_state, " +
            "gc.created_date, gc.modified_date " +
            "FROM category gc " +
            "ORDER BY gc.category_code", nativeQuery = true)
    List<Category> findAll();
}
