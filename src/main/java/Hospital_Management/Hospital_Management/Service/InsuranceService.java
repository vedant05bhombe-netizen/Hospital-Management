package Hospital_Management.Hospital_Management.Service;

import Hospital_Management.Hospital_Management.Entity.InsuranceEntity;
import Hospital_Management.Hospital_Management.Entity.PatientEntity;
import Hospital_Management.Hospital_Management.Repo.InsuranceRepo;
import Hospital_Management.Hospital_Management.Repo.PatientRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
     private final PatientRepo patientRepo;
    private final InsuranceRepo insuranceRepo;
@Transactional
public PatientEntity AddInsurance(InsuranceEntity insurance , Long patientId){
    PatientEntity patient = patientRepo.findById(patientId).orElseThrow(() -> new EntityNotFoundException(" not found"));

    patient.setInsuranceEntity(insurance);
    if("INACTIVE".equalsIgnoreCase(patient.getStatus())){
        insuranceRepo.delete(insurance);
    }
    insurance.setPatientEntity(patient);
    return patient;


}

}

