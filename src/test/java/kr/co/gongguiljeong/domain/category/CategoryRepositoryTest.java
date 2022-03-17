package kr.co.gongguiljeong.domain.category;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @AfterEach
    public void cleanup() {
        categoryRepository.deleteAll();
    }

    @Test
    public void 카테고리저장_불러오기() {
        //given
        String category_name_kr = "카테고리 한글명";
        String category_name_eng = "카테고리 영문명";
        String category_color = "카테고리 색상";
        String category_state = "카테고리 상태";

        categoryRepository.save(Category.builder()
                .category_name_kr(category_name_kr)
                .category_name_eng(category_name_eng)
                .category_color(category_color)
                .category_state(category_state)
                .build());

        //when
        List<Category> categoryList = categoryRepository.findAll();

        //then
        Category category = categoryList.get(0);
        assertThat(category.getCategory_name_kr()).isEqualTo(category_name_kr);
        assertThat(category.getCategory_name_eng()).isEqualTo(category_name_eng);
        assertThat(category.getCategory_color()).isEqualTo(category_color);
        assertThat(category.getCategory_state()).isEqualTo(category_state);
    }
}
