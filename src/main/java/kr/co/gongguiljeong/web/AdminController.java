package kr.co.gongguiljeong.web;

import kr.co.gongguiljeong.config.auth.LoginUser;
import kr.co.gongguiljeong.config.auth.dto.SessionUser;
import kr.co.gongguiljeong.service.category.CategoryService;
import kr.co.gongguiljeong.service.posts.PostsService;
import kr.co.gongguiljeong.web.dto.CategoryResponseDto;
import kr.co.gongguiljeong.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class AdminController {

    private final CategoryService categoryService;
    private final PostsService postsService;

    @GetMapping("/gongguiljeong-admin")
    public String adminMain(Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("userCode", user.getUserCode());
            model.addAttribute("loginUserName", user.getUserName());
            model.addAttribute("userEmail", user.getUserEmail());
            model.addAttribute("userProfileImage", user.getUserProfileImage());
            model.addAttribute("userNotification", user.getUserNotification());
        }

        return "/admin/main";
    }

    @GetMapping("/category")
    public String categoryList(Model model) {
        model.addAttribute("category", categoryService.findAll());

        return "/admin/category/category-list";
    }

    @GetMapping("/category/save")
    public String categorySave() {
        return "/admin/category/category-save";
    }

    @GetMapping("/category/update/{category_code}")
    public String postsUpdate(@PathVariable Long category_code, Model model) {
        CategoryResponseDto dto = categoryService.findById(category_code);
        model.addAttribute("category", dto);

        return "/admin/category/category-update";
    }
}
