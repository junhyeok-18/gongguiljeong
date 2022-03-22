package kr.co.gongguiljeong.domain.brand;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BrandRepositoryTest {

    @Autowired
    BrandRepository brandRepository;

    @AfterEach
    public void cleanup() {
        brandRepository.deleteAll();
    }

    @Test
    public void 브랜드저장_불러오기() {
        //given
        String brandNameKr = "브랜드 한글명";
        String brandNameEng = "브랜드 영문명";
        String brandColor = "브랜드 색상";
        String brandIntroduction = "브랜드 소개글";
        String brandLink = "브랜드 링크";
        String brandState = "브랜드 상태";

        brandRepository.save(Brand.builder()
                .brandNameKr(brandNameKr)
                .brandNameEng(brandNameEng)
                .brandColor(brandColor)
                .brandIntroduction(brandIntroduction)
                .brandLink(brandLink)
                .brandState(brandState)
                .build());

        //when
        List<Brand> brandList = brandRepository.findAll();

        //then
        Brand brand = brandList.get(0);
        assertThat(brand.getBrandNameKr()).isEqualTo(brandNameKr);
        assertThat(brand.getBrandNameEng()).isEqualTo(brandNameEng);
        assertThat(brand.getBrandColor()).isEqualTo(brandColor);
        assertThat(brand.getBrandIntroduction()).isEqualTo(brandIntroduction);
        assertThat(brand.getBrandLink()).isEqualTo(brandLink);
        assertThat(brand.getBrandState()).isEqualTo(brandState);
    }
}
