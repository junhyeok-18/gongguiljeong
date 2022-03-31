package kr.co.gongguiljeong.domain.influencer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kr.co.gongguiljeong.domain.BaseTimeEntity;
import kr.co.gongguiljeong.domain.schedule.Schedule;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Influencer extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long influencerCode;

    @Column(nullable = false)
    private String influencerNameKr;

    @Column(nullable = false)
    private String influencerNameEng;

    @Column(nullable = false)
    private String influencerColor;

    @Column(nullable = false)
    private String influencerIntroduction;

    @Column(nullable = false)
    private String influencerLink;

    @Column(nullable = false)
    private String influencerState;

    @Builder
    public Influencer(String influencerNameKr, String influencerNameEng, String influencerColor, String influencerIntroduction, String influencerLink, String influencerState) {
        this.influencerNameKr = influencerNameKr;
        this.influencerNameEng = influencerNameEng;
        this.influencerColor = influencerColor;
        this.influencerIntroduction = influencerIntroduction;
        this.influencerLink = influencerLink;
        this.influencerState = influencerState;
    }

    public void update(String influencerNameKr, String influencerNameEng, String influencerColor, String influencerIntroduction, String influencerLink, String influencerState) {
        this.influencerNameKr = influencerNameKr;
        this.influencerNameEng = influencerNameEng;
        this.influencerColor = influencerColor;
        this.influencerIntroduction = influencerIntroduction;
        this.influencerLink = influencerLink;
        this.influencerState = influencerState;
    }
}
