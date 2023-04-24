package com.bolsadeideas.springboot.backend.trimix.services;

import java.util.List;
import com.bolsadeideas.springboot.backend.trimix.model.entity.TipoDocumento;

public interface ITiposDocumentoService {
	
	public List<TipoDocumento> findAllTiposDocumentos();


}
