package event;

import com.aries.view.extension.handler.Adapter;
import com.aries.view.extension.data.Model;
import com.aries.view.extension.data.Event;
import com.aries.view.extension.util.LogUtil;
import prop.LogProp;
import util.LogConfig;
import util.Logger;
import java.text.SimpleDateFormat;

public class LogAdapter implements Adapter {
	public void on(Model[] message) {
		LogProp prop = LogConfig.getLog();

		try {
			SimpleDateFormat sdf = new SimpleDateFormat(prop.getDateFormat());

			for(int i = 0; i < message.length; i++) {
                Event model = (Event) message[i];

				String pattern = prop.getPattern();
				String timeFormat = sdf.format(model.getTime());
				String messageFormat = (model.getMessage() == null || model.getMessage().equals("null")) ? "" : model.getMessage();
				String nameFormat = (!model.getMetricsName().equals("")) ? model.getMetricsName() : model.getErrorType();

				pattern = pattern.replaceFirst("%domainId", "" + model.getDomainId());
				pattern = pattern.replaceFirst("%domainName", "" + model.getDomainName());
				pattern = pattern.replaceFirst("%instanceId", "" + model.getInstanceId());
				pattern = pattern.replaceFirst("%instanceName", "" + model.getInstanceName());
				pattern = pattern.replaceFirst("%value", "" + model.getValue());
				pattern = pattern.replaceFirst("%time", "" + timeFormat);
				pattern = pattern.replaceFirst("%eventName", "" + nameFormat);
				pattern = pattern.replaceFirst("%eventLevel", "" + model.getEventLevel());
				pattern = pattern.replaceFirst("%otype", "" + model.getOtype());
				pattern = pattern.replaceFirst("%serviceName", "" + model.getServiceName());
				pattern = pattern.replaceFirst("%message", "" + messageFormat);
				pattern = pattern.replaceFirst("%detailMessage", "" + model.getDetailMessage());

				Logger.info(pattern);
			}
		} catch (Exception e) {
			LogUtil.error(e.toString());
		}
	}
}
