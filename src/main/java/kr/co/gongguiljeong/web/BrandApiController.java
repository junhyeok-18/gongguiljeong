package kr.co.gongguiljeong.web;

import kr.co.gongguiljeong.service.brand.BrandService;
import kr.co.gongguiljeong.web.dto.brand.BrandListResponseDto;
import kr.co.gongguiljeong.web.dto.brand.BrandResponseDto;
import kr.co.gongguiljeong.web.dto.brand.BrandSaveRequestDto;
import kr.co.gongguiljeong.web.dto.brand.BrandUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BrandApiController {

    private final BrandService brandService;

    @PostMapping("/api/admin/brand")
    public Long save(@RequestBody BrandSaveRequestDto requestDto) {
        return brandService.save(requestDto);
    }

    @PutMapping("/api/admin/brand/{brandCode}")
    public Long update(@PathVariable Long brandCode, @RequestBody BrandUpdateRequestDto requestDto) {
        return brandService.update(brandCode, requestDto);
    }

    @DeleteMapping("/api/admin/brand/{brandCode}")
    public Long delete(@PathVariable Long brandCode) {
        brandService.delete(brandCode);
        return brandCode;
    }

    @GetMapping("/api/admin/brand/{brandCode}")
    public BrandResponseDto findById(@PathVariable Long brandCode) {
        return brandService.findById(brandCode);
    }

    @GetMapping("/api/admin/brand/list")
    public List<BrandListResponseDto> findAll() {
        return brandService.findAll();
    }
}