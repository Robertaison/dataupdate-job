package com.dataprovider.datajob.repository;

import com.dataprovider.datajob.model.TraceDataUpdateEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraceDataRepository extends JpaRepository<TraceDataUpdateEntity, Integer> {

  Optional<TraceDataUpdateEntity> findByCpf(String cpf);
}
