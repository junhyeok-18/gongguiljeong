package kr.co.gongguiljeong.domain.brand;

import kr.co.gongguiljeong.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Brand extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandCode;

    @Column(nullable = false)
    private String brandNameKr;

    @Column(nullable = false)
    private String brandNameEng;

    @Column(nullable = false)
    private String brandColor;

    @Column(nullable = false)
    private String brandIntroduction;

    @Column(nullable = false)
    private String brandLink;

    @Column(nullable = false)
    private String brandState;

    @Builder
    public Brand(String brandNameKr, String brandNameEng, String brandColor, String brandIntroduction, String brandLink, String brandState) {
        this.brandNameKr = brandNameKr;
        this.brandNameEng = brandNameEng;
        this.brandColor = brandColor;
        this.brandIntroduction = brandIntroduction;
        this.brandLink = brandLink;
        this.brandState = brandState;
    }

    public void update(String brandNameKr, String brandNameEng, String brandColor, String brandIntroduction, String brandLink, String brandState) {
        this.brandNameKr = brandNameKr;
        this.brandNameEng = brandNameEng;
        this.brandColor = brandColor;
        this.brandIntroduction = brandIntroduction;
        this.brandLink = brandLink;
        this.brandState = brandState;
    }
}
