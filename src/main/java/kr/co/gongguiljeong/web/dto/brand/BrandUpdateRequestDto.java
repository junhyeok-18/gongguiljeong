package kr.co.gongguiljeong.web.dto.brand;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BrandUpdateRequestDto {
    private String brandNameKr;
    private String brandNameEng;
    private String brandColor;
    private String brandIntroduction;
    private String brandLink;
    private String brandState;

    @Builder
    public BrandUpdateRequestDto(String brandNameKr, String brandNameEng, String brandColor, String brandIntroduction, String brandLink, String brandState) {
        this.brandNameKr = brandNameKr;
        this.brandNameEng = brandNameEng;
        this.brandColor = brandColor;
        this.brandIntroduction = brandIntroduction;
        this.brandLink = brandLink;
        this.brandState = brandState;
    }
}
