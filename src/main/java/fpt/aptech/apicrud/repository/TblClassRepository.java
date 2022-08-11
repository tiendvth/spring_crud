package fpt.aptech.apicrud.repository;

import fpt.aptech.apicrud.entity.TblClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TblClassRepository extends JpaRepository<TblClass, Long> {
}
