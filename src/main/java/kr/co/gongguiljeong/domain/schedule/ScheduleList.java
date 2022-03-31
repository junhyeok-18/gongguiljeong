package kr.co.gongguiljeong.domain.schedule;

import kr.co.gongguiljeong.domain.BaseTimeEntity;
import kr.co.gongguiljeong.domain.brand.Brand;
import kr.co.gongguiljeong.domain.category.Category;
import kr.co.gongguiljeong.domain.influencer.Influencer;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "schedule")
public class ScheduleList extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleCode;

    @Column(nullable = false)
    private String scheduleRegisteredPerson;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "scheduleCategory")
    private Category category;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "scheduleBrand")
    private Brand brand;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "scheduleInfluencer")
    private Influencer influencer;

/*    @Column(nullable = false)
    private String scheduleCategory;

    @Column(nullable = false)
    private String scheduleBrand;

    @Column(nullable = false)
    private String scheduleInfluencer;*/

    @Column(nullable = false)
    private String scheduleStartDate;

    @Column(nullable = false)
    private String scheduleEndDate;

    @Column(nullable = false)
    private String scheduleState;

    @Builder
    public ScheduleList(String scheduleRegisteredPerson,
                    //String scheduleCategory, String scheduleBrand, String scheduleInfluencer,
                    Category category, Brand brand, Influencer influencer,
                    String scheduleStartDate, String scheduleEndDate, String scheduleState) {
        this.scheduleRegisteredPerson = scheduleRegisteredPerson;
        //this.scheduleCategory = scheduleCategory;
        //this.scheduleBrand = scheduleBrand;
        //this.scheduleInfluencer = scheduleInfluencer;
        this.category = category;
        this.brand = brand;
        this.influencer = influencer;
        this.scheduleStartDate = scheduleStartDate;
        this.scheduleEndDate = scheduleEndDate;
        this.scheduleState = scheduleState;
    }

    public void update(String scheduleRegisteredPerson,
                       //String scheduleCategory, String scheduleBrand, String scheduleInfluencer,
                       Category category, Brand brand, Influencer influencer,
                       String scheduleStartDate, String scheduleEndDate, String scheduleState) {
        this.scheduleRegisteredPerson = scheduleRegisteredPerson;
        //this.scheduleCategory = scheduleCategory;
        //this.scheduleBrand = scheduleBrand;
        //this.scheduleInfluencer = scheduleInfluencer;
        this.category = category;
        this.brand = brand;
        this.influencer = influencer;
        //this.category = scheduleCategory;
        //this.brand = brand;
        //this.influencer = influencer;
        this.scheduleStartDate = scheduleStartDate;
        this.scheduleEndDate = scheduleEndDate;
        this.scheduleState = scheduleState;
    }
}
