package cz.morosystems.phase8.converter;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import cz.morosystems.phase8.entity.BookEntity;

public class BookToStringConverter implements Converter<BookEntity, String> {

	public String convert(BookEntity book) {
		// konverze BookEntity -> String
		if (book == null) {
			throw new ConversionFailedException(TypeDescriptor.valueOf(BookEntity.class),
					TypeDescriptor.valueOf(String.class), book, null);
		}
		return String.format("%s:%s", book.getTitle(), book.getDescription());
	}
}
