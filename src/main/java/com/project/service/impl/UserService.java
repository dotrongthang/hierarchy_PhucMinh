package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.converter.UserConverter;
import com.project.dto.UserDTO;
import com.project.entity.UserEntity;
import com.project.repository.UserRepository;
import com.project.service.IUserService;

@Service
public class UserService implements IUserService {
	
	int row = 0;
	String s = "";
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;

	@Override
	public UserDTO save(UserDTO dto) {
		UserEntity entityNew = userConverter.toEntity(dto);
		UserEntity entity = userConverter.toEntity(dto);
		while(entity.getParentid() !=0) {
			Long id = entity.getParentid();
			userRepository.updateCount(id);
			entity = userRepository.findOne(id);
		}
		UserEntity entityFinal = userRepository.save(entityNew);
		return userConverter.toDTO(entityFinal);
	}

	@Override
	public List<UserEntity> findByParentName(String parentName) {
		return userRepository.findByUsernameContaining(parentName);
	}

	@Override
	public UserEntity findOneById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public List<UserDTO> findAll(Pageable pageable) {
		List<UserDTO> models = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll(pageable).getContent();
		for (UserEntity item: entities) {
			UserDTO userDTO = userConverter.toDTO(item);
			models.add(userDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) userRepository.count();
	}

	@Override
	public List<UserDTO> findByParentId(Long parentId) {
		List<UserDTO> models = new ArrayList<>();
		List<UserEntity> entities = userRepository.findByParentid(parentId);
		for (UserEntity item: entities) {
			UserDTO userDTO = userConverter.toDTO(item);
			models.add(userDTO);
		}
		return models;
	}

	@Override
	public List<UserDTO> findByName(String name) {
		List<UserDTO> models = new ArrayList<>();
		List<UserEntity> entities = userRepository.findByUsernameContaining(name);
		for (UserEntity item: entities) {
			UserDTO userDTO = userConverter.toDTO(item);
			models.add(userDTO);
		}
		return models;
	}

	@Override
	public String findIDWhenActive(int id) {
		s = "";
		result(id, findPossition(id));
		return s;
	}
	
	public int findPossition(int index){
        int sum = 1;
        int count = 0;
        for (int i = 1; i < 15; i++) {
            if (index > sum*3-1){
                sum = sum*3 -1;
                count = i;
            }else {

                break;
            }
        }
        row = count;
        return sum;
    }

    public void result(int index, int sum){
        int tmp = index;
        for (int i = row-1; i >= 1 ; i--) {
            int tmp2 = tmp - sum;
            int tmp1 = 1;
            for (int j = 1; j <= i; j++) {
                tmp1 = tmp1*3;
            }
            tmp2 = tmp2%tmp1;
            sum = (sum +1)/3;
            s = s + String.valueOf(sum + tmp2) + "\t";
            tmp = sum + tmp2;
        }
    }

}
