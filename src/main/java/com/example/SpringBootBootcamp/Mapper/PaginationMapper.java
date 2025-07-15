package com.example.SpringBootBootcamp.Mapper;

import com.example.SpringBootBootcamp.DTO.PaginationDTO;

import java.util.List;

public class PaginationMapper<T> {

    PaginationDTO<T> paginationDTO = new PaginationDTO<T>();

    public PaginationMapper(){};
    public PaginationMapper(List<T> entities, int limit, int offset, String keyword, int count, int totalCount){
        paginationDTO.entities = entities;
        paginationDTO.limit = limit;
        paginationDTO.offset= offset;
        paginationDTO.keyword = keyword;
        paginationDTO.count = count;
        paginationDTO.totalCount = totalCount;
    }

    public PaginationDTO<T> getConvertedDto(){
        return paginationDTO;
    }
}
