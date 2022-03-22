package kr.co.gongguiljeong.service.schedule;

import kr.co.gongguiljeong.domain.schedule.Schedule;
import kr.co.gongguiljeong.domain.schedule.ScheduleRepository;
import kr.co.gongguiljeong.web.dto.schedule.ScheduleListResponseDto;
import kr.co.gongguiljeong.web.dto.schedule.ScheduleResponseDto;
import kr.co.gongguiljeong.web.dto.schedule.ScheduleSaveRequestDto;
import kr.co.gongguiljeong.web.dto.schedule.ScheduleUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public Long save(ScheduleSaveRequestDto requestDto) {
        return scheduleRepository.save(requestDto.toEntity()).getScheduleCode();
    }

    @Transactional
    public Long update(Long scheduleCode, ScheduleUpdateRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(scheduleCode)
                .orElseThrow(() -> new IllegalArgumentException(("해당 브랜드가 없습니다. schedule_code = " + scheduleCode)));

        schedule.update(requestDto.getScheduleRegisteredPerson(),
                        requestDto.getScheduleCategory(),
                        requestDto.getScheduleBrand(),
                        requestDto.getScheduleInfluencer(),
                        requestDto.getScheduleStartDate(),
                        requestDto.getScheduleEndDate(),
                        requestDto.getScheduleState());

        return scheduleCode;
    }

    @Transactional
    public void delete(Long scheduleCode) {
        Schedule schedule = scheduleRepository.findById(scheduleCode)
                .orElseThrow(() -> new IllegalArgumentException(("해당 브랜드가 없습니다. schedule_code = " + scheduleCode)));

        scheduleRepository.delete(schedule);
    }

    @Transactional(readOnly = true)
    public ScheduleResponseDto findById(Long scheduleCode) {
        Schedule entity = scheduleRepository.findById(scheduleCode)
                .orElseThrow(() -> new IllegalArgumentException(("해당 브랜드가 없습니다. schedule_code = " + scheduleCode)));

        return new ScheduleResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<ScheduleListResponseDto> findAll() {
        return scheduleRepository.findAll().stream()
                .map(ScheduleListResponseDto::new)
                .collect(Collectors.toList());
    }
}
