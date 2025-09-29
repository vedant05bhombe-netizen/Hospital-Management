package Hospital_Management.Hospital_Management.Service;

import Hospital_Management.Hospital_Management.Entity.PatientEntity;
import Hospital_Management.Hospital_Management.Repo.PatientRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientService {

    private final PatientRepo patientRepo;

    public List<PatientEntity> getAllPatient( ){
         return patientRepo.findAll();
    }

    public Optional<PatientEntity> getPatientById(Long Id ){
       return patientRepo.findById(Id);

    }

    public  PatientEntity createPatient(PatientEntity patientEntity ){
        return patientRepo.save(patientEntity);
    }

    public void deletePatientById ( Long Id){
         patientRepo.deleteById(Id);
    }

}
