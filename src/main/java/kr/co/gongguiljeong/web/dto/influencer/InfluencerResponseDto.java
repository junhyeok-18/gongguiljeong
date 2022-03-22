package kr.co.gongguiljeong.web.dto.influencer;

import kr.co.gongguiljeong.domain.influencer.Influencer;
import lombok.Getter;

@Getter
public class InfluencerResponseDto {
    private Long influencerCode;
    private String influencerNameKr;
    private String influencerNameEng;
    private String influencerColor;
    private String influencerIntroduction;
    private String influencerLink;
    private String influencerState;

    public InfluencerResponseDto(Influencer entity) {
        this.influencerCode = entity.getInfluencerCode();
        this.influencerNameKr = entity.getInfluencerNameKr();
        this.influencerNameEng = entity.getInfluencerNameEng();
        this.influencerColor = entity.getInfluencerColor();
        this.influencerIntroduction = entity.getInfluencerIntroduction();
        this.influencerLink = entity.getInfluencerLink();
        this.influencerState = entity.getInfluencerState();
    }
}
