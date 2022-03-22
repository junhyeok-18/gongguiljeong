package kr.co.gongguiljeong.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.gongguiljeong.domain.influencer.Influencer;
import kr.co.gongguiljeong.domain.influencer.InfluencerRepository;
import kr.co.gongguiljeong.web.dto.influencer.InfluencerSaveRequestDto;
import kr.co.gongguiljeong.web.dto.influencer.InfluencerUpdateRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InfluencerApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private InfluencerRepository influencerRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @AfterEach
    public void tearDown() throws Exception {
        influencerRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles="ADMIN")
    public void influencer_등록된다() throws Exception {
        //given
        String influencerNameKr = "인플루언서 한글명";
        String influencerNameEng = "인플루언서 영문명";
        String influencerColor = "인플루언서 색상";
        String influencerIntroduction = "인플루언서 소개글";
        String influencerLink = "인플루언서 링크";
        String influencerState = "인플루언서 상태";

        InfluencerSaveRequestDto requestDto = InfluencerSaveRequestDto.builder()
                .influencerNameKr(influencerNameKr)
                .influencerNameEng(influencerNameEng)
                .influencerColor(influencerColor)
                .influencerIntroduction(influencerIntroduction)
                .influencerLink(influencerLink)
                .influencerState(influencerState)
                .build();

        String url = "http://localhost:" + port + "/api/admin/influencer";

        //when
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Influencer> all = influencerRepository.findAll();
        assertThat(all.get(0).getInfluencerNameKr()).isEqualTo(influencerNameKr);
        assertThat(all.get(0).getInfluencerNameEng()).isEqualTo(influencerNameEng);
        assertThat(all.get(0).getInfluencerColor()).isEqualTo(influencerColor);
        assertThat(all.get(0).getInfluencerIntroduction()).isEqualTo(influencerIntroduction);
        assertThat(all.get(0).getInfluencerLink()).isEqualTo(influencerLink);
        assertThat(all.get(0).getInfluencerState()).isEqualTo(influencerState);
    }

    @Test
    @WithMockUser(roles="ADMIN")
    public void influencer_수정된다() throws Exception {
        //given
        String influencerNameKr = "인플루언서 한글명";
        String influencerNameEng = "인플루언서 영문명";
        String influencerColor = "인플루언서 색상";
        String influencerIntroduction = "인플루언서 소개글";
        String influencerLink = "인플루언서 링크";
        String influencerState = "인플루언서 상태";

        Influencer savedInfluencer = influencerRepository.save(Influencer.builder()
                .influencerNameKr(influencerNameKr)
                .influencerNameEng(influencerNameEng)
                .influencerColor(influencerColor)
                .influencerIntroduction(influencerIntroduction)
                .influencerLink(influencerLink)
                .influencerState(influencerState)
                .build());

        Long updateId = savedInfluencer.getInfluencerCode();
        String expectedinfluencerNameKr = "인플루언서 한글명2";
        String expectedinfluencerNameEng = "인플루언서 영문명2";
        String expectedinfluencerColor = "인플루언서 색상2";
        String expectedinfluencerIntroduction = "인플루언서 소개글2";
        String expectedinfluencerLink = "인플루언서 링크2";
        String expectedinfluencerState = "인플루언서 상태2";

        InfluencerUpdateRequestDto requestDto = InfluencerUpdateRequestDto.builder()
                .influencerNameKr(expectedinfluencerNameKr)
                .influencerNameEng(expectedinfluencerNameEng)
                .influencerColor(expectedinfluencerColor)
                .influencerIntroduction(expectedinfluencerIntroduction)
                .influencerLink(expectedinfluencerLink)
                .influencerState(expectedinfluencerState)
                .build();

        String url = "http://localhost:" + port + "/api/admin/influencer/" + updateId;

        //when
        mvc.perform(put(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Influencer> all = influencerRepository.findAll();
        assertThat(all.get(0).getInfluencerNameKr()).isEqualTo(expectedinfluencerNameKr);
        assertThat(all.get(0).getInfluencerNameEng()).isEqualTo(expectedinfluencerNameEng);
        assertThat(all.get(0).getInfluencerColor()).isEqualTo(expectedinfluencerColor);
        assertThat(all.get(0).getInfluencerIntroduction()).isEqualTo(expectedinfluencerIntroduction);
        assertThat(all.get(0).getInfluencerLink()).isEqualTo(expectedinfluencerLink);
        assertThat(all.get(0).getInfluencerState()).isEqualTo(expectedinfluencerState);
    }
}