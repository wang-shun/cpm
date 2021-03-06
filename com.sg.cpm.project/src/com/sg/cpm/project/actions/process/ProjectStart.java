package com.sg.cpm.project.actions.process;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;

import com.mongodb.DBObject;
import com.sg.common.db.DataUtil;
import com.sg.common.ui.UIConstants;

public class ProjectStart extends ProjectProcessControl {

	@Override
	public void run(IAction action) {
		//只有项目经理和项目管理员有权
		if(!DataUtil.isProjectManager(master.getData())
				&&!DataUtil.isProjectAdmin(master.getData())){
			MessageDialog.openWarning(view.getSite().getShell(), UIConstants.TEXT_PROJECT_CONTROL, UIConstants.MESSAGE_CANNOT_CONTROL_PROJECT_PROCESS);
			return;
		}
		
		
		DataUtil.projectStart(master);
		checkStatus();
		super.run(action);

	}

	@Override
	protected boolean statusValid(DBObject data) {
		return DataUtil.isInactive(data)||DataUtil.isReady(data)||DataUtil.isPause(data);
	}

}