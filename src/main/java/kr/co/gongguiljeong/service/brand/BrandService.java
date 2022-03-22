package kr.co.gongguiljeong.service.brand;

import kr.co.gongguiljeong.domain.brand.Brand;
import kr.co.gongguiljeong.domain.brand.BrandRepository;
import kr.co.gongguiljeong.web.dto.brand.BrandListResponseDto;
import kr.co.gongguiljeong.web.dto.brand.BrandResponseDto;
import kr.co.gongguiljeong.web.dto.brand.BrandSaveRequestDto;
import kr.co.gongguiljeong.web.dto.brand.BrandUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BrandService {
    private final BrandRepository brandRepository;

    @Transactional
    public Long save(BrandSaveRequestDto requestDto) {
        return brandRepository.save(requestDto.toEntity()).getBrandCode();
    }

    @Transactional
    public Long update(Long brandCode, BrandUpdateRequestDto requestDto) {
        Brand brand = brandRepository.findById(brandCode)
                .orElseThrow(() -> new IllegalArgumentException(("해당 브랜드가 없습니다. brand_code = " + brandCode)));

        brand.update(requestDto.getBrandNameKr(),
                        requestDto.getBrandNameEng(),
                        requestDto.getBrandColor(),
                        requestDto.getBrandIntroduction(),
                        requestDto.getBrandLink(),
                        requestDto.getBrandState());

        return brandCode;
    }

    @Transactional
    public void delete(Long brandCode) {
        Brand brand = brandRepository.findById(brandCode)
                .orElseThrow(() -> new IllegalArgumentException(("해당 브랜드가 없습니다. brand_code = " + brandCode)));

        brandRepository.delete(brand);
    }

    @Transactional(readOnly = true)
    public BrandResponseDto findById(Long brandCode) {
        Brand entity = brandRepository.findById(brandCode)
                .orElseThrow(() -> new IllegalArgumentException(("해당 브랜드가 없습니다. brand_code = " + brandCode)));

        return new BrandResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<BrandListResponseDto> findAll() {
        return brandRepository.findAll().stream()
                .map(BrandListResponseDto::new)
                .collect(Collectors.toList());
    }
}
