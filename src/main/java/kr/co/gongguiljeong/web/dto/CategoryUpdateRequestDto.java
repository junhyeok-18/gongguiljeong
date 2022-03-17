package kr.co.gongguiljeong.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategoryUpdateRequestDto {
    private String category_name_kr;
    private String category_name_eng;
    private String category_color;
    private String category_state;

    @Builder
    public CategoryUpdateRequestDto(String category_name_kr, String category_name_eng, String category_color, String category_state) {
        this.category_name_kr = category_name_kr;
        this.category_name_eng = category_name_eng;
        this.category_color = category_color;
        this.category_state = category_state;
    }
}
