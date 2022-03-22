package kr.co.gongguiljeong.domain.influencer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InfluencerRepository extends JpaRepository<Influencer, Long> {

    @Query(value = "SELECT " +
            "gi.influencer_code, gi.influencer_name_kr, gi.influencer_name_eng, gi.influencer_color, gi.influencer_introduction, gi.influencer_link, gi.influencer_state, " +
            "gi.created_date, gi.modified_date " +
            "FROM influencer gi " +
            "ORDER BY gi.influencer_code", nativeQuery = true)
    List<Influencer> findAll();
}
