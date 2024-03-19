package com.build.contest.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Document(collection = "Users")
@Data
@AllArgsConstructor
public class User {
    
    @Id
    private String id;

    @NonNull
    private String username;

    private Integer score = 0;
}
