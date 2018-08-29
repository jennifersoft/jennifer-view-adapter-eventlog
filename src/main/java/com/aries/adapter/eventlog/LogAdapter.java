package com.aries.adapter.eventlog;

import com.aries.extension.handler.EventHandler;
import com.aries.extension.data.EventData;
import com.aries.extension.util.LogUtil;

import java.text.SimpleDateFormat;

public class LogAdapter implements EventHandler {
	public void on(EventData[] message) {
		LogProp prop = LogConfig.getLog();

		try {
			SimpleDateFormat sdf = new SimpleDateFormat(prop.getDateFormat());

			for(int i = 0; i < message.length; i++) {
                EventData model = message[i];

				String pattern = prop.getPattern();
				String timeFormat = sdf.format(model.time);
				String messageFormat = (model.message == null || model.message.equals("null")) ? "" : model.message;
				String nameFormat = (!model.metricsName.equals("")) ? model.metricsName : model.errorType;

				pattern = pattern.replaceFirst("%domainId", "" + model.domainId);
				pattern = pattern.replaceFirst("%domainName", "" + model.domainName);
				pattern = pattern.replaceFirst("%instanceId", "" + model.instanceId);
				pattern = pattern.replaceFirst("%instanceName", "" + model.instanceName);
				pattern = pattern.replaceFirst("%value", "" + model.value);
				pattern = pattern.replaceFirst("%time", "" + timeFormat);
				pattern = pattern.replaceFirst("%eventName", "" + nameFormat);
				pattern = pattern.replaceFirst("%eventLevel", "" + model.eventLevel);
				pattern = pattern.replaceFirst("%otype", "" + model.otype);
				pattern = pattern.replaceFirst("%serviceName", "" + model.serviceName);
				pattern = pattern.replaceFirst("%message", "" + messageFormat);
				pattern = pattern.replaceFirst("%detailMessage", "" + model.detailMessage);

				Logger.info(pattern);
			}
		} catch (Exception e) {
			LogUtil.error(e.toString());
		}
	}
}
