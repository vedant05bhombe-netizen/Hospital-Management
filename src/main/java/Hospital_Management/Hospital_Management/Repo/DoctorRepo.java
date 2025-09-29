package Hospital_Management.Hospital_Management.Repo;

import Hospital_Management.Hospital_Management.Entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface DoctorRepo extends JpaRepository<DoctorEntity, Long> {
}