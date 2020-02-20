package com.kony.orpheus;

import com.konylabs.middleware.common.JavaService2;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.controller.DataControllerResponse;
import com.konylabs.middleware.dataobject.Result;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.mig82.geppetto.exceptions.GeppettoException;
import com.mig82.geppetto.exceptions.OperationNotFoundException;
import com.mig82.geppetto.proxies.MapProxy;
import com.mig82.geppetto.proxies.ResultProxy;

public abstract class AudioFormatConverterService implements JavaService2 {

	private static final Logger LOGGER = Logger.getLogger( AudioFormatConverterService.class.getName() );

	public Result invoke(String opId, Object[] maps, DataControllerRequest request, DataControllerResponse response) {

		ResultProxy result = new ResultProxy();

		//TODO: 1. get base64 encoded audio file from request.
		//TODO: 2. Call AudioFormatConverter
		//TODO: 3. Return base64 encoded audio file in target format.

		return result.getResult();
	}
}
