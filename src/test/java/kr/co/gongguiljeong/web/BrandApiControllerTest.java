package kr.co.gongguiljeong.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.gongguiljeong.domain.brand.Brand;
import kr.co.gongguiljeong.domain.brand.BrandRepository;
import kr.co.gongguiljeong.web.dto.brand.BrandSaveRequestDto;
import kr.co.gongguiljeong.web.dto.brand.BrandUpdateRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BrandApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @AfterEach
    public void tearDown() throws Exception {
        brandRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles="ADMIN")
    public void brand_????????????() throws Exception {
        //given
        String brandNameKr = "????????? ?????????";
        String brandNameEng = "????????? ?????????";
        String brandColor = "????????? ??????";
        String brandIntroduction = "????????? ?????????";
        String brandLink = "????????? ??????";
        String brandState = "????????? ??????";

        BrandSaveRequestDto requestDto = BrandSaveRequestDto.builder()
                .brandNameKr(brandNameKr)
                .brandNameEng(brandNameEng)
                .brandColor(brandColor)
                .brandIntroduction(brandIntroduction)
                .brandLink(brandLink)
                .brandState(brandState)
                .build();

        String url = "http://localhost:" + port + "/api/admin/brand";

        //when
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Brand> all = brandRepository.findAll();
        assertThat(all.get(0).getBrandNameKr()).isEqualTo(brandNameKr);
        assertThat(all.get(0).getBrandNameEng()).isEqualTo(brandNameEng);
        assertThat(all.get(0).getBrandColor()).isEqualTo(brandColor);
        assertThat(all.get(0).getBrandIntroduction()).isEqualTo(brandIntroduction);
        assertThat(all.get(0).getBrandLink()).isEqualTo(brandLink);
        assertThat(all.get(0).getBrandState()).isEqualTo(brandState);
    }

    @Test
    @WithMockUser(roles="ADMIN")
    public void brand_????????????() throws Exception {
        //given
        String brandNameKr = "????????? ?????????";
        String brandNameEng = "????????? ?????????";
        String brandColor = "????????? ??????";
        String brandIntroduction = "????????? ?????????";
        String brandLink = "????????? ??????";
        String brandState = "????????? ??????";

        Brand savedBrand = brandRepository.save(Brand.builder()
                .brandNameKr(brandNameKr)
                .brandNameEng(brandNameEng)
                .brandColor(brandColor)
                .brandIntroduction(brandIntroduction)
                .brandLink(brandLink)
                .brandState(brandState)
                .build());

        Long updateId = savedBrand.getBrandCode();
        String expectedBrandNameKr = "????????? ?????????2";
        String expectedBrandNameEng = "????????? ?????????2";
        String expectedBrandColor = "????????? ??????2";
        String expectedBrandIntroduction = "????????? ?????????2";
        String expectedBrandLink = "????????? ??????2";
        String expectedBrandState = "????????? ??????2";

        BrandUpdateRequestDto requestDto = BrandUpdateRequestDto.builder()
                .brandNameKr(expectedBrandNameKr)
                .brandNameEng(expectedBrandNameEng)
                .brandColor(expectedBrandColor)
                .brandIntroduction(expectedBrandIntroduction)
                .brandLink(expectedBrandLink)
                .brandState(expectedBrandState)
                .build();

        String url = "http://localhost:" + port + "/api/admin/brand/" + updateId;

        //when
        mvc.perform(put(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Brand> all = brandRepository.findAll();
        assertThat(all.get(0).getBrandNameKr()).isEqualTo(expectedBrandNameKr);
        assertThat(all.get(0).getBrandNameEng()).isEqualTo(expectedBrandNameEng);
        assertThat(all.get(0).getBrandColor()).isEqualTo(expectedBrandColor);
        assertThat(all.get(0).getBrandIntroduction()).isEqualTo(expectedBrandIntroduction);
        assertThat(all.get(0).getBrandLink()).isEqualTo(expectedBrandLink);
        assertThat(all.get(0).getBrandState()).isEqualTo(expectedBrandState);
    }
}