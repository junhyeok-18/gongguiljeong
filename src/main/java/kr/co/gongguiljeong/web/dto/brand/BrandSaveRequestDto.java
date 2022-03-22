package kr.co.gongguiljeong.web.dto.brand;

import kr.co.gongguiljeong.domain.brand.Brand;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BrandSaveRequestDto {
    private String brandNameKr;
    private String brandNameEng;
    private String brandColor;
    private String brandIntroduction;
    private String brandLink;
    private String brandState;

    @Builder
    public BrandSaveRequestDto(String brandNameKr, String brandNameEng, String brandColor, String brandIntroduction, String brandLink, String brandState) {
        this.brandNameKr = brandNameKr;
        this.brandNameEng = brandNameEng;
        this.brandColor = brandColor;
        this.brandIntroduction = brandIntroduction;
        this.brandLink = brandLink;
        this.brandState = brandState;
    }

    public Brand toEntity() {
        return Brand.builder()
                .brandNameKr(brandNameKr)
                .brandNameEng(brandNameEng)
                .brandColor(brandColor)
                .brandIntroduction(brandIntroduction)
                .brandLink(brandLink)
                .brandState(brandState)
                .build();
    }
}
