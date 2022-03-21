package kr.co.gongguiljeong.web;

import kr.co.gongguiljeong.config.auth.LoginUser;
import kr.co.gongguiljeong.config.auth.dto.SessionUser;
import kr.co.gongguiljeong.service.posts.PostsService;
import kr.co.gongguiljeong.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        //model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userCode", user.getUserCode());
            model.addAttribute("loginUserName", user.getUserName());
            model.addAttribute("userEmail", user.getUserEmail());
            model.addAttribute("userProfileImage", user.getUserProfileImage());
            model.addAttribute("userNotification", user.getUserNotification());

            System.out.println("userNotification : " +  user.getUserNotification());
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}

