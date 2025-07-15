package com.example.SpringBootBootcamp.DTO;

import java.util.List;

public class PaginationDTO<T> {

   public List<T> entities;

   public int limit;
   public  int offset;
   public String keyword;
   public int count;
  public int totalCount;
}
