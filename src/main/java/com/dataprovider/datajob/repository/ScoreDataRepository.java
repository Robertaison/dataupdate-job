package com.dataprovider.datajob.repository;

import com.dataprovider.datajob.model.ScoreDataEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreDataRepository extends JpaRepository<ScoreDataEntity, Integer> {

  Optional<ScoreDataEntity> findByCpf(String cpf);
}
