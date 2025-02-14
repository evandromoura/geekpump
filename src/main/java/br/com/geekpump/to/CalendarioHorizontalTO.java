package br.com.geekpump.to;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.geekpump.entity.ExecucaoTreinoExercicio;
import br.com.geekpump.util.UtilData;

public class CalendarioHorizontalTO {

	private Date data;
	
	private List<ExecucaoTreinoExercicio> execucoes;
	
	public Date getData() {
		return data;
	}
	
	public CalendarioHorizontalTO() {}
	
	public CalendarioHorizontalTO(Date data,List<ExecucaoTreinoExercicio> execucoes) {
		setData(data);
		setExecucoes(execucoes);
	}

	public String getDataFormat() {
		if(getData() != null) {
			return UtilData.formatDate(getData(), "dd/MM");
		}
		return "";
	}
	
	public String getDataFormatParam() {
		if(getData() != null) {
			return UtilData.formatDate(getData(), "yyyyMMdd");
		}
		return "";
	}
	
	public String getDiaSemanaFormat() {
		if(getData() != null) {
			return UtilData.getDiaSemana(getData());
		}
		return "";
	}
	
	public void setData(Date data) {
		this.data = data;
	}

	public List<ExecucaoTreinoExercicio> getExecucoes() {
		if (execucoes == null) {
			execucoes = new ArrayList<ExecucaoTreinoExercicio>();
		}
		return execucoes;
	}

	public void setExecucoes(List<ExecucaoTreinoExercicio> execucoes) {
		this.execucoes = execucoes;
	}

	
}
