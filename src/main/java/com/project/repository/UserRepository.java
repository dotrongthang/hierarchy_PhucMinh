package com.project.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.project.entity.UserEntity;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	List<UserEntity> findByUsernameContaining(String username);
	
	@Modifying
	@Transactional
	@Query(value ="UPDATE user SET count = (count + 1), modifieddate = ?, fromId = ? WHERE id = ?", nativeQuery = true)
	public void updateCount(Date modifieddate,Long fromId, Long id);
	
	List<UserEntity> findByParentid(Long parentid);
	
	UserEntity findByUsername(String username);
	
	@Modifying
	@Transactional
	@Query(value ="UPDATE user SET createddate = ?, fromId = 0 WHERE id = ?", nativeQuery = true)
	public void updateDate(Date createddate, Long id);
}