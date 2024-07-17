package com.usg.apirest.reportes;

import com.usg.apirest.SetDatosReportes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryReportes extends JpaRepository<SetDatosReportes,Long> {
}
