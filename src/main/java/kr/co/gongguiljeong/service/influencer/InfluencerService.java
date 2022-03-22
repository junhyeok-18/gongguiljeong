package kr.co.gongguiljeong.service.influencer;

import kr.co.gongguiljeong.domain.influencer.Influencer;
import kr.co.gongguiljeong.domain.influencer.InfluencerRepository;
import kr.co.gongguiljeong.web.dto.influencer.InfluencerListResponseDto;
import kr.co.gongguiljeong.web.dto.influencer.InfluencerResponseDto;
import kr.co.gongguiljeong.web.dto.influencer.InfluencerSaveRequestDto;
import kr.co.gongguiljeong.web.dto.influencer.InfluencerUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class InfluencerService {
    private final InfluencerRepository influencerRepository;

    @Transactional
    public Long save(InfluencerSaveRequestDto requestDto) {
        return influencerRepository.save(requestDto.toEntity()).getInfluencerCode();
    }

    @Transactional
    public Long update(Long influencerCode, InfluencerUpdateRequestDto requestDto) {
        Influencer influencer = influencerRepository.findById(influencerCode)
                .orElseThrow(() -> new IllegalArgumentException(("해당 카테고리가 없습니다. influencer_code = " + influencerCode)));

        influencer.update(requestDto.getInfluencerNameKr(),
                        requestDto.getInfluencerNameEng(),
                        requestDto.getInfluencerColor(),
                        requestDto.getInfluencerIntroduction(),
                        requestDto.getInfluencerLink(),
                        requestDto.getInfluencerState());

        return influencerCode;
    }

    @Transactional
    public void delete(Long influencerCode) {
        Influencer influencer = influencerRepository.findById(influencerCode)
                .orElseThrow(() -> new IllegalArgumentException(("해당 카테고리가 없습니다. influencer_code = " + influencerCode)));

        influencerRepository.delete(influencer);
    }

    @Transactional(readOnly = true)
    public InfluencerResponseDto findById(Long influencerCode) {
        Influencer entity = influencerRepository.findById(influencerCode)
                .orElseThrow(() -> new IllegalArgumentException(("해당 카테고리가 없습니다. influencer_code = " + influencerCode)));

        return new InfluencerResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<InfluencerListResponseDto> findAll() {
        return influencerRepository.findAll().stream()
                .map(InfluencerListResponseDto::new)
                .collect(Collectors.toList());
    }
}
