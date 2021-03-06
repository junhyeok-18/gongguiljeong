package kr.co.gongguiljeong.domain.category;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kr.co.gongguiljeong.domain.BaseTimeEntity;
import kr.co.gongguiljeong.domain.schedule.Schedule;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Category extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryCode;

    @Column(nullable = false)
    private String categoryNameKr;

    @Column(nullable = false)
    private String categoryNameEng;

    @Column(nullable = false)
    private String categoryColor;

    @Column(nullable = false)
    private String categoryState;

    @Builder
    public Category(String categoryNameKr, String categoryNameEng, String categoryColor, String categoryState) {
        this.categoryNameKr = categoryNameKr;
        this.categoryNameEng = categoryNameEng;
        this.categoryColor = categoryColor;
        this.categoryState = categoryState;
    }

    public void update(String categoryNameKr, String categoryNameEng, String categoryColor, String categoryState) {
        this.categoryNameKr = categoryNameKr;
        this.categoryNameEng = categoryNameEng;
        this.categoryColor = categoryColor;
        this.categoryState = categoryState;
    }
}
