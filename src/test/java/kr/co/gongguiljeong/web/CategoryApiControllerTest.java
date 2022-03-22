package kr.co.gongguiljeong.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.gongguiljeong.domain.category.Category;
import kr.co.gongguiljeong.domain.category.CategoryRepository;
import kr.co.gongguiljeong.domain.posts.Posts;
import kr.co.gongguiljeong.domain.posts.PostsRepository;
import kr.co.gongguiljeong.web.dto.PostsSaveRequestDto;
import kr.co.gongguiljeong.web.dto.PostsUpdateRequestDto;
import kr.co.gongguiljeong.web.dto.category.CategorySaveRequestDto;
import kr.co.gongguiljeong.web.dto.category.CategoryUpdateRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CategoryApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @AfterEach
    public void tearDown() throws Exception {
        categoryRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles="ADMIN")
    public void Category_등록된다() throws Exception {
        //given
        String categoryNameKr = "카테고리 한글명";
        String categoryNameEng = "카테고리 영문명";
        String categoryColor = "카테고리 색상";
        String categoryState = "카테고리 상태";

        CategorySaveRequestDto requestDto = CategorySaveRequestDto.builder()
                .categoryNameKr(categoryNameKr)
                .categoryNameEng(categoryNameEng)
                .categoryColor(categoryColor)
                .categoryState(categoryState)
                .build();

        String url = "http://localhost:" + port + "/api/admin/category";

        //when
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Category> all = categoryRepository.findAll();
        assertThat(all.get(0).getCategoryNameKr()).isEqualTo(categoryNameKr);
        assertThat(all.get(0).getCategoryNameEng()).isEqualTo(categoryNameEng);
        assertThat(all.get(0).getCategoryColor()).isEqualTo(categoryColor);
        assertThat(all.get(0).getCategoryState()).isEqualTo(categoryState);
    }

    @Test
    @WithMockUser(roles="ADMIN")
    public void Category_수정된다() throws Exception {
        //given
        String categoryNameKr = "카테고리 한글명";
        String categoryNameEng = "카테고리 영문명";
        String categoryColor = "카테고리 색상";
        String categoryState = "카테고리 상태";

        Category savedCategory = categoryRepository.save(Category.builder()
                .categoryNameKr(categoryNameKr)
                .categoryNameEng(categoryNameEng)
                .categoryColor(categoryColor)
                .categoryState(categoryState)
                .build());

        Long updateId = savedCategory.getCategoryCode();
        String expectedCategoryNameKr = "카테고리 한글명2";
        String expectedCategoryNameEng = "카테고리 영문명2";
        String expectedCategoryColor = "카테고리 색상2";
        String expectedCategoryState = "카테고리 상태2";

        CategoryUpdateRequestDto requestDto = CategoryUpdateRequestDto.builder()
                .categoryNameKr(expectedCategoryNameKr)
                .categoryNameEng(expectedCategoryNameEng)
                .categoryColor(expectedCategoryColor)
                .categoryState(expectedCategoryState)
                .build();

        String url = "http://localhost:" + port + "/api/admin/category/" + updateId;

        //when
        mvc.perform(put(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Category> all = categoryRepository.findAll();
        assertThat(all.get(0).getCategoryNameKr()).isEqualTo(expectedCategoryNameKr);
        assertThat(all.get(0).getCategoryNameEng()).isEqualTo(expectedCategoryNameEng);
        assertThat(all.get(0).getCategoryColor()).isEqualTo(expectedCategoryColor);
        assertThat(all.get(0).getCategoryState()).isEqualTo(expectedCategoryState);
    }
}