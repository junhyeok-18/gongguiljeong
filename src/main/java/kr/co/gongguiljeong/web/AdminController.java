package kr.co.gongguiljeong.web;

import kr.co.gongguiljeong.config.auth.LoginUser;
import kr.co.gongguiljeong.config.auth.dto.SessionUser;
import kr.co.gongguiljeong.service.category.CategoryService;
import kr.co.gongguiljeong.service.posts.PostsService;
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
    public String index(Model model) {
        model.addAttribute("category", categoryService.findAll());

        return "/admin/main";
    }

}
