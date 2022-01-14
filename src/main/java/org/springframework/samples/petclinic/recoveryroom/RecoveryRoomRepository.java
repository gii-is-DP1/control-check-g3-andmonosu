package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer>{
    List<RecoveryRoom> findAll();
    
    @Query("SELECT rrtype FROM RecoveryRoomType rrtype")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
    
    Optional<RecoveryRoom> findById(int id);
    RecoveryRoom save(RecoveryRoom p);
    
    @Query("SELECT DISTINCT rrtype FROM RecoveryRoomType rrtype WHERE rrtype.name = ?1")
    RecoveryRoomType getRecoveryRoomType(String name);
    
    @Query("SELECT DISTINCT rr FROM RecoveryRoom rr WHERE rr.size > ?1")
    List<RecoveryRoom> findBySizeMoreThan(double size);
}
