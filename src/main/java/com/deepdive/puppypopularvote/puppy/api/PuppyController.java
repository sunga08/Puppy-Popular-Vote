package com.deepdive.puppypopularvote.puppy.api;

import com.deepdive.puppypopularvote.global.error.ErrorResponse;
import com.deepdive.puppypopularvote.global.response.ResponseCode;
import com.deepdive.puppypopularvote.global.response.ResultResponse;
import com.deepdive.puppypopularvote.puppy.dto.PuppyDetailDto;
import com.deepdive.puppypopularvote.puppy.dto.PuppyListDto;
import com.deepdive.puppypopularvote.puppy.service.PuppyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "puppy", description = "강아지 API")
@RestController
@RequiredArgsConstructor
public class PuppyController {

    private final PuppyService puppyService;

    @Operation(summary = "get puppy list", description = "강아지 전체 목록 조회")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = PuppyListDto.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/puppy")
    public ResultResponse<List<PuppyListDto>> findAllPuppy(){
        List<PuppyListDto> puppyList = puppyService.findAllPuppy();
        return ResultResponse.of(ResponseCode.GET_PUPPY_LIST_SUCCESS, puppyList);
    }

    @Operation(summary = "get puppy detail info", description = "강아지 상세 정보 조회")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = PuppyListDto.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @Parameters({
            @Parameter(name = "id", description = "강아지 id", example = "1"),
    })
    @GetMapping("/puppy/{id}")
    public ResultResponse<PuppyDetailDto> findPuppy(@PathVariable("id") Long id){
        PuppyDetailDto puppyDetail = puppyService.findPuppy(id);
        return ResultResponse.of(ResponseCode.GET_PUPPY_DETAIL_SUCCESS, puppyDetail);
    }
}
