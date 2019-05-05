package com.boot.module.aiApiInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.module.aiApiInfo.bean.AIAPIInfo;

@Repository
public interface AIAPIInfoRepository extends JpaRepository<AIAPIInfo, String> {
	
	
}