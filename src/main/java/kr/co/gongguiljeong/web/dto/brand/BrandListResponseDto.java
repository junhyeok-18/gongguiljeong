package kr.co.gongguiljeong.web.dto.brand;

import kr.co.gongguiljeong.domain.brand.Brand;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BrandListResponseDto {
    private Long brandCode;
    private String brandNameKr;
    private String brandNameEng;
    private String brandColor;
    private String brandIntroduction;
    private String brandLink;
    private String brandState;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public BrandListResponseDto(Brand entity) {
        this.brandCode = entity.getBrandCode();
        this.brandNameKr = entity.getBrandNameKr();
        this.brandNameEng = entity.getBrandNameEng();
        this.brandColor = entity.getBrandColor();
        this.brandIntroduction = entity.getBrandIntroduction();
        this.brandLink = entity.getBrandLink();
        this.brandState = entity.getBrandState();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
    }
}
