package com.bolsadeideas.springboot.backend.trimix.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.bolsadeideas.springboot.backend.trimix.model.entity.TipoDocumento;

@Repository
public interface ITiposDocumentoDao extends CrudRepository<TipoDocumento, Long> {
	
	@Query("SELECT t FROM TipoDocumento t")
	public List<TipoDocumento> findAllTiposDocumentos();

}
