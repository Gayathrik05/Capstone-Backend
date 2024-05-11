package com.rts.ccp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rts.ccp.bean.OptionResponse;

@Repository
public interface OptionResponseRepo extends CrudRepository<OptionResponse, Long> {

	@Query(value = "select * from tbl_option_response where option_id = ?", nativeQuery = true)
	public List<OptionResponse> getOptionInfo();

	@Query(value = "select count(*) from tbl_option_response where poll_id = ? ", nativeQuery = true)
	public long getPollResponseCount(long pollId);

	@Query(value = "select count(*) from tbl_option_response where option_id = ? ", nativeQuery = true)
	public long getOptionResponseCount(long optionId);
	
	@Query(value = "select round((count(*)/(select count(*) from tbl_option_response where poll_id=1))*100) as result from tbl_option_response where poll_id=1 and option_id=?; ", nativeQuery = true)
	public long getResponseCount(long optionId);

	@Query(value = "select * from tbl_option_response where option_response_id = ? ", nativeQuery = true)
	public List<OptionResponse> getOptionResponse(long optionResponseId);


}