package ru.gotoqa.mock.endpoint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gotoqa.mock.core.storages.CapitalCityRequestStorage;
import ru.gotoqa.mock.core.storages.CapitalCityResponseStorage;
import ru.gotoqa.mock.entity.CapitalCity;

import java.util.List;

/**
 * Mock manager settings for CapitalCity
 */
@Log4j2
@RestController
@RequestMapping("/filter/capitalCity")
@Api(tags = "Mock manager settings for CapitalCity")
public class CapitalCityFilterController {

    private final CapitalCityRequestStorage capitalCityRequestStorage;
    private final CapitalCityResponseStorage capitalCityResponseStorage;

    @Autowired
    public CapitalCityFilterController(CapitalCityRequestStorage capitalCityRequestStorage,
                                       CapitalCityResponseStorage capitalCityResponseStorage) {
        this.capitalCityRequestStorage = capitalCityRequestStorage;
        this.capitalCityResponseStorage = capitalCityResponseStorage;
    }

    @ApiOperation(value = "Add new rule CapitalCityResponse by countryISOCode")
    @PostMapping("/createRule")
    public void createRule(String code, String city) {
        capitalCityResponseStorage.putInStorage(code, city);
    }

    @ApiOperation(value = "Get all rules for CapitalCityResponse")
    @GetMapping("/showAllRulesCapitalCityResponse")
    public Object showAllCapitalCityResponse() {
        return capitalCityResponseStorage.getResponseStorage();
    }

    @ApiOperation(value = "Get all CapitalCity requests from storage")
    @GetMapping("/showCapitalCityRequestStorage")
    public List<CapitalCity> showRqStorage() {
        return capitalCityRequestStorage.getRequestList();
    }

    @ApiOperation(value = "Remove rules CapitalCity by countryISOCode")
    @DeleteMapping("/clearStorageByCode/{countryISOCode}")
    public void clearStorageByCodee(@PathVariable String countryISOCode) {
        capitalCityResponseStorage.removeRuleById(countryISOCode);
    }

    @ApiOperation(value = "Clear storage CapitalCity (rules + requests)")
    @DeleteMapping("/clearStorage")
    public void clearStorage1() {
        capitalCityRequestStorage.clearRequestStorage();
        capitalCityResponseStorage.clearResponseStorage();
    }

}