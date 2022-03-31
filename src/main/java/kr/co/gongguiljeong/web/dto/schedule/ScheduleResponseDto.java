package kr.co.gongguiljeong.web.dto.schedule;

import kr.co.gongguiljeong.domain.schedule.Schedule;
import kr.co.gongguiljeong.domain.schedule.ScheduleList;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private Long scheduleCode;
    private String scheduleRegisteredPerson;
    private String scheduleCategory;
    private String categoryNameKr;
    private String categoryColor;
    private String scheduleBrand;
    private String brandNameKr;
    private String brandColor;
    private String scheduleInfluencer;
    private String influencerNameKr;
    private String influencerColor;
    private String scheduleStartDate;
    private String scheduleEndDate;
    private String scheduleState;

    public ScheduleResponseDto(Schedule entity) {
        this.scheduleCode = entity.getScheduleCode();
        this.scheduleRegisteredPerson = entity.getScheduleRegisteredPerson();
        this.scheduleCategory = entity.getScheduleCategory();
        this.scheduleBrand = entity.getScheduleBrand();
        this.scheduleInfluencer = entity.getScheduleInfluencer();
        //this.scheduleCategory = String.valueOf(entity.getCategory().getCategoryCode());
        //this.categoryNameKr = entity.getCategory().getCategoryNameKr();
        //this.categoryColor = entity.getCategory().getCategoryColor();
        //this.scheduleBrand = String.valueOf(entity.getBrand().getBrandCode());
        //this.brandNameKr = entity.getBrand().getBrandNameKr();
        //this.brandColor = entity.getBrand().getBrandColor();
        //this.scheduleInfluencer = String.valueOf(entity.getInfluencer().getInfluencerCode());
        //this.influencerNameKr = entity.getInfluencer().getInfluencerNameKr();
        //this.influencerColor = entity.getInfluencer().getInfluencerColor();
        this.scheduleStartDate = entity.getScheduleStartDate();
        this.scheduleEndDate = entity.getScheduleEndDate();
        this.scheduleState = entity.getScheduleState();
    }
}
