package com.femsa.digital.backend.utileria.tools;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.apache.logging.log4j.core.net.Severity;

import com.femsa.digital.backend.utileria.exception.FemsaDigitalException;

public class StringUtils {
	private static final int V5 = 5; // SHA-1
	private static final String HASH_V5 = "SHA-1";

	public static final UUID NAMESPACE_DNS = new UUID(0x6ba7b8109dad11d1L, 0x80b400c04fd430c8L);
	public static final UUID NAMESPACE_URL = new UUID(0x6ba7b8119dad11d1L, 0x80b400c04fd430c8L);
	public static final UUID NAMESPACE_OID = new UUID(0x6ba7b8129dad11d1L, 0x80b400c04fd430c8L);
	public static final UUID NAMESPACE_X500 = new UUID(0x6ba7b8149dad11d1L, 0x80b400c04fd430c8L);

	/**
	 * Metodo para generar {@link UUID} a partir de parámetros {@link String}
	 * digitalBe
	 * 
	 * @author jesus.scruz
	 * @param digitalBe
	 * @param random
	 * @param fecha
	 * @return
	 */
	public static UUID getRamdomUUID(String digitalBe) {
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String fechaUUID = dateFormat.format(date);
		LoggerUtils.logString(fechaUUID, Severity.INFO);
		long timeSeed = System.nanoTime();
		double randSeed = Math.random() * 1000;
		long midSeed = (long) (timeSeed * randSeed);
		String s = midSeed + "";
		String subStr = s.substring(0, 9);
		int finalSeed = Integer.parseInt(subStr); // integer value
		StringBuilder cadena = new StringBuilder(digitalBe).append(finalSeed).append(fechaUUID);
		return generate(V5, HASH_V5, null, cadena.toString());
	}

	private static UUID generate(int version, String algorithm, UUID namespace, String cadena) {
		MessageDigest hasher = hasher(algorithm);
		if (namespace != null) {
			ByteBuffer ns = ByteBuffer.allocate(16);
			ns.putLong(namespace.getMostSignificantBits());
			ns.putLong(namespace.getLeastSignificantBits());
			hasher.update(ns.array());
		}
		hasher.update(cadena.getBytes(StandardCharsets.UTF_8));
		ByteBuffer hash = ByteBuffer.wrap(hasher.digest());

		final long msb = (hash.getLong() & 0xffffffffffff0fffL) | (version & 0x0f) << 12;
		final long lsb = (hash.getLong() & 0x3fffffffffffffffL) | 0x8000000000000000L;

		return new UUID(msb, lsb);
	}

	private static MessageDigest hasher(String algorithm) {
		try {
			return MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			throw new FemsaDigitalException("Error al procesar...", e);
		}
	}
}
