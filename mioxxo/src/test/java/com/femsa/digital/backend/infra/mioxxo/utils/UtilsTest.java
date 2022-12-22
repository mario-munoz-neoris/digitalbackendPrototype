package com.femsa.digital.backend.infra.mioxxo.utils;

import com.femsa.digital.backend.domain.ports.app.dto.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class UtilsTest {

    public static ApiResponseOperatorsDTO createResponseOperatorsDTO(){
        ApiResponseOperatorsDTO data = new ApiResponseOperatorsDTO();

        List<OperatorsDTO> operators = new ArrayList<>();
        OperatorsDTO operator = new OperatorsDTO();
        MetaDataResponse metadata = new MetaDataResponse();

        operator.setId("5e20942257f73e79499e36ae");
        operator.setImage("https://mioxxo.imgix.net/services/img/tae/40.png?fit=fillmax&fill=solid&w=500&h=500");
        operator.setName("OXXO CEL");
        operator.setCompany("OXXO CEL");
        operator.setType("carrier");
        operator.setHasPackages(false);

        operators.add(operator);

        metadata.setPage(1);
        metadata.setPer_page(10);
        metadata.setTotal(14);
        metadata.setTotal_pages(2);

        data.setOperators(operators);
        data.setStatus("success");
        data.setMetadata(metadata);

        return data;
    }

    public static ApiResponseOperatorDTO createResponseOperatorDTO(){
        ApiResponseOperatorDTO data = new ApiResponseOperatorDTO();

        OperatorDTO operator = new OperatorDTO();
        List<SectionDTO> sections = new ArrayList<>();
        List<ItemDTO> items = new ArrayList<>();
        List<PerksDTO> perks = new ArrayList<>();
        List<AppPerkDTO> apps_perks = new ArrayList<>();
        List<String> services = new ArrayList<>();

        SectionDTO section = new SectionDTO();
        ItemDTO item = new ItemDTO();
        PerksDTO perk = new PerksDTO();
        AppPerkDTO apps_perk = new AppPerkDTO();

        MetaDataResponse metadata = new MetaDataResponse();

        services.add("Facebook");
        services.add("Messenger");

        apps_perk.setLabel("+ limitado");
        apps_perk.setServices(services);
        apps_perks.add(apps_perk);

        perk.setExpired("30 días");
        perk.setLegend("recommended");
        perk.setMegas("6 GB");
        perk.setSku("7502271153766");
        perk.setItem_id(null);
        perk.setApps_perks(apps_perks);
        perks.add(perk);

        item.setId("5c09685eaecd2e2405a1af77");
        item.setName("Paquete amigo sin límite $500");
        item.setDescription("PAQUETE AMIGO SIN LIMITE $500");
        item.setAmount(1000L);
        item.setTitle("$500");
        item.setPerks(perks);
        items.add(item);

        section.setType("internet");
        section.setName("Internet Telcel");
        section.setImage("https://mioxxo.imgix.net/services/img/tae/1.png");
        section.setTitle("Plan de datos");
        section.setItems(items);
        sections.add(section);

        operator.setId("5bb6683481c14c14ee2f531d");
        operator.setImage("https://mioxxo.imgix.net/services/img/tae/1.png");
        operator.setName("Telcel");
        operator.setCompany("TELCEL");
        operator.setType("carrier");
        operator.setHasPackages(false);
        operator.setSections(sections);

        metadata.setPage(1);
        metadata.setPer_page(10);
        metadata.setTotal(14);
        metadata.setTotal_pages(2);

        data.setOperators(operator);
        data.setStatus("success");
        data.setMetadata(metadata);

        return data;
    }

    public static ResponseEntity<ApiResponseOperatorsDTO> createResponseEntity(){

        return ResponseEntity.ok().body(createResponseOperatorsDTO());
    }

    public static ResponseEntity<ApiResponseOperatorDTO> createResponseEntityOperator(){
        return ResponseEntity.ok().body(createResponseOperatorDTO());
    }

    public static ResponseEntity<ApiResponseOperatorsDTO> createResponseEntityError(){

        return ResponseEntity.status(401).body(null);
    }
}
