package com.dipta.project.utility.constants;

public enum ProjectTemplateEnum {
	ENRICH(1),INSTRUMENT(2),HIE_ENRICH(6),HIE_BUILD(7),CROSS_REF(3);
	
	long templateId;
	
	private ProjectTemplateEnum(long templateId) {
		this.templateId=templateId;
	}
	
	public long getTemplateId(){
		return this.templateId;
	}
}
