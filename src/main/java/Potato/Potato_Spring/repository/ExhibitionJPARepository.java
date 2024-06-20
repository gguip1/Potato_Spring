package Potato.Potato_Spring.repository;

import Potato.Potato_Spring.entity.ExhibitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExhibitionJPARepository extends JpaRepository<ExhibitionEntity, Long> {
}
