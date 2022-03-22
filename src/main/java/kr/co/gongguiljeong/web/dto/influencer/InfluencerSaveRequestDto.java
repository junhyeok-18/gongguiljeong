package kr.co.gongguiljeong.web.dto.influencer;

import kr.co.gongguiljeong.domain.influencer.Influencer;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class InfluencerSaveRequestDto {
    private String influencerNameKr;
    private String influencerNameEng;
    private String influencerColor;
    private String influencerIntroduction;
    private String influencerLink;
    private String influencerState;

    @Builder
    public InfluencerSaveRequestDto(String influencerNameKr, String influencerNameEng, String influencerColor, String influencerIntroduction, String influencerLink, String influencerState) {
        this.influencerNameKr = influencerNameKr;
        this.influencerNameEng = influencerNameEng;
        this.influencerColor = influencerColor;
        this.influencerIntroduction = influencerIntroduction;
        this.influencerLink = influencerLink;
        this.influencerState = influencerState;
    }

    public Influencer toEntity() {
        return Influencer.builder()
                .influencerNameKr(influencerNameKr)
                .influencerNameEng(influencerNameEng)
                .influencerColor(influencerColor)
                .influencerIntroduction(influencerIntroduction)
                .influencerLink(influencerLink)
                .influencerState(influencerState)
                .build();
    }
}
