package kr.co.gongguiljeong.web.dto.influencer;

import kr.co.gongguiljeong.domain.influencer.Influencer;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class InfluencerListResponseDto {
    private Long influencerCode;
    private String influencerNameKr;
    private String influencerNameEng;
    private String influencerColor;
    private String influencerIntroduction;
    private String influencerLink;
    private String influencerState;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public InfluencerListResponseDto(Influencer entity) {
        this.influencerCode = entity.getInfluencerCode();
        this.influencerNameKr = entity.getInfluencerNameKr();
        this.influencerNameEng = entity.getInfluencerNameEng();
        this.influencerColor = entity.getInfluencerColor();
        this.influencerIntroduction = entity.getInfluencerIntroduction();
        this.influencerLink = entity.getInfluencerLink();
        this.influencerState = entity.getInfluencerState();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
    }
}
