package com.rts.ccp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rts.ccp.bean.Option;
import com.rts.ccp.bean.OptionResponse;
import com.rts.ccp.dto.OptionResponseDTO;
import com.rts.ccp.bean.Poll;
import com.rts.ccp.bean.Reaction;
import com.rts.ccp.bean.User;
import com.rts.ccp.repository.OptionRepo;
import com.rts.ccp.repository.OptionResponseRepo;
import com.rts.ccp.repository.PollRepo;
import com.rts.ccp.repository.UserRepo;

@Service
public class OptionResponseService {

	@Autowired
	OptionResponseRepo optionResponseRepo;

	@Autowired
	OptionResponse optResponse;
	
	@Autowired
	OptionRepo optRepo;
	
	@Autowired
	PollRepo pollRepo;
	
	@Autowired
	UserRepo userRepo;
//	public boolean insertOptionResponse(OptionResponse opr) {
//		optionResponseRepo.save(opr);
//		return true;
//	}

//	public boolean insertOptionResponse(OptionResponseDTO opr) {
//		optionResponseRepo.save(opr);
//		return true;
//	}
	/*public boolean insertOptionResponse(long optionid) {
		Option option = optRepo.findById(optionid).get();
		ArrayList<Option> opList = new ArrayList<>();
		ArrayList<OptionResponse> orList = new ArrayList<>();
		Iterator<OptionResponse> itList = option.getOptionResponse().iterator();
		while (itList.hasNext()) {
			OptionResponse oR = itList.next();
			orList.add(oR);
		}
		System.out.println(option);
		optResponse.setOptionResponseId(optionResponseRepo.count() + 1);
		optResponse.setOptionResponse(opr.getOptionResponse());
		System.out.println(opr.getOptionResponse());
		orList.add(optResponse);
		option.setOptionId(opr.getOptionId());
		option.setOptionResponse(orList);
		optRepo.save(option); 
		return true;
	}*/
	
	public boolean insertOptionResponse(OptionResponseDTO opr) {
		Poll poll = pollRepo.findById(opr.getPollId()).get();
		Option option = optRepo.findById(opr.getOptionId()).get();
		User user = userRepo.findById(opr.getUserid()).get();
		
		OptionResponse optionResponse= new OptionResponse();
		optionResponse.setPollId(poll);
		optionResponse.setOptionId(option);
		optionResponse.setUser(user);
		
		optionResponseRepo.save(optionResponse);
		return true;
	}

	public boolean updateOptionResponse(OptionResponse opr) {
		optionResponseRepo.save(opr);
		return true;
	}

	public boolean deleteOptionResponse(Long optionResponseId) {
		optionResponseRepo.deleteById(optionResponseId);
		return true;
	}

	public List<OptionResponse> getAllOptionResponseDetails() {
		Iterator<OptionResponse> it = optionResponseRepo.findAll().iterator();
		ArrayList<OptionResponse> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

	public List<OptionResponse> getOptionInfo() {
		Iterator<OptionResponse> it = optionResponseRepo.getOptionInfo().iterator();
		ArrayList<OptionResponse> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	 public long getOptionCount(long optionId){
	        return optionResponseRepo.getResponseCount(optionId);
	    }
	 
	 public List<OptionResponse> getAllOptionDetails() {
			Iterator<OptionResponse> it = optionResponseRepo.findAll().iterator();
			ArrayList<OptionResponse> list = new ArrayList<>();
			while (it.hasNext()) {
				list.add(it.next());
			}
			return list;
		}
	 
	 public long getOptionResponseCount(long pollId){
	        return optionResponseRepo.getPollResponseCount(pollId);
	    }

}
