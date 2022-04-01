package kr.co.gongguiljeong.domain.schedule;

import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScheduleListRepository extends JpaRepository<ScheduleList, Long> {
    /*@Query(value = "SELECT " +
            "gs.schedule_code as schedule_code, " +
            "gs.schedule_registered_person as schedule_registered_person, " +
            "gs.schedule_category as schedule_category, " +
            "gc.category_name_kr as category_name_kr, " +
            "gc.category_color as category_color, " +
            "gs.schedule_brand as schedule_brand, " +
            "gb.brand_name_kr as brand_name_kr, " +
            "gb.brand_color as brand_color, " +
            "gs.schedule_influencer as schedule_influencer, " +
            "gi.influencer_name_kr as influencer_name_kr, " +
            "gi.influencer_color as influencer_color, " +
            "gs.schedule_start_date as schedule_start_date, " +
            "gs.schedule_end_date as schedule_end_date, " +
            "gs.schedule_state as schedule_state, " +
            "gs.created_date as created_date, " +
            "gs.modified_date as modified_date " +
            "FROM schedule gs " +
            "join category gc on gs.schedule_category = gc.category_code " +
            "join brand gb on gs.schedule_brand = gb.brand_code " +
            "join influencer gi on gs.schedule_influencer = gi.influencer_code " +
            "where gs.schedule_state = 'Y' " +
            "ORDER BY gs.schedule_code", nativeQuery = true)*/
    @Query("SELECT s, c, b, i FROM ScheduleList s " +
            "JOIN FETCH s.category c " +
            "JOIN FETCH s.brand b " +
            "JOIN FETCH s.influencer i " +
            "ORDER BY s.scheduleStartDate")
    List<ScheduleList> scheduleList();

    @Query("SELECT s, c, b, i FROM ScheduleList s " +
            "JOIN FETCH s.category c " +
            "JOIN FETCH s.brand b " +
            "JOIN FETCH s.influencer i " +
            "where s.scheduleState = 'Y' " +
            "AND (SUBSTRING(s.scheduleStartDate, 1, 6) = :scheduleDate OR SUBSTRING(s.scheduleEndDate, 1, 6) = :scheduleDate) " +
            "ORDER BY s.scheduleStartDate")
    List<ScheduleList> mainSchedule(@Param("scheduleDate") String scheduleDate);
}
