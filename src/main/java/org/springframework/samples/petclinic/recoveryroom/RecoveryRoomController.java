package org.springframework.samples.petclinic.recoveryroom;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {
    
	private static final String VIEWS_RECOVER_ROOM_CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
	private final RecoveryRoomService recoverRoomService;

	@Autowired
	public RecoveryRoomController(RecoveryRoomService recoverRoomService) {
		super();
		this.recoverRoomService = recoverRoomService;
	}
	
	
	@GetMapping(value = "/create")
	public String initCreationForm(ModelMap model) {
		RecoveryRoom recoveryRoom = new RecoveryRoom();
		model.put("recoveryRoom", recoveryRoom);
		return VIEWS_RECOVER_ROOM_CREATE_OR_UPDATE_FORM;
	}
	
	@PostMapping(value = "/create")
	public String processCreationForm(@Valid RecoveryRoom rr, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_RECOVER_ROOM_CREATE_OR_UPDATE_FORM;
		}
		else {
			this.recoverRoomService.save(rr);
			
			return "welcome";
		}
	}
	
}
