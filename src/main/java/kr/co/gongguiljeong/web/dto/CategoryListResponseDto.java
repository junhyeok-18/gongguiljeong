package kr.co.gongguiljeong.web.dto;

import kr.co.gongguiljeong.domain.category.Category;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CategoryListResponseDto {
    private Long categoryCode;
    private String categoryNameKr;
    private String categoryNameEng;
    private String categoryColor;
    private String categoryState;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public CategoryListResponseDto(Category entity) {
        this.categoryCode = entity.getCategoryCode();
        this.categoryNameKr = entity.getCategoryNameKr();
        this.categoryNameEng = entity.getCategoryNameEng();
        this.categoryColor = entity.getCategoryColor();
        this.categoryState = entity.getCategoryState();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
    }
}
