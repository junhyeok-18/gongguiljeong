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
        String categoryNameKr = "카테고리 한글명";
        String categoryNameEng = "카테고리 영문명";
        String categoryColor = "카테고리 색상";
        String categoryState = "카테고리 상태";

        categoryRepository.save(Category.builder()
                .categoryNameKr(categoryNameKr)
                .categoryNameEng(categoryNameEng)
                .categoryColor(categoryColor)
                .categoryState(categoryState)
                .build());

        //when
        List<Category> categoryList = categoryRepository.findAll();

        //then
        Category category = categoryList.get(0);
        assertThat(category.getCategoryNameKr()).isEqualTo(categoryNameKr);
        assertThat(category.getCategoryNameEng()).isEqualTo(categoryNameEng);
        assertThat(category.getCategoryColor()).isEqualTo(categoryColor);
        assertThat(category.getCategoryState()).isEqualTo(categoryState);
    }
}
