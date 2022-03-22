package kr.co.gongguiljeong.web;

import kr.co.gongguiljeong.service.influencer.InfluencerService;
import kr.co.gongguiljeong.web.dto.influencer.InfluencerListResponseDto;
import kr.co.gongguiljeong.web.dto.influencer.InfluencerResponseDto;
import kr.co.gongguiljeong.web.dto.influencer.InfluencerSaveRequestDto;
import kr.co.gongguiljeong.web.dto.influencer.InfluencerUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class InfluencerApiController {

    private final InfluencerService influencerService;

    @PostMapping("/api/admin/influencer")
    public Long save(@RequestBody InfluencerSaveRequestDto requestDto) {
        return influencerService.save(requestDto);
    }

    @PutMapping("/api/admin/influencer/{influencerCode}")
    public Long update(@PathVariable Long influencerCode, @RequestBody InfluencerUpdateRequestDto requestDto) {
        return influencerService.update(influencerCode, requestDto);
    }

    @DeleteMapping("/api/admin/influencer/{influencerCode}")
    public Long delete(@PathVariable Long influencerCode) {
        influencerService.delete(influencerCode);
        return influencerCode;
    }

    @GetMapping("/api/admin/influencer/{influencerCode}")
    public InfluencerResponseDto findById(@PathVariable Long influencerCode) {
        return influencerService.findById(influencerCode);
    }

    @GetMapping("/api/admin/influencer/list")
    public List<InfluencerListResponseDto> findAll() {
        return influencerService.findAll();
    }
}