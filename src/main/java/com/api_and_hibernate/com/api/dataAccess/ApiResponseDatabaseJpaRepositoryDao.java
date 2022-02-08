package com.api_and_hibernate.com.api.dataAccess;

import com.api_and_hibernate.com.api.dtos.ApiResponseDataBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiResponseDatabaseJpaRepositoryDao extends JpaRepository<ApiResponseDataBaseEntity, Integer> {
}
