package kr.co.gongguiljeong.web;

import kr.co.gongguiljeong.config.auth.LoginUser;
import kr.co.gongguiljeong.config.auth.dto.SessionUser;
import kr.co.gongguiljeong.service.posts.PostsService;
import kr.co.gongguiljeong.service.schedule.ScheduleService;
import kr.co.gongguiljeong.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    private final ScheduleService scheduleService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("userCode", user.getUserCode());
            model.addAttribute("loginUserName", user.getUserName());
            model.addAttribute("userEmail", user.getUserEmail());
            model.addAttribute("userProfileImage", user.getUserProfileImage());
            model.addAttribute("userNotification", user.getUserNotification());
        }

        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
        String now = current.format(formatter);
        System.out.println("Current: " + now);

        model.addAttribute("schedule", scheduleService.mainSchedule(now));

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

