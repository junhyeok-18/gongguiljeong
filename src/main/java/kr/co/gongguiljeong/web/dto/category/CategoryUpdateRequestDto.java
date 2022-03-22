package kr.co.gongguiljeong.web.dto.category;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategoryUpdateRequestDto {
    private String categoryNameKr;
    private String categoryNameEng;
    private String categoryColor;
    private String categoryState;

    @Builder
    public CategoryUpdateRequestDto(String categoryNameKr, String categoryNameEng, String categoryColor, String categoryState) {
        this.categoryNameKr = categoryNameKr;
        this.categoryNameEng = categoryNameEng;
        this.categoryColor = categoryColor;
        this.categoryState = categoryState;
    }
}
