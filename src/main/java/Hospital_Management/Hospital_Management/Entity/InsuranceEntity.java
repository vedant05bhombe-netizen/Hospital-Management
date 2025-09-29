package Hospital_Management.Hospital_Management.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient_insurance_info")
public class InsuranceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false  , unique = true ,length = 100)
    private String insuranceProvider;

    @Column(nullable = false  , unique = true ,length = 50)
    private String insuranceNumber;

    private LocalDate createdAt;
    private LocalDate ValidUntil;

    @OneToOne(mappedBy = "insuranceEntity")
    private PatientEntity patientEntity;
}
