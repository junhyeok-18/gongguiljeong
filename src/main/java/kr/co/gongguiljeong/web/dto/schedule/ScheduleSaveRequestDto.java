package kr.co.gongguiljeong.web.dto.schedule;

import kr.co.gongguiljeong.domain.brand.Brand;
import kr.co.gongguiljeong.domain.category.Category;
import kr.co.gongguiljeong.domain.influencer.Influencer;
import kr.co.gongguiljeong.domain.schedule.Schedule;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ScheduleSaveRequestDto {
    private String scheduleRegisteredPerson;
    private String scheduleCategory;
    private String scheduleBrand;
    private String scheduleInfluencer;
    private Category category;
    private Brand brand;
    private Influencer influencer;
    private String scheduleStartDate;
    private String scheduleEndDate;
    private String scheduleState;

    @Builder
    public ScheduleSaveRequestDto(String scheduleRegisteredPerson,
                                  String scheduleCategory, String scheduleBrand, String scheduleInfluencer,
                                  //Category category, Brand brand, Influencer influencer,
                                  String scheduleStartDate, String scheduleEndDate, String scheduleState) {
        this.scheduleRegisteredPerson = scheduleRegisteredPerson;
        this.scheduleCategory = scheduleCategory;
        this.scheduleBrand = scheduleBrand;
        this.scheduleInfluencer = scheduleInfluencer;
        //this.scheduleCategory = String.valueOf(category.getCategoryCode());
        //this.scheduleBrand = String.valueOf(brand.getBrandCode());
        //this.scheduleInfluencer = String.valueOf(influencer.getInfluencerCode());
        //this.category = category;
        //this.brand = brand;
        //this.influencer = influencer;
        this.scheduleStartDate = scheduleStartDate;
        this.scheduleEndDate = scheduleEndDate;
        this.scheduleState = scheduleState;

        System.out.println("scheduleCategory 얘가 정상작동을 해서 위 변수에 값을 넣었따 결국 json 값을 받았다는거임: " + scheduleCategory);
        System.out.println("scheduleBrand : " + scheduleBrand);
        System.out.println("scheduleInfluencer : " + scheduleInfluencer);
    }

    public Schedule toEntity() {
        System.out.println("entity scheduleCategory : " + scheduleCategory);
        System.out.println("entity scheduleBrand : " + scheduleBrand);
        System.out.println("entity scheduleInfluencer : " + scheduleInfluencer);

        return Schedule.builder()
                .scheduleRegisteredPerson(scheduleRegisteredPerson)
                .scheduleCategory(scheduleCategory)
                .scheduleBrand(scheduleBrand)
                .scheduleInfluencer(scheduleInfluencer)
                .scheduleStartDate(scheduleStartDate)
                .scheduleEndDate(scheduleEndDate)
                .scheduleState(scheduleState)
                .build();
    }

    public void setCategoryCode(Category category) {
        this.category = category;
    }

    public void setBrandCode(Brand brand) {
        this.brand = brand;
    }

    public void setInfluencerCode(Influencer influencer) {
        this.influencer = influencer;
    }
}
