package kr.co.gongguiljeong.web.dto.schedule;

import kr.co.gongguiljeong.domain.brand.Brand;
import kr.co.gongguiljeong.domain.category.Category;
import kr.co.gongguiljeong.domain.influencer.Influencer;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ScheduleUpdateRequestDto {
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
    public ScheduleUpdateRequestDto(String scheduleRegisteredPerson,
                                    String scheduleCategory, String scheduleBrand, String scheduleInfluencer,
                                    Category category, Brand brand, Influencer influencer,
                                    String scheduleStartDate, String scheduleEndDate, String scheduleState) {
        this.scheduleRegisteredPerson = scheduleRegisteredPerson;
        //this.scheduleCategory = scheduleCategory;
        //this.scheduleBrand = scheduleBrand;
        //this.scheduleInfluencer = scheduleInfluencer;
        //this.scheduleCategory = String.valueOf(category.getCategoryCode());
        //this.scheduleBrand = String.valueOf(brand.getBrandCode());
        //this.scheduleInfluencer = String.valueOf(influencer.getInfluencerCode());
        this.category = category;
        this.brand = brand;
        this.influencer = influencer;
        this.scheduleStartDate = scheduleStartDate;
        this.scheduleEndDate = scheduleEndDate;
        this.scheduleState = scheduleState;
    }
}
