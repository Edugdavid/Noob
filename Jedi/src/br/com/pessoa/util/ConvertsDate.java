package br.com.pessoa.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ConvertsDate {
	public static Timestamp convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
		return java.sql.Timestamp.valueOf(dateToConvert);
	}

	public static LocalDateTime convertToEntityAttribute(Timestamp ts) {
		if (ts != null) {
			return ts.toLocalDateTime();
		}
		return null;
	}
}
