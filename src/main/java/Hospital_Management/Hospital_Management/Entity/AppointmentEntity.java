package Hospital_Management.Hospital_Management.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "patient_appointment_info")
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(length = 500)
    private String reason;


    @ManyToOne
    @JoinColumn(name = "patient_id" , nullable = false)
    private PatientEntity patientEntity;

    @ManyToOne
    @JoinColumn(name = "doctor_id" , nullable = false)
    private DoctorEntity doctorEntity;

}
