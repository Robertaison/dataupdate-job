package com.dataprovider.datajob.repository;

import com.dataprovider.datajob.model.ScoreDataEntity;
import com.dataprovider.datajob.model.TraceDataEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraceDataRepository extends JpaRepository<TraceDataEntity, Integer> {
  Optional<TraceDataEntity> findByCpf(String cpf);
}
