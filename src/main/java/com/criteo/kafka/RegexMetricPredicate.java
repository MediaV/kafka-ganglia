package com.criteo.kafka;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.yammer.metrics.core.Metric;
import com.yammer.metrics.core.MetricName;
import com.yammer.metrics.core.MetricPredicate;

import static com.criteo.kafka.KafkaGangliaMetricsReporter.LOG;

public class RegexMetricPredicate implements MetricPredicate {
	Pattern pattern = null;

	public RegexMetricPredicate(String regex) {
		pattern = Pattern.compile(regex);
	}

	@Override
	public boolean matches(MetricName name, Metric metric) {
		boolean ok = pattern.matcher(name.getName()).matches();
//		LOG.error(String.format("name: %s - %s", name.getName(), ok));
		return ok;
	}
}
