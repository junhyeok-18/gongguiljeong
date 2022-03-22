package kr.co.gongguiljeong.web.dto.schedule;

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
    private String scheduleStartDate;
    private String scheduleEndDate;
    private String scheduleState;

    @Builder
    public ScheduleUpdateRequestDto(String scheduleRegisteredPerson, String scheduleCategory, String scheduleBrand, String scheduleInfluencer,
                                    String scheduleStartDate, String scheduleEndDate, String scheduleState) {
        this.scheduleRegisteredPerson = scheduleRegisteredPerson;
        this.scheduleCategory = scheduleCategory;
        this.scheduleBrand = scheduleBrand;
        this.scheduleInfluencer = scheduleInfluencer;
        this.scheduleStartDate = scheduleStartDate;
        this.scheduleEndDate = scheduleEndDate;
        this.scheduleState = scheduleState;
    }
}
