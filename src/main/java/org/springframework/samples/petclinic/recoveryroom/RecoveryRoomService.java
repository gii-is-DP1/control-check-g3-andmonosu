package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecoveryRoomService {
	
	private RecoveryRoomRepository recoveryRoomRepo;
	
	@Autowired
    public RecoveryRoomService(RecoveryRoomRepository recoveryRoomRepo) {
		super();
		this.recoveryRoomRepo = recoveryRoomRepo;
	}

	@Transactional
	public List<RecoveryRoom> getAll(){
        return this.recoveryRoomRepo.findAll();
    }

	@Transactional
    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return this.recoveryRoomRepo.findAllRecoveryRoomTypes();
    }
    
    @Transactional
    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return this.recoveryRoomRepo.getRecoveryRoomType(typeName);
    }
    @Transactional
    public List<RecoveryRoom> getRecoveryRoomsBiggerThan(double size) {
        return this.recoveryRoomRepo.findBySizeMoreThan(size);
    }

    @Transactional
    public RecoveryRoom save(RecoveryRoom p) {
        return this.recoveryRoomRepo.save(p);       
    }

    
}
