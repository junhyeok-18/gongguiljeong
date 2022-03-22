package kr.co.gongguiljeong.web;

import kr.co.gongguiljeong.service.category.CategoryService;
import kr.co.gongguiljeong.web.dto.category.CategoryListResponseDto;
import kr.co.gongguiljeong.web.dto.category.CategoryResponseDto;
import kr.co.gongguiljeong.web.dto.category.CategorySaveRequestDto;
import kr.co.gongguiljeong.web.dto.category.CategoryUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CategoryApiController {

    private final CategoryService categoryService;

    @PostMapping("/api/admin/category")
    public Long save(@RequestBody CategorySaveRequestDto requestDto) {
        return categoryService.save(requestDto);
    }

    @PutMapping("/api/admin/category/{categoryCode}")
    public Long update(@PathVariable Long categoryCode, @RequestBody CategoryUpdateRequestDto requestDto) {
        return categoryService.update(categoryCode, requestDto);
    }

    @DeleteMapping("/api/admin/category/{categoryCode}")
    public Long delete(@PathVariable Long categoryCode) {
        categoryService.delete(categoryCode);
        return categoryCode;
    }

    @GetMapping("/api/admin/category/{categoryCode}")
    public CategoryResponseDto findById(@PathVariable Long categoryCode) {
        return categoryService.findById(categoryCode);
    }

    @GetMapping("/api/admin/category/list")
    public List<CategoryListResponseDto> findAll() {
        return categoryService.findAll();
    }
}