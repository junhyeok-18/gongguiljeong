package kr.co.gongguiljeong.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.gongguiljeong.domain.influencer.Influencer;
import kr.co.gongguiljeong.domain.influencer.InfluencerRepository;
import kr.co.gongguiljeong.domain.schedule.Schedule;
import kr.co.gongguiljeong.domain.schedule.ScheduleList;
import kr.co.gongguiljeong.domain.schedule.ScheduleListRepository;
import kr.co.gongguiljeong.domain.schedule.ScheduleRepository;
import kr.co.gongguiljeong.web.dto.influencer.InfluencerSaveRequestDto;
import kr.co.gongguiljeong.web.dto.influencer.InfluencerUpdateRequestDto;
import kr.co.gongguiljeong.web.dto.schedule.ScheduleSaveRequestDto;
import kr.co.gongguiljeong.web.dto.schedule.ScheduleUpdateRequestDto;
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
public class ScheduleApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ScheduleListRepository scheduleListRepository;

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
        scheduleRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles="ADMIN")
    public void schedule_????????????() throws Exception {
        //given
        String scheduleRegisteredPerson = "???????????? ????????? ??????";
        String scheduleCategory = "???????????? ????????????";
        String scheduleBrand = "???????????? ?????????";
        String scheduleInfluencer = "???????????? ???????????????";
        String scheduleStartDate = "???????????? ?????????";
        String scheduleEndDate = "???????????? ?????????";
        String scheduleState = "???????????? ??????";

        ScheduleSaveRequestDto requestDto = ScheduleSaveRequestDto.builder()
                .scheduleRegisteredPerson(scheduleRegisteredPerson)
                .scheduleCategory(scheduleCategory)
                .scheduleBrand(scheduleBrand)
                .scheduleInfluencer(scheduleInfluencer)
                .scheduleStartDate(scheduleStartDate)
                .scheduleEndDate(scheduleEndDate)
                .scheduleState(scheduleState)
                .build();

        String url = "http://localhost:" + port + "/api/admin/schedule";

        //when
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<ScheduleList> all = scheduleListRepository.findAll();
        assertThat(all.get(0).getScheduleRegisteredPerson()).isEqualTo(scheduleRegisteredPerson);
        assertThat(all.get(0).getCategory().getCategoryCode()).isEqualTo(scheduleCategory);
        assertThat(all.get(0).getBrand().getBrandCode()).isEqualTo(scheduleBrand);
        assertThat(all.get(0).getInfluencer().getInfluencerCode()).isEqualTo(scheduleInfluencer);
        assertThat(all.get(0).getScheduleStartDate()).isEqualTo(scheduleStartDate);
        assertThat(all.get(0).getScheduleEndDate()).isEqualTo(scheduleEndDate);
        assertThat(all.get(0).getScheduleState()).isEqualTo(scheduleState);
    }

    @Test
    @WithMockUser(roles="ADMIN")
    public void schedule_????????????() throws Exception {
        //given
        String scheduleRegisteredPerson = "???????????? ????????? ??????";
        String scheduleCategory = "???????????? ????????????";
        String scheduleBrand = "???????????? ?????????";
        String scheduleInfluencer = "???????????? ???????????????";
        String scheduleStartDate = "???????????? ?????????";
        String scheduleEndDate = "???????????? ?????????";
        String scheduleState = "???????????? ??????";

        Schedule savedSchedule = scheduleRepository.save(Schedule.builder()
                .scheduleRegisteredPerson(scheduleRegisteredPerson)
                .scheduleCategory(scheduleCategory)
                .scheduleBrand(scheduleBrand)
                .scheduleInfluencer(scheduleInfluencer)
                .scheduleStartDate(scheduleStartDate)
                .scheduleEndDate(scheduleEndDate)
                .scheduleState(scheduleState)
                .build());

        Long updateId = savedSchedule.getScheduleCode();
        String expectedscheduleRegisteredPerson = "???????????? ????????? ??????2";
        String expectedscheduleCategory = "???????????? ????????????2";
        String expectedscheduleBrand = "???????????? ?????????2";
        String expectedscheduleInfluencer = "???????????? ???????????????2";
        String expectedscheduleStartDate = "???????????? ?????????2";
        String expectedscheduleEndDate = "???????????? ?????????2";
        String expectedscheduleState = "???????????? ??????2";

        ScheduleUpdateRequestDto requestDto = ScheduleUpdateRequestDto.builder()
                .scheduleRegisteredPerson(expectedscheduleRegisteredPerson)
                .scheduleCategory(expectedscheduleCategory)
                .scheduleBrand(expectedscheduleBrand)
                .scheduleInfluencer(expectedscheduleInfluencer)
                .scheduleStartDate(expectedscheduleStartDate)
                .scheduleEndDate(expectedscheduleEndDate)
                .scheduleState(expectedscheduleState)
                .build();

        String url = "http://localhost:" + port + "/api/admin/schedule/" + updateId;

        //when
        mvc.perform(put(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<ScheduleList> all = scheduleListRepository.findAll();
        assertThat(all.get(0).getScheduleRegisteredPerson()).isEqualTo(expectedscheduleRegisteredPerson);
        assertThat(all.get(0).getCategory().getCategoryCode()).isEqualTo(expectedscheduleCategory);
        assertThat(all.get(0).getBrand().getBrandCode()).isEqualTo(expectedscheduleBrand);
        assertThat(all.get(0).getInfluencer().getInfluencerCode()).isEqualTo(expectedscheduleInfluencer);
        assertThat(all.get(0).getScheduleStartDate()).isEqualTo(expectedscheduleStartDate);
        assertThat(all.get(0).getScheduleEndDate()).isEqualTo(expectedscheduleEndDate);
        assertThat(all.get(0).getScheduleState()).isEqualTo(expectedscheduleState);
    }
}