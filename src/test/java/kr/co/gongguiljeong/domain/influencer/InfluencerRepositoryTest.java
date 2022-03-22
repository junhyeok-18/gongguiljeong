package kr.co.gongguiljeong.domain.influencer;

import kr.co.gongguiljeong.domain.influencer.Influencer;
import kr.co.gongguiljeong.domain.influencer.InfluencerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class InfluencerRepositoryTest {

    @Autowired
    InfluencerRepository influencerRepository;

    @AfterEach
    public void cleanup() {
        influencerRepository.deleteAll();
    }

    @Test
    public void 인플루언서저장_불러오기() {
        //given
        String influencerNameKr = "인플루언서 한글명";
        String influencerNameEng = "인플루언서 영문명";
        String influencerColor = "인플루언서 색상";
        String influencerIntroduction = "인플루언서 소개글";
        String influencerLink = "인플루언서 링크";
        String influencerState = "인플루언서 상태";

        influencerRepository.save(Influencer.builder()
                .influencerNameKr(influencerNameKr)
                .influencerNameEng(influencerNameEng)
                .influencerColor(influencerColor)
                .influencerIntroduction(influencerIntroduction)
                .influencerLink(influencerLink)
                .influencerState(influencerState)
                .build());

        //when
        List<Influencer> influencerList = influencerRepository.findAll();

        //then
        Influencer influencer = influencerList.get(0);
        assertThat(influencer.getInfluencerNameKr()).isEqualTo(influencerNameKr);
        assertThat(influencer.getInfluencerNameEng()).isEqualTo(influencerNameEng);
        assertThat(influencer.getInfluencerColor()).isEqualTo(influencerColor);
        assertThat(influencer.getInfluencerIntroduction()).isEqualTo(influencerIntroduction);
        assertThat(influencer.getInfluencerLink()).isEqualTo(influencerLink);
        assertThat(influencer.getInfluencerState()).isEqualTo(influencerState);
    }
}
