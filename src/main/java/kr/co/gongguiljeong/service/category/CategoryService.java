package kr.co.gongguiljeong.service.category;

import kr.co.gongguiljeong.domain.category.Category;
import kr.co.gongguiljeong.domain.category.CategoryRepository;
import kr.co.gongguiljeong.web.dto.CategoryListResponseDto;
import kr.co.gongguiljeong.web.dto.CategoryResponseDto;
import kr.co.gongguiljeong.web.dto.CategorySaveRequestDto;
import kr.co.gongguiljeong.web.dto.CategoryUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional
    public Long save(CategorySaveRequestDto requestDto) {
        return categoryRepository.save(requestDto.toEntity()).getCategoryCode();
    }

    @Transactional
    public Long update(Long categoryCode, CategoryUpdateRequestDto requestDto) {
        Category category = categoryRepository.findById(categoryCode)
                .orElseThrow(() -> new IllegalArgumentException(("해당 카테고리가 없습니다. category_code = " + categoryCode)));

        category.update(requestDto.getCategoryNameKr(),
                        requestDto.getCategoryNameEng(),
                        requestDto.getCategoryColor(),
                        requestDto.getCategoryState());

        return categoryCode;
    }

    @Transactional
    public void delete(Long categoryCode) {
        Category category = categoryRepository.findById(categoryCode)
                .orElseThrow(() -> new IllegalArgumentException(("해당 카테고리가 없습니다. category_code = " + categoryCode)));

        categoryRepository.delete(category);
    }

    @Transactional(readOnly = true)
    public CategoryResponseDto findById(Long categoryCode) {
        Category entity = categoryRepository.findById(categoryCode)
                .orElseThrow(() -> new IllegalArgumentException(("해당 카테고리가 없습니다. category_code = " + categoryCode)));

        return new CategoryResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<CategoryListResponseDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryListResponseDto::new)
                .collect(Collectors.toList());
    }
}
