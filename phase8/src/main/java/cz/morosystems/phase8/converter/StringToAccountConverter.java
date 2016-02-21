package cz.morosystems.phase8.converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import cz.morosystems.phase8.entity.AccountEntity;
import cz.morosystems.phase8.entity.BookEntity;
import cz.morosystems.phase8.service.AccountManager;

public class StringToAccountConverter implements Converter<String, AccountEntity> {

	public AccountEntity convert(String accountAsString) {
		// konverze String -> BookEntity
		if (accountAsString == null) {
			throw new ConversionFailedException(TypeDescriptor.valueOf(String.class),
					TypeDescriptor.valueOf(String.class), accountAsString, null);
		}
		AccountEntity account = new AccountEntity();
		String patternString = "([0-9]*)-([0-9]+)/([0-9]+) (.+)$";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(accountAsString);
		if (matcher.find()) {
			account.setAccountPrefix(matcher.group(1));
			account.setAccountNumber(matcher.group(2));
			account.setBankCode(matcher.group(3));
			account.setName(matcher.group(4));
		}
		return account;
	}
}
