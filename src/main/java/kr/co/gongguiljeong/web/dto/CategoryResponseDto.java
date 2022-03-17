package kr.co.gongguiljeong.web.dto;

import kr.co.gongguiljeong.domain.category.Category;
import lombok.Getter;

@Getter
public class CategoryResponseDto {
    private Long category_code;
    private String category_name_kr;
    private String category_name_eng;
    private String category_color;
    private String category_state;

    public CategoryResponseDto(Category entity) {
        this.category_code = entity.getCategory_code();
        this.category_name_kr = entity.getCategory_name_kr();
        this.category_name_eng = entity.getCategory_name_eng();
        this.category_color = entity.getCategory_color();
        this.category_state = entity.getCategory_state();
    }
}
