package com.sg.document.basic.service;

import java.util.Map;

import org.bson.types.ObjectId;

import com.sg.bpm.service.task.ServiceProvider;
import com.sg.common.BusinessService;

public class LockApplyment extends ServiceProvider {

	private static final String EDITOR_ID = "com.sg.cpm.editor.JZ-QR-XG003A";// 项目立项申请表

	public LockApplyment() {

	}

	@Override
	public Map<String, Object> run(Object parameter) {

		BusinessService.getWorkService().lockDocumentsOfWork(new ObjectId((String) parameter), EDITOR_ID);

		return null;
	}

}
