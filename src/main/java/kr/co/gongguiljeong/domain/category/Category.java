package kr.co.gongguiljeong.domain.category;

import kr.co.gongguiljeong.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Category extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_code;

    private String category_name_kr;

    private String category_name_eng;

    private String category_color;

    private String category_state;

    @Builder
    public Category(String category_name_kr, String category_name_eng, String category_color, String category_state) {
        this.category_name_kr = category_name_kr;
        this.category_name_eng = category_name_eng;
        this.category_color = category_color;
        this.category_state = category_state;
    }

    public void update(String category_name_kr, String category_name_eng, String category_color, String category_state) {
        this.category_name_kr = category_name_kr;
        this.category_name_eng = category_name_eng;
        this.category_color = category_color;
        this.category_state = category_state;
    }
}
