package Hospital_Management.Hospital_Management.Repo;

import Hospital_Management.Hospital_Management.Entity.InsuranceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface InsuranceRepo extends JpaRepository<InsuranceEntity, Long> {
}