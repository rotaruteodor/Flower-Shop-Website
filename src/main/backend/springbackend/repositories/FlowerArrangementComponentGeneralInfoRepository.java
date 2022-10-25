package springbackend.repositories;

import springbackend.entities.FlowerArrangementComponentGeneralInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerArrangementComponentGeneralInfoRepository extends JpaRepository<FlowerArrangementComponentGeneralInfo, Long> {
}
