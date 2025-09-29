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
@Table(name = "department")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , unique = true , length = 100)
    private String name;

    @OneToOne
    private DoctorEntity headDoctor;

    @ManyToMany
    private Set<DoctorEntity> doctorEntities = new HashSet<>();
}
