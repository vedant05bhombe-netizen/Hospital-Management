package Hospital_Management.Hospital_Management.Service;

import Hospital_Management.Hospital_Management.Entity.AppointmentEntity;

import Hospital_Management.Hospital_Management.Entity.DoctorEntity;
import Hospital_Management.Hospital_Management.Entity.PatientEntity;
import Hospital_Management.Hospital_Management.Repo.AppointmentRepo;
import Hospital_Management.Hospital_Management.Repo.DoctorRepo;
import Hospital_Management.Hospital_Management.Repo.PatientRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.parser.Part;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final PatientRepo patient;
    private final DoctorRepo doctor;
    private final AppointmentRepo appointment;
    private final AppointmentRepo appointmentRepo;

    @Transactional
    public AppointmentEntity createAppointment(AppointmentEntity appointment, Long doctorId, Long patientId) {
        PatientEntity patientEntity = patient.findById(patientId).orElseThrow(() ->  new EntityNotFoundException(" not found"));
        DoctorEntity doctorEntity = doctor.findById(doctorId).orElseThrow(() ->  new EntityNotFoundException(" not found"));


                appointment.setPatientEntity(patientEntity);
                 appointment.setDoctorEntity(doctorEntity);

        return appointment;
    }

    @Transactional
    public void deleteAppointment(AppointmentEntity appointment, Long doctorId, Long patientId) {
        PatientEntity patientEntity = patient.findById(patientId).orElseThrow(() ->  new EntityNotFoundException(" not found"));
        if("INACTIVE".equalsIgnoreCase(patientEntity.getStatus())){
            appointmentRepo.delete(appointment);
        }

         
    }
}
