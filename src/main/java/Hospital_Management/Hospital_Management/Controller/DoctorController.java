package Hospital_Management.Hospital_Management.Controller;

import Hospital_Management.Hospital_Management.Entity.DoctorEntity;
import Hospital_Management.Hospital_Management.Entity.PatientEntity;
import Hospital_Management.Hospital_Management.Service.DoctorService;
import Hospital_Management.Hospital_Management.Service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequiredArgsConstructor
@RequestMapping("/doctors")
public class DoctorController {



    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorEntity>> getAlldoctor() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorEntity> getPatientById(@PathVariable Long id) {
        return doctorService.getDoctorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DoctorEntity> createPatient(@RequestBody DoctorEntity doctorEntity) {
        DoctorEntity created = doctorService.createDoctor(doctorEntity);
        return ResponseEntity.status(201).body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatientById(@PathVariable Long id) {
        doctorService.deleteDoctorById(id);
        return ResponseEntity.noContent().build();
    }
}
