package com.sg.document.editor;

import org.bson.types.ObjectId;

import com.mongodb.DBObject;
import com.sg.common.BusinessService;
import com.sg.common.db.IDBConstants;
import com.sg.db.model.ISingleObject;
import com.sg.widget.editor.field.defaultvalue.IDefaultValueProvider;


public class DefualtProjectPlanStart implements IDefaultValueProvider {

	public DefualtProjectPlanStart() {

	}

	@Override
	public Object getDefaultValue(ISingleObject data, String key) {

		DBObject document = BusinessService.getDocumentService().getWorkDocument((ObjectId)data.getValue(IDBConstants.FIELD_SYSID),"com.sg.cpm.editor.JZ-QR-XG003A");
		if(document==null){
			return null;
		}
		return document.get(IDBConstants.FIELD_PROJECT_PLANSTART);
	}

}
