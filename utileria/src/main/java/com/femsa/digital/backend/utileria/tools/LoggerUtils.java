package com.femsa.digital.backend.utileria.tools;

import org.apache.logging.log4j.core.net.Severity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggerUtils {

	private LoggerUtils() {
	}

	public static void logString(String mensaje, Severity severity) {
		log.info("Severity=>{}-{}", severity.name(), severity.getCode());
		switch (severity.getCode()) {
		case 6:
			log.info(mensaje);
			break;
		case 4:
			log.warn(mensaje);
			break;
		case 3:
			log.error(mensaje);
			break;
		case 7:
			log.debug(mensaje);
			break;
		default:
			log.info(mensaje);
		}
	}

}
