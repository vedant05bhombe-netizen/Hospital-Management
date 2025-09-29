package Hospital_Management.Hospital_Management.Service;

import Hospital_Management.Hospital_Management.Entity.DoctorEntity;
import Hospital_Management.Hospital_Management.Repo.DoctorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DoctorService {

    private final DoctorRepo doctorRepo;


    public List<DoctorEntity> getAllDoctors() {
        return doctorRepo.findAll();
    }


    public Optional<DoctorEntity> getDoctorById(Long id) {
        return doctorRepo.findById(id);
    }


    public DoctorEntity createDoctor(DoctorEntity doctorEntity) {
        return doctorRepo.save(doctorEntity);
    }


    public void deleteDoctorById(DoctorEntity doctorEntity , Long Id) {
        doctorRepo.deleteById(Id);
    }
}
