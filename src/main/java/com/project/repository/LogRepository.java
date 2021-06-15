package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.project.entity.LogEntity;
import com.project.entity.SurveyAnswerStatistics;
import com.project.entity.UserEntity;

@EnableJpaRepositories
public interface LogRepository extends JpaRepository<LogEntity, Long> {
	
	
	@Modifying
	@Transactional
	@Query(value ="SELECT username, COUNT(count) AS 'count'  FROM log WHERE createddate >= ? AND createddate <= ?  GROUP BY username", nativeQuery = true)
	public List<Object[]> countLog(String start, String end);
	
	@Modifying
	@Transactional
	@Query(value ="SELECT * FROM log WHERE createddate >= ? AND createddate <= ? AND username = ?", nativeQuery = true)
	public List<LogEntity> showLog(String start, String end, String username);
	
	@Modifying
	@Transactional
	@Query(value ="Delete from log where fromId = ?", nativeQuery = true)
	public void deleteLog(Long fromId);
}