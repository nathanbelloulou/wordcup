package com.adif.utils;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.log4j.Logger;


public class LoginPhaseListener implements PhaseListener {

	
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(LoginPhaseListener.class);

	@Override
	public void beforePhase(PhaseEvent aEvent) {
		
		if (aEvent.getPhaseId() == PhaseId.RESTORE_VIEW) {
			LOG.info("=======================================================");
		}
		LOG.info("beforePhase:" + aEvent.getPhaseId());
	}

	@Override
	public void afterPhase(PhaseEvent aEvent) {
		LOG.info("afterPhase:" + aEvent.getPhaseId());

	}


	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
