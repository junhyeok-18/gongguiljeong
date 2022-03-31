package kr.co.gongguiljeong.web;

import kr.co.gongguiljeong.config.auth.LoginUser;
import kr.co.gongguiljeong.config.auth.dto.SessionUser;
import kr.co.gongguiljeong.service.influencer.InfluencerService;
import kr.co.gongguiljeong.service.brand.BrandService;
import kr.co.gongguiljeong.service.category.CategoryService;
import kr.co.gongguiljeong.service.schedule.ScheduleService;
import kr.co.gongguiljeong.web.dto.brand.BrandResponseDto;
import kr.co.gongguiljeong.web.dto.category.CategoryResponseDto;
import kr.co.gongguiljeong.web.dto.influencer.InfluencerResponseDto;
import kr.co.gongguiljeong.web.dto.schedule.ScheduleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminController {

    private final ScheduleService scheduleService;
    private final CategoryService categoryService;
    private final BrandService brandService;
    private final InfluencerService influencerService;

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

    @GetMapping("/schedule")
    public String scheduleList(Model model) {
        model.addAttribute("schedule", scheduleService.scheduleList());

        return "/admin/schedule/schedule-list";
    }

    @GetMapping("/category")
    public String categoryList(Model model) {
        model.addAttribute("category", categoryService.findAll());

        return "/admin/category/category-list";
    }

    @GetMapping("/brand")
    public String brandList(Model model) {
        model.addAttribute("brand", brandService.findAll());

        return "/admin/brand/brand-list";
    }

    @GetMapping("/influencer")
    public String influencerList(Model model) {
        model.addAttribute("influencer", influencerService.findAll());

        return "/admin/influencer/influencer-list";
    }

    @GetMapping("/schedule/save")
    public String scheduleSave(Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("userCode", user.getUserCode());
            model.addAttribute("loginUserName", user.getUserName());
            model.addAttribute("userEmail", user.getUserEmail());
            model.addAttribute("userProfileImage", user.getUserProfileImage());
            model.addAttribute("userNotification", user.getUserNotification());
        }

        return "/admin/schedule/schedule-save";
    }

    @GetMapping("/category/save")
    public String categorySave() {
        return "/admin/category/category-save";
    }

    @GetMapping("/brand/save")
    public String brandSave() {
        return "/admin/brand/brand-save";
    }

    @GetMapping("/influencer/save")
    public String influencerSave() {
        return "/admin/influencer/influencer-save";
    }

    @GetMapping("/schedule/update/{schedule_code}")
    public String scheduleUpdate(@PathVariable Long schedule_code, Model model) {
        ScheduleResponseDto dto = scheduleService.findById(schedule_code);
        model.addAttribute("schedule", dto);

        return "/admin/schedule/schedule-update";
    }

    @GetMapping("/category/update/{category_code}")
    public String categoryUpdate(@PathVariable Long category_code, Model model) {
        CategoryResponseDto dto = categoryService.findById(category_code);
        model.addAttribute("category", dto);

        return "/admin/category/category-update";
    }

    @GetMapping("/brand/update/{brand_code}")
    public String brandUpdate(@PathVariable Long brand_code, Model model) {
        BrandResponseDto dto = brandService.findById(brand_code);
        model.addAttribute("brand", dto);

        return "/admin/brand/brand-update";
    }

    @GetMapping("/influencer/update/{influencer_code}")
    public String influencerUpdate(@PathVariable Long influencer_code, Model model) {
        InfluencerResponseDto dto = influencerService.findById(influencer_code);
        model.addAttribute("influencer", dto);

        return "/admin/influencer/influencer-update";
    }
}
