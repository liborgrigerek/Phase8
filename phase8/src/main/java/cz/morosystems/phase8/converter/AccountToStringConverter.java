package cz.morosystems.phase8.converter;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import cz.morosystems.phase8.entity.AccountEntity;

public class AccountToStringConverter implements Converter<AccountEntity, String> {

	public String convert(AccountEntity account) {
		// konverze BookEntity -> String
		if (account == null) {
			throw new ConversionFailedException(TypeDescriptor.valueOf(AccountEntity.class),
					TypeDescriptor.valueOf(String.class), account, null);
		}
		return String.format("%s-%s/%s %s", account.getAccountPrefix(), account.getAccountNumber(), account.getBankCode(), account.getName());
	}
}
