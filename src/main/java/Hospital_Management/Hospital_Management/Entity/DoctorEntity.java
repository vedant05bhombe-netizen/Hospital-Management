package Hospital_Management.Hospital_Management.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctor_info")
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , length = 100)
    private String name;

    @Column(nullable = false , length = 100)
    private String specialization;



    @Column(nullable = false , length = 100 , unique = true)
    private String email;

    @ManyToMany(mappedBy = "doctorEntities")
    private Set<DepartmentEntity> departmentEntities = new HashSet<>();

}
