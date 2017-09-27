package cz.morosystems.phase8.converter;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import cz.morosystems.phase8.entity.BookEntity;

public class StringToBookConverter implements Converter<String, BookEntity> {
	
	public BookEntity convert(String bookAsString) {
		// konverze String -> BookEntity
		if (bookAsString == null) {
			throw new ConversionFailedException(TypeDescriptor.valueOf(String.class),
					TypeDescriptor.valueOf(String.class), bookAsString, null);
		}
		String[] tempArray = bookAsString.split(":");
		String title = tempArray[0];
		String description = (tempArray.length>1) ? tempArray[1] : "";
		BookEntity book = new BookEntity();
		book.setTitle(title);
		book.setDescription(description);
		return book;
	}
}
