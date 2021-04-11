package ru.gotoqa.mock.endpoint;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.gotoqa.mock.core.builders.CapitalCityResponseBuilder;
import ru.gotoqa.mock.core.builders.CountryCurrencyResponseBuilder;
import ru.gotoqa.mock.entity.CapitalCity;
import ru.gotoqa.mock.entity.CapitalCityResponse;
import ru.gotoqa.mock.entity.CountryCurrency;
import ru.gotoqa.mock.entity.CountryCurrencyResponse;

/**
 * SOAP API Controller /mock-soap
 */
@Endpoint
@Log4j2
public class CountryInfoController {

    private final CapitalCityResponseBuilder cityResponseBuilder;
    private final CountryCurrencyResponseBuilder currencyResponseBuilder;

    @Autowired
    public CountryInfoController(CapitalCityResponseBuilder cityResponseBuilder,
                                 CountryCurrencyResponseBuilder currencyResponseBuilder) {
        this.cityResponseBuilder = cityResponseBuilder;
        this.currencyResponseBuilder = currencyResponseBuilder;
    }

    @ResponsePayload
    @PayloadRoot(namespace = "http://www.oorsprong.org/websamples.countryinfo",
            localPart = "CapitalCity")
    public CapitalCityResponse getCapitalCityByISOCode(@RequestPayload CapitalCity input) {
        log.info("CapitalCityResponse received for addition with input " + input);
        return cityResponseBuilder.createCountryCurrencyResponse(input);
    }

    @ResponsePayload
    @PayloadRoot(namespace = "http://www.oorsprong.org/websamples.countryinfo",
            localPart = "CountryCurrency")
    public CountryCurrencyResponse getCountryCurrencyByISOCode(@RequestPayload CountryCurrency input) {
        log.info("CountryCurrencyResponse received for addition with input " + input);
        return currencyResponseBuilder.createCountryCurrencyResponse(input);
    }

}