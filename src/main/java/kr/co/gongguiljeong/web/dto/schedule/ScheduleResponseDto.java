package kr.co.gongguiljeong.web.dto.schedule;

import kr.co.gongguiljeong.domain.schedule.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private Long scheduleCode;
    private String scheduleRegisteredPerson;
    private String scheduleCategory;
    private String scheduleBrand;
    private String scheduleInfluencer;
    private String scheduleStartDate;
    private String scheduleEndDate;
    private String scheduleState;

    public ScheduleResponseDto(Schedule entity) {
        this.scheduleCode = entity.getScheduleCode();
        this.scheduleRegisteredPerson = entity.getScheduleRegisteredPerson();
        this.scheduleCategory = entity.getScheduleCategory();
        this.scheduleBrand = entity.getScheduleBrand();
        this.scheduleInfluencer = entity.getScheduleInfluencer();
        this.scheduleStartDate = entity.getScheduleStartDate();
        this.scheduleEndDate = entity.getScheduleEndDate();
        this.scheduleState = entity.getScheduleState();
    }
}
