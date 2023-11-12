package com.backend.apirest.api.model.filters;

import lombok.Data;

@Data
public class ClientIndexFilters {
    
    Integer pageNumber = 0;
    
    Integer pageSize = 5;
}
