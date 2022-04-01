package kr.co.gongguiljeong.web;

import kr.co.gongguiljeong.domain.brand.Brand;
import kr.co.gongguiljeong.domain.category.Category;
import kr.co.gongguiljeong.domain.influencer.Influencer;
import kr.co.gongguiljeong.service.schedule.ScheduleService;
import kr.co.gongguiljeong.web.dto.schedule.ScheduleListResponseDto;
import kr.co.gongguiljeong.web.dto.schedule.ScheduleResponseDto;
import kr.co.gongguiljeong.web.dto.schedule.ScheduleSaveRequestDto;
import kr.co.gongguiljeong.web.dto.schedule.ScheduleUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ScheduleApiController {

    private final ScheduleService scheduleService;

    @PostMapping("/api/admin/schedule")
    public Long save(@RequestBody ScheduleSaveRequestDto requestDto) {
        return scheduleService.save(requestDto);
    }

    @PutMapping("/api/admin/schedule/{scheduleCode}")
    public Long update(@PathVariable Long scheduleCode, @RequestBody ScheduleUpdateRequestDto requestDto) {
        return scheduleService.update(scheduleCode, requestDto);
    }

    @DeleteMapping("/api/admin/schedule/{scheduleCode}")
    public Long delete(@PathVariable Long scheduleCode) {
        scheduleService.delete(scheduleCode);
        return scheduleCode;
    }

    @GetMapping("/api/admin/schedule/{scheduleCode}")
    public ScheduleResponseDto findById(@PathVariable Long scheduleCode) {
        return scheduleService.findById(scheduleCode);
    }

    @GetMapping("/api/admin/schedule/list")
    public List<ScheduleListResponseDto> scheduleList() {
        return scheduleService.scheduleList();
    }

    @GetMapping("/api/user/schedule/list")
    public List<ScheduleListResponseDto> mainSchedule(String scheduleDate) {
        return scheduleService.mainSchedule(scheduleDate);
    }
}