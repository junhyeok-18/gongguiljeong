package kr.co.gongguiljeong.web.dto;

import kr.co.gongguiljeong.domain.category.Category;
import lombok.Getter;

@Getter
public class CategoryResponseDto {
    private Long categoryCode;
    private String categoryNameKr;
    private String categoryNameEng;
    private String categoryColor;
    private String categoryState;

    public CategoryResponseDto(Category entity) {
        this.categoryCode = entity.getCategoryCode();
        this.categoryNameKr = entity.getCategoryNameKr();
        this.categoryNameEng = entity.getCategoryNameEng();
        this.categoryColor = entity.getCategoryColor();
        this.categoryState = entity.getCategoryState();
    }
}
