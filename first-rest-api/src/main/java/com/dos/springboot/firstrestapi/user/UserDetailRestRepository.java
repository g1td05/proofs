package com.dos.springboot.firstrestapi.user;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDetailRestRepository extends PagingAndSortingRepository< UserDetails, Long > {

	List< UserDetails > findByRole( String role );
	
}
