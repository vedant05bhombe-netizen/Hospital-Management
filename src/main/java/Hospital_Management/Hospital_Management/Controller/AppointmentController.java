package Hospital_Management.Hospital_Management.Controller;

import Hospital_Management.Hospital_Management.Entity.AppointmentEntity;
import Hospital_Management.Hospital_Management.Entity.PatientEntity;
import Hospital_Management.Hospital_Management.Service.AppointmentService;
import Hospital_Management.Hospital_Management.Service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Getter
@Setter
@RequestMapping("/hospital")
public class AppointmentController {

    private final AppointmentService appointmentService;



    // CREATE APPOINTMENT
    @PostMapping("/create/{doctorId}/{patientId}")
    public ResponseEntity<AppointmentEntity> createAppointment(
            @RequestBody AppointmentEntity appointment,
            @PathVariable Long doctorId,
            @PathVariable Long patientId) {
        try {
            AppointmentEntity createdAppointment = appointmentService.createAppointment(appointment, doctorId, patientId);
            return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
        } catch (EntityNotFoundException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // DELETE APPOINTMENT
    @DeleteMapping("/delete/{doctorId}/{patientId}")
    public ResponseEntity<String> deleteAppointment(
            @RequestBody AppointmentEntity appointment,
            @PathVariable Long doctorId,
            @PathVariable Long patientId) {
        try {
            appointmentService.deleteAppointment(appointment, doctorId, patientId);
            return new ResponseEntity<>("Appointment deleted (if patient inactive)", HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            return new ResponseEntity<>("Patient not found", HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error deleting appointment", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
