package pea2.onpe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pea2.onpe.model.examen;
import pea2.onpe.repository.Iexamen;



@Service

public class examenService implements IexamenService{
	@Autowired
	Iexamen iexamen;
	@Override
	public examen getExamen() {
		return  iexamen.getExamen();
	}


}
