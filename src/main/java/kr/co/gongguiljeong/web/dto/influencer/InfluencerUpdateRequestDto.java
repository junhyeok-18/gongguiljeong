package kr.co.gongguiljeong.web.dto.influencer;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class InfluencerUpdateRequestDto {
    private String influencerNameKr;
    private String influencerNameEng;
    private String influencerColor;
    private String influencerIntroduction;
    private String influencerLink;
    private String influencerState;

    @Builder
    public InfluencerUpdateRequestDto(String influencerNameKr, String influencerNameEng, String influencerColor, String influencerIntroduction, String influencerLink, String influencerState) {
        this.influencerNameKr = influencerNameKr;
        this.influencerNameEng = influencerNameEng;
        this.influencerColor = influencerColor;
        this.influencerIntroduction = influencerIntroduction;
        this.influencerLink = influencerLink;
        this.influencerState = influencerState;
    }
}
