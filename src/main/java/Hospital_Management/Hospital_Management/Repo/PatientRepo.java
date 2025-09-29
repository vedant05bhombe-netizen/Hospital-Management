package Hospital_Management.Hospital_Management.Repo;

import Hospital_Management.Hospital_Management.Entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface PatientRepo extends JpaRepository<PatientEntity, Long> {

}