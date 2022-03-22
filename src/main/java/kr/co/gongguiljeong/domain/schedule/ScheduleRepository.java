package kr.co.gongguiljeong.domain.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query(value = "SELECT " +
            "gs.schedule_code, gs.schedule_registered_person, " +
            "gs.schedule_category, gs.schedule_brand, gs.schedule_influencer, " +
            "gs.schedule_start_date, gs.schedule_end_date, gs.schedule_state, " +
            "gs.created_date, gs.modified_date " +
            "FROM schedule gs " +
            "ORDER BY gs.schedule_code", nativeQuery = true)
    List<Schedule> findAll();
}
