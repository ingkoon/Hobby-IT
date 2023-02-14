package com.a505.hobbyit.hobbypostitrecord.controller;

import com.a505.hobbyit.hobbypostitrecord.service.HobbyPostitRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "Hobby Postit Record API", description = "방명록 작성 기록 API")
@Slf4j
@RestController
@RequiredArgsConstructor
public class HobbyPostitRecordController {

    private final HobbyPostitRecordService hobbyPostitRecordService;


    @Operation(
            summary = "방명록 작성일 조회",
            description = "소모임의 방명록 작성일을 조회합니다."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "방명록 작성일 반환 성공",
                    content = @Content(examples = {
                            @ExampleObject(value = """
                                    {
                                      "days": [
                                        "1",
                                        "2",
                                        "5",
                                        "10",
                                        "15",
                                        "23",
                                        "28"
                                      ]
                                    }
                                    """)})
            ),
            @ApiResponse(responseCode = "401", description = "방명록 작성일 조회 권한이 없음", content = @Content),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content)
    })
    @GetMapping("/api/hobby/{hobby-id}/postit/record/{date}")
    ResponseEntity<Map<String, List<Integer>>> findHobbyPostitRecords(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") @Parameter(description = "소속 소모임 ID", example = "1") Long hobbyId,
            @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd")
            @Parameter(description = "날짜", example = "2023-01-01") LocalDate date
    ) {
        Map<String, List<Integer>> resultMap = new HashMap<>();
        List<Integer> dayList = hobbyPostitRecordService.findHobbyPostitRecords(
                Long.parseLong(userDetails.getUsername()),
                hobbyId,
                date.getYear(),
                date.getMonthValue()
        );
        resultMap.put("days", dayList);
        return ResponseEntity.ok(resultMap);
    }
}
