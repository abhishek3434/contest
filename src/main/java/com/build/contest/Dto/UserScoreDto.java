package com.build.contest.Dto;

import com.mongodb.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;

// Use to update user score

@Data
@NoArgsConstructor
public class UserScoreDto {

    @NonNull
    private Integer score;
}
