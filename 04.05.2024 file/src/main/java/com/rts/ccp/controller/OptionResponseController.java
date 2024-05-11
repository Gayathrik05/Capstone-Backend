package com.rts.ccp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.rts.ccp.bean.OptionResponse;
import com.rts.ccp.dto.OptionResponseDTO;
import com.rts.ccp.bean.Reaction;
import com.rts.ccp.repository.OptionRepo;
import com.rts.ccp.repository.OptionResponseRepo;
import com.rts.ccp.repository.PollRepo;
import com.rts.ccp.service.OptionResponseService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OptionResponseController {

	@Autowired
	OptionResponseService optionResponseService;

	@Autowired
	PollRepo pollRepo;

	@Autowired
	OptionRepo optionRepo;
	
	@Autowired
	OptionResponse optionResponse;

	@Autowired
	OptionResponseRepo optionResponseRepo;
/*
	@PostMapping("/optionResponse")
	public void performOptionResponseInsert(@RequestBody OptionResponseDTO opr) {
		System.out.println("Response Came to Ctrller");
		System.out.println(opr);
		optionResponseService.insertOptionResponse(opr);
	}
*/
//	@PostMapping("/optionResponse/{optresp}")
//	public void performOptionResponseInsertX(@PathVariable("optresp") long optionid) {
//		optionResponseService.insertOptionResponse(optionid);
//	}
	
	@PostMapping("/optionResponse")
	public void performOptionResponseInsert(@RequestBody OptionResponseDTO opr) {
		System.out.println("Response Came to Ctrller");
		System.out.println(opr);
		optionResponseService.insertOptionResponse(opr);
		
		
//		optionResponseRepo.save(opr);
		
		//optionResponseService.insertOptionResponse(opr);
	}
//	 @PostMapping("/optionResponse")
//	  public void saveOptionResponse(@RequestBody() OptionResponse optionResponse) {
//	    return this.optionResponseService.saveOptionResponse(pollId, optionResponse);
//	  }
//	
	@PutMapping("/optionResponse")
	public String performOptionResponseUpdate(@RequestBody OptionResponse opr) {
		optionResponseService.updateOptionResponse(opr);
		return "Option Response Updated!";
	}

	@DeleteMapping("/optionResponse/{optionResponseId}")
	public String performOptionDelete(@PathVariable("optionResponseId") long optionResponseId) {
		optionResponseService.deleteOptionResponse(optionResponseId);
		return "Option Response Deleted!";
	}

	@GetMapping("/optionResponse")
	public List<OptionResponse> viewAllOptionResponseDetails() {
		return optionResponseService.getAllOptionResponseDetails();
	}

	@GetMapping("/OptionInfo")
	public List<OptionResponse> getOptionInfo() {
		return optionResponseService.getOptionInfo();
	}
	
	@GetMapping("/getOptionCount/{optionId}")
	public long performOptionCount (@PathVariable("optionId") long optionId) {
		return optionResponseService.getOptionCount(optionId);
	}
	
	@GetMapping("/viewAllOptionResponse")
	public List<OptionResponse> viewAllReactionDetails() {
		return optionResponseService.getAllOptionDetails();
	}
	
	@GetMapping("/getOptionResponseCount/{pollId}")
	public long performReactionCount (@PathVariable("pollId") long pollId) {
		return optionResponseService.getOptionResponseCount(pollId);
		//return reactionService.getAllReactionDetails();
	}
	
	

}