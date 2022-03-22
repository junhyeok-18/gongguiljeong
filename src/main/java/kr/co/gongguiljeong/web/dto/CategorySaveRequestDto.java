package kr.co.gongguiljeong.web.dto;

import kr.co.gongguiljeong.domain.category.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategorySaveRequestDto {
    private String categoryNameKr;
    private String categoryNameEng;
    private String categoryColor;
    private String categoryState;

    @Builder
    public CategorySaveRequestDto(String categoryNameKr, String categoryNameEng, String categoryColor, String categoryState) {
        this.categoryNameKr = categoryNameKr;
        this.categoryNameEng = categoryNameEng;
        this.categoryColor = categoryColor;
        this.categoryState = categoryState;
    }

    public Category toEntity() {
        return Category.builder()
                .categoryNameKr(categoryNameKr)
                .categoryNameEng(categoryNameEng)
                .categoryColor(categoryColor)
                .categoryState(categoryState)
                .build();
    }
}
