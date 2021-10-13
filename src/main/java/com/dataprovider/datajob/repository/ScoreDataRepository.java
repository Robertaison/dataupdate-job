package com.dataprovider.datajob.repository;

import com.dataprovider.datajob.model.ScoreDataUpdateEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreDataRepository extends JpaRepository<ScoreDataUpdateEntity, Integer> {

  Optional<ScoreDataUpdateEntity> findByCpf(String cpf);
}
