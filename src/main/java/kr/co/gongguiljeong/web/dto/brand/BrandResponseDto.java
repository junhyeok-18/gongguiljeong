package kr.co.gongguiljeong.web.dto.brand;

;
import kr.co.gongguiljeong.domain.brand.Brand;
import lombok.Getter;

@Getter
public class BrandResponseDto {
    private Long brandCode;
    private String brandNameKr;
    private String brandNameEng;
    private String brandColor;
    private String brandIntroduction;
    private String brandLink;
    private String brandState;

    public BrandResponseDto(Brand entity) {
        this.brandCode = entity.getBrandCode();
        this.brandNameKr = entity.getBrandNameKr();
        this.brandNameEng = entity.getBrandNameEng();
        this.brandColor = entity.getBrandColor();
        this.brandIntroduction = entity.getBrandIntroduction();
        this.brandLink = entity.getBrandLink();
        this.brandState = entity.getBrandState();
    }
}
