package com.bolsadeideas.springboot.backend.trimix.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.backend.trimix.dao.ITiposDocumentoDao;
import com.bolsadeideas.springboot.backend.trimix.model.entity.TipoDocumento;

@Service
public class TiposDocumentoImpl implements ITiposDocumentoService{
	
	@Autowired
	private ITiposDocumentoDao ITiposDocumentoDao;

	@Override
	public List<TipoDocumento> findAllTiposDocumentos() {
		return ITiposDocumentoDao.findAllTiposDocumentos();
	}

	

}
