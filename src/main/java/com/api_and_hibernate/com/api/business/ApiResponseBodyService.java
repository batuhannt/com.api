package com.api_and_hibernate.com.api.business;

import com.api_and_hibernate.com.api.dtos.ApiResponseBody;
import com.api_and_hibernate.com.api.dtos.ApiResponseDataBaseEntity;

public interface ApiResponseBodyService {
    void get(ApiResponseBody responseBody);
    void getData();
    void delete(int id);

}
