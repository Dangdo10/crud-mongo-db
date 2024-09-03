package com.java.dangdo1198.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageDto<T> implements Serializable {
    private List<T> lstData;
    private int pageNum;
    private int size;
    private int totalPages;
    private long totalRecord;
}
