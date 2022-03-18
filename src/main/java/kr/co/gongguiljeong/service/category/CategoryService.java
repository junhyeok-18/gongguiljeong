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
        return categoryRepository.save(requestDto.toEntity()).getCategory_code();
    }

    @Transactional
    public Long update(Long category_code, CategoryUpdateRequestDto requestDto) {
        Category category = categoryRepository.findById(category_code)
                .orElseThrow(() -> new IllegalArgumentException(("해당 카테고리가 없습니다. category_code = " + category_code)));

        category.update(requestDto.getCategory_name_kr(),
                        requestDto.getCategory_name_eng(),
                        requestDto.getCategory_color(),
                        requestDto.getCategory_state());

        return category_code;
    }

    @Transactional
    public void delete(Long category_code) {
        Category category = categoryRepository.findById(category_code)
                .orElseThrow(() -> new IllegalArgumentException(("해당 카테고리가 없습니다. category_code = " + category_code)));

        categoryRepository.delete(category);
    }

    @Transactional(readOnly = true)
    public CategoryResponseDto findById(Long category_code) {
        Category entity = categoryRepository.findById(category_code)
                .orElseThrow(() -> new IllegalArgumentException(("해당 카테고리가 없습니다. category_code = " + category_code)));

        return new CategoryResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<CategoryListResponseDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryListResponseDto::new)
                .collect(Collectors.toList());
    }
}
