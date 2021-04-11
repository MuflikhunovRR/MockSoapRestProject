package ru.gotoqa.mock.core.builders;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import ru.gotoqa.mock.core.storages.CountryCurrencyRequestStorage;
import ru.gotoqa.mock.core.storages.CountryCurrencyResponseStorage;
import ru.gotoqa.mock.entity.CountryCurrency;
import ru.gotoqa.mock.entity.CountryCurrencyResponse;
import ru.gotoqa.mock.entity.TCurrency;

@Log4j2
public class CountryCurrencyResponseBuilder {

    @Autowired
    public CountryCurrencyRequestStorage requestStorage;
    @Autowired
    public CountryCurrencyResponseStorage responseStorage;

    public CountryCurrencyResponse createCountryCurrencyResponse(CountryCurrency countryCurrency) {
        log.info("Start generate CountryCurrencyResponse");
        CountryCurrencyResponse profileResult = new CountryCurrencyResponse();
        requestStorage.addRequestToStorage(countryCurrency);
        TCurrency tCurrency = responseStorage.getResponseStorage().get(countryCurrency.getSCountryISOCode());
        profileResult.setCountryCurrencyResult(tCurrency);
        log.info("Finish generate CountryCurrencyResponse response");
        return profileResult;
    }

}