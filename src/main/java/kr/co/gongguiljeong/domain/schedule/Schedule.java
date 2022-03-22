package kr.co.gongguiljeong.domain.schedule;

import kr.co.gongguiljeong.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Schedule extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleCode;

    @Column(nullable = false)
    private String scheduleRegisteredPerson;

    @Column(nullable = false)
    private String scheduleCategory;

    @Column(nullable = false)
    private String scheduleBrand;

    @Column(nullable = false)
    private String scheduleInfluencer;

    @Column(nullable = false)
    private String scheduleStartDate;

    @Column(nullable = false)
    private String scheduleEndDate;

    @Column(nullable = false)
    private String scheduleState;

    @Builder
    public Schedule(String scheduleRegisteredPerson, String scheduleCategory, String scheduleBrand, String scheduleInfluencer, String scheduleStartDate, String scheduleEndDate, String scheduleState) {
        this.scheduleRegisteredPerson = scheduleRegisteredPerson;
        this.scheduleCategory = scheduleCategory;
        this.scheduleBrand = scheduleBrand;
        this.scheduleInfluencer = scheduleInfluencer;
        this.scheduleStartDate = scheduleStartDate;
        this.scheduleEndDate = scheduleEndDate;
        this.scheduleState = scheduleState;
    }

    public void update(String scheduleRegisteredPerson, String scheduleCategory, String scheduleBrand, String scheduleInfluencer, String scheduleStartDate, String scheduleEndDate, String scheduleState) {
        this.scheduleRegisteredPerson = scheduleRegisteredPerson;
        this.scheduleCategory = scheduleCategory;
        this.scheduleBrand = scheduleBrand;
        this.scheduleInfluencer = scheduleInfluencer;
        this.scheduleStartDate = scheduleStartDate;
        this.scheduleEndDate = scheduleEndDate;
        this.scheduleState = scheduleState;
    }
}
