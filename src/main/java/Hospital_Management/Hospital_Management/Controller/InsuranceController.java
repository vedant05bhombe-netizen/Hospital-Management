package Hospital_Management.Hospital_Management.Controller;

import Hospital_Management.Hospital_Management.Entity.DoctorEntity;
import Hospital_Management.Hospital_Management.Entity.InsuranceEntity;
import Hospital_Management.Hospital_Management.Entity.PatientEntity;
import Hospital_Management.Hospital_Management.Service.InsuranceService;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Getter
@RequestMapping("/insurance")
public class InsuranceController {

    private final InsuranceService insuranceService;

    @PostMapping("/add/{patientId}")
    public ResponseEntity<PatientEntity> addInsurance(
            @RequestBody InsuranceEntity insurance,
            @PathVariable Long patientId) {
        try {
            PatientEntity updatedPatient = insuranceService.AddInsurance(insurance, patientId);
            return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

