package kr.co.gongguiljeong.domain.schedule;

import kr.co.gongguiljeong.domain.brand.Brand;
import kr.co.gongguiljeong.domain.brand.BrandRepository;
import kr.co.gongguiljeong.domain.category.Category;
import kr.co.gongguiljeong.domain.category.CategoryRepository;
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
public class ScheduleRepositoryTest {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    ScheduleListRepository scheduleListRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    InfluencerRepository influencerRepository;

    @AfterEach
    public void cleanup() {
        scheduleRepository.deleteAll();
        categoryRepository.deleteAll();
        brandRepository.deleteAll();
        influencerRepository.deleteAll();
    }

    @Test
    public void 스케줄저장_불러오기() {
        //given
        String categoryNameKr = "카테고리 한글명";
        String categoryNameEng = "카테고리 영문명";
        String categoryColor = "카테고리 색상";
        String categoryState = "카테고리 상태";

        categoryRepository.save(Category.builder()
                .categoryNameKr(categoryNameKr)
                .categoryNameEng(categoryNameEng)
                .categoryColor(categoryColor)
                .categoryState(categoryState)
                .build());

        String brandNameKr = "브랜드 한글명";
        String brandNameEng = "브랜드 영문명";
        String brandColor = "브랜드 색상";
        String brandIntroduction = "브랜드 소개글";
        String brandLink = "브랜드 링크";
        String brandState = "브랜드 상태";

        brandRepository.save(Brand.builder()
                .brandNameKr(brandNameKr)
                .brandNameEng(brandNameEng)
                .brandColor(brandColor)
                .brandIntroduction(brandIntroduction)
                .brandLink(brandLink)
                .brandState(brandState)
                .build());

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

        String scheduleRegisteredPerson = "공구일정 등록한 사람";
        String scheduleCategory = "공구일정 카테고리";
        String scheduleBrand = "공구일정 브랜드";
        String scheduleInfluencer = "공구일정 인플루언서";
        String scheduleStartDate = "공구일정 시작일";
        String scheduleEndDate = "공구일정 종료일";
        String scheduleState = "공구일정 상태";

        scheduleRepository.save(Schedule.builder()
                .scheduleRegisteredPerson(scheduleRegisteredPerson)
                .scheduleCategory(scheduleCategory)
                .scheduleBrand(scheduleBrand)
                .scheduleInfluencer(scheduleInfluencer)
                .scheduleStartDate(scheduleStartDate)
                .scheduleEndDate(scheduleEndDate)
                .scheduleState(scheduleState)
                .build());

        //when
        List<Schedule> scheduleList = scheduleListRepository.scheduleList();

        //then
        Schedule schedule = scheduleList.get(0);
        assertThat(schedule.getScheduleRegisteredPerson()).isEqualTo(scheduleRegisteredPerson);
        assertThat(schedule.getScheduleCategory()).isEqualTo(scheduleCategory);
        assertThat(schedule.getScheduleBrand()).isEqualTo(scheduleBrand);
        assertThat(schedule.getScheduleInfluencer()).isEqualTo(scheduleInfluencer);
        assertThat(schedule.getScheduleStartDate()).isEqualTo(scheduleStartDate);
        assertThat(schedule.getScheduleEndDate()).isEqualTo(scheduleEndDate);
        assertThat(schedule.getScheduleState()).isEqualTo(scheduleState);
    }
}
