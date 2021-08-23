package ru.test.bgbilling.dadata.common.bean.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.test.bgbilling.dadata.common.bean.AdditionalProperties;

import java.time.ZoneId;
import java.util.List;

/**
 * @author sintezwh1te
 */
public class Address extends AdditionalProperties {
    @JsonProperty("postal_code")
    String postalCode;
    String country;
    @JsonProperty("country_iso_code")
    String countryIsoCode;
    @JsonProperty("federal_district")
    String federalDistrict;
    @JsonProperty("region_fias_id")
    String regionFiasId;
    @JsonProperty("region_kladr_id")
    String regionKladrId;
    @JsonProperty("region_iso_code")
    String regionIsoCode;
    @JsonProperty("region_with_type")
    String regionWithType;
    @JsonProperty("region_type")
    String regionType;
    @JsonProperty("region_type_full")
    String regionTypeFull;
    String region;
    @JsonProperty("area_fias_id")
    String areaFiasId;
    @JsonProperty("area_kladr_id")
    String areaKladrId;
    @JsonProperty("area_with_type")
    String areaWithType;
    @JsonProperty("area_type")
    String areaType;
    @JsonProperty("area_type_full")
    String areaTypeFull;
    String area;
    @JsonProperty("city_fias_id")
    String cityFiasId;
    @JsonProperty("city_kladr_id")
    String cityKladrId;
    @JsonProperty("city_with_type")
    String cityWithType;
    @JsonProperty("city_type")
    String cityType;
    @JsonProperty("city_type_full")
    String cityTypeFull;
    String city;
    @JsonProperty("city_area")
    String cityArea;
    @JsonProperty("city_district_fias_id")
    String cityDistrictFiasId;
    @JsonProperty("city_district_kladr_id")
    String cityDistrictKladrId;
    @JsonProperty("city_district_with_type")
    String cityDistrictWithType;
    @JsonProperty("city_district_type")
    String cityDistrictType;
    @JsonProperty("city_district_type_full")
    String cityDistrictTypeFull;
    @JsonProperty("city_district")
    String cityDistrict;
    @JsonProperty("settlement_fias_id")
    String settlementFiasId;
    @JsonProperty("settlement_kladr_id")
    String settlementKladrId;
    @JsonProperty("settlement_with_type")
    String settlementWithType;
    @JsonProperty("settlement_type")
    String settlementType;
    @JsonProperty("settlement_type_full")
    String settlementTypeFull;
    String settlement;
    @JsonProperty("street_fias_id")
    String streetFiasId;
    @JsonProperty("street_kladr_id")
    String streetKladrId;
    @JsonProperty("street_with_type")
    String streetWithType;
    @JsonProperty("street_type")
    String streetType;
    @JsonProperty("street_type_full")
    String streetTypeFull;
    String street;
    @JsonProperty("house_fias_id")
    String houseFiasId;
    @JsonProperty("house_kladr_id")
    String houseKladrId;
    @JsonProperty("house_type")
    String houseType;
    @JsonProperty("house_type_full")
    String houseTypeFull;
    String house;
    @JsonProperty("block_type")
    String blockType;
    @JsonProperty("block_type_full")
    String blockTypeFull;
    String block;
    @JsonProperty("flat_type")
    String flatType;
    @JsonProperty("flat_type_full")
    String flatTypeFull;
    String flat;
    @JsonProperty("flat_area")
    Double flatArea;
    @JsonProperty("square_meter_price")
    Double squareMeterPrice;
    @JsonProperty("flat_price")
    Double flatPrice;
    @JsonProperty("postal_box")
    String postalBox;
    @JsonProperty("fias_id")
    String fiasId;
    @JsonProperty("fias_code")
    String fiasCode;
    @JsonProperty("fias_level")
    String fiasLevel;
    @JsonProperty("fias_actuality_state")
    String fiasActualityState;
    @JsonProperty("kladr_id")
    String kladrId;
    @JsonProperty("geoname_id")
    String geonameId;
    @JsonProperty("capital_marker")
    String capitalMarker;
    String okato;
    String oktmo;
    @JsonProperty("tax_office")
    String taxOffice;
    @JsonProperty("tax_office_legal")
    String taxOfficeLegal;
    ZoneId timezone;
    @JsonProperty("geo_lat")
    Double geoLat;
    @JsonProperty("geo_lon")
    Double geoLon;
    @JsonProperty("beltway_hit")
    String beltwayHit;
    @JsonProperty("beltway_distance")
    Double beltwayDistance;
    List<Metro> metro;
    @JsonProperty("qc_geo")
    String qcGeo;
    @JsonProperty("qc_complete")
    String qcComplete;
    @JsonProperty("qc_house")
    String qcHouse;
    @JsonProperty("history_values")
    List<String> historyValues;
    @JsonProperty("unparsed_parts")
    String unparsedParts;
    String source;
    String qc;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    public String getFederalDistrict() {
        return federalDistrict;
    }

    public void setFederalDistrict(String federalDistrict) {
        this.federalDistrict = federalDistrict;
    }

    public String getRegionFiasId() {
        return regionFiasId;
    }

    public void setRegionFiasId(String regionFiasId) {
        this.regionFiasId = regionFiasId;
    }

    public String getRegionKladrId() {
        return regionKladrId;
    }

    public void setRegionKladrId(String regionKladrId) {
        this.regionKladrId = regionKladrId;
    }

    public String getRegionIsoCode() {
        return regionIsoCode;
    }

    public void setRegionIsoCode(String regionIsoCode) {
        this.regionIsoCode = regionIsoCode;
    }

    public String getRegionWithType() {
        return regionWithType;
    }

    public void setRegionWithType(String regionWithType) {
        this.regionWithType = regionWithType;
    }

    public String getRegionType() {
        return regionType;
    }

    public void setRegionType(String regionType) {
        this.regionType = regionType;
    }

    public String getRegionTypeFull() {
        return regionTypeFull;
    }

    public void setRegionTypeFull(String regionTypeFull) {
        this.regionTypeFull = regionTypeFull;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAreaFiasId() {
        return areaFiasId;
    }

    public void setAreaFiasId(String areaFiasId) {
        this.areaFiasId = areaFiasId;
    }

    public String getAreaKladrId() {
        return areaKladrId;
    }

    public void setAreaKladrId(String areaKladrId) {
        this.areaKladrId = areaKladrId;
    }

    public String getAreaWithType() {
        return areaWithType;
    }

    public void setAreaWithType(String areaWithType) {
        this.areaWithType = areaWithType;
    }

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public String getAreaTypeFull() {
        return areaTypeFull;
    }

    public void setAreaTypeFull(String areaTypeFull) {
        this.areaTypeFull = areaTypeFull;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCityFiasId() {
        return cityFiasId;
    }

    public void setCityFiasId(String cityFiasId) {
        this.cityFiasId = cityFiasId;
    }

    public String getCityKladrId() {
        return cityKladrId;
    }

    public void setCityKladrId(String cityKladrId) {
        this.cityKladrId = cityKladrId;
    }

    public String getCityWithType() {
        return cityWithType;
    }

    public void setCityWithType(String cityWithType) {
        this.cityWithType = cityWithType;
    }

    public String getCityType() {
        return cityType;
    }

    public void setCityType(String cityType) {
        this.cityType = cityType;
    }

    public String getCityTypeFull() {
        return cityTypeFull;
    }

    public void setCityTypeFull(String cityTypeFull) {
        this.cityTypeFull = cityTypeFull;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityArea() {
        return cityArea;
    }

    public void setCityArea(String cityArea) {
        this.cityArea = cityArea;
    }

    public String getCityDistrictFiasId() {
        return cityDistrictFiasId;
    }

    public void setCityDistrictFiasId(String cityDistrictFiasId) {
        this.cityDistrictFiasId = cityDistrictFiasId;
    }

    public String getCityDistrictKladrId() {
        return cityDistrictKladrId;
    }

    public void setCityDistrictKladrId(String cityDistrictKladrId) {
        this.cityDistrictKladrId = cityDistrictKladrId;
    }

    public String getCityDistrictWithType() {
        return cityDistrictWithType;
    }

    public void setCityDistrictWithType(String cityDistrictWithType) {
        this.cityDistrictWithType = cityDistrictWithType;
    }

    public String getCityDistrictType() {
        return cityDistrictType;
    }

    public void setCityDistrictType(String cityDistrictType) {
        this.cityDistrictType = cityDistrictType;
    }

    public String getCityDistrictTypeFull() {
        return cityDistrictTypeFull;
    }

    public void setCityDistrictTypeFull(String cityDistrictTypeFull) {
        this.cityDistrictTypeFull = cityDistrictTypeFull;
    }

    public String getCityDistrict() {
        return cityDistrict;
    }

    public void setCityDistrict(String cityDistrict) {
        this.cityDistrict = cityDistrict;
    }

    public String getSettlementFiasId() {
        return settlementFiasId;
    }

    public void setSettlementFiasId(String settlementFiasId) {
        this.settlementFiasId = settlementFiasId;
    }

    public String getSettlementKladrId() {
        return settlementKladrId;
    }

    public void setSettlementKladrId(String settlementKladrId) {
        this.settlementKladrId = settlementKladrId;
    }

    public String getSettlementWithType() {
        return settlementWithType;
    }

    public void setSettlementWithType(String settlementWithType) {
        this.settlementWithType = settlementWithType;
    }

    public String getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType;
    }

    public String getSettlementTypeFull() {
        return settlementTypeFull;
    }

    public void setSettlementTypeFull(String settlementTypeFull) {
        this.settlementTypeFull = settlementTypeFull;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public String getStreetFiasId() {
        return streetFiasId;
    }

    public void setStreetFiasId(String streetFiasId) {
        this.streetFiasId = streetFiasId;
    }

    public String getStreetKladrId() {
        return streetKladrId;
    }

    public void setStreetKladrId(String streetKladrId) {
        this.streetKladrId = streetKladrId;
    }

    public String getStreetWithType() {
        return streetWithType;
    }

    public void setStreetWithType(String streetWithType) {
        this.streetWithType = streetWithType;
    }

    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    public String getStreetTypeFull() {
        return streetTypeFull;
    }

    public void setStreetTypeFull(String streetTypeFull) {
        this.streetTypeFull = streetTypeFull;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseFiasId() {
        return houseFiasId;
    }

    public void setHouseFiasId(String houseFiasId) {
        this.houseFiasId = houseFiasId;
    }

    public String getHouseKladrId() {
        return houseKladrId;
    }

    public void setHouseKladrId(String houseKladrId) {
        this.houseKladrId = houseKladrId;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getHouseTypeFull() {
        return houseTypeFull;
    }

    public void setHouseTypeFull(String houseTypeFull) {
        this.houseTypeFull = houseTypeFull;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getBlockType() {
        return blockType;
    }

    public void setBlockType(String blockType) {
        this.blockType = blockType;
    }

    public String getBlockTypeFull() {
        return blockTypeFull;
    }

    public void setBlockTypeFull(String blockTypeFull) {
        this.blockTypeFull = blockTypeFull;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getFlatType() {
        return flatType;
    }

    public void setFlatType(String flatType) {
        this.flatType = flatType;
    }

    public String getFlatTypeFull() {
        return flatTypeFull;
    }

    public void setFlatTypeFull(String flatTypeFull) {
        this.flatTypeFull = flatTypeFull;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public Double getFlatArea() {
        return flatArea;
    }

    public void setFlatArea(Double flatArea) {
        this.flatArea = flatArea;
    }

    public Double getSquareMeterPrice() {
        return squareMeterPrice;
    }

    public void setSquareMeterPrice(Double squareMeterPrice) {
        this.squareMeterPrice = squareMeterPrice;
    }

    public Double getFlatPrice() {
        return flatPrice;
    }

    public void setFlatPrice(Double flatPrice) {
        this.flatPrice = flatPrice;
    }

    public String getPostalBox() {
        return postalBox;
    }

    public void setPostalBox(String postalBox) {
        this.postalBox = postalBox;
    }

    public String getFiasId() {
        return fiasId;
    }

    public void setFiasId(String fiasId) {
        this.fiasId = fiasId;
    }

    public String getFiasCode() {
        return fiasCode;
    }

    public void setFiasCode(String fiasCode) {
        this.fiasCode = fiasCode;
    }

    public String getFiasLevel() {
        return fiasLevel;
    }

    public void setFiasLevel(String fiasLevel) {
        this.fiasLevel = fiasLevel;
    }

    public String getFiasActualityState() {
        return fiasActualityState;
    }

    public void setFiasActualityState(String fiasActualityState) {
        this.fiasActualityState = fiasActualityState;
    }

    public String getKladrId() {
        return kladrId;
    }

    public void setKladrId(String kladrId) {
        this.kladrId = kladrId;
    }

    public String getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(String geonameId) {
        this.geonameId = geonameId;
    }

    public String getCapitalMarker() {
        return capitalMarker;
    }

    public void setCapitalMarker(String capitalMarker) {
        this.capitalMarker = capitalMarker;
    }

    public String getOkato() {
        return okato;
    }

    public void setOkato(String okato) {
        this.okato = okato;
    }

    public String getOktmo() {
        return oktmo;
    }

    public void setOktmo(String oktmo) {
        this.oktmo = oktmo;
    }

    public String getTaxOffice() {
        return taxOffice;
    }

    public void setTaxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
    }

    public String getTaxOfficeLegal() {
        return taxOfficeLegal;
    }

    public void setTaxOfficeLegal(String taxOfficeLegal) {
        this.taxOfficeLegal = taxOfficeLegal;
    }

    public ZoneId getTimezone() {
        return timezone;
    }

    public void setTimezone(ZoneId timezone) {
        this.timezone = timezone;
    }

    public Double getGeoLat() {
        return geoLat;
    }

    public void setGeoLat(Double geoLat) {
        this.geoLat = geoLat;
    }

    public Double getGeoLon() {
        return geoLon;
    }

    public void setGeoLon(Double geoLon) {
        this.geoLon = geoLon;
    }

    public String getBeltwayHit() {
        return beltwayHit;
    }

    public void setBeltwayHit(String beltwayHit) {
        this.beltwayHit = beltwayHit;
    }

    public Double getBeltwayDistance() {
        return beltwayDistance;
    }

    public void setBeltwayDistance(Double beltwayDistance) {
        this.beltwayDistance = beltwayDistance;
    }

    public List<Metro> getMetro() {
        return metro;
    }

    public void setMetro(List<Metro> metro) {
        this.metro = metro;
    }

    public String getQcGeo() {
        return qcGeo;
    }

    public void setQcGeo(String qcGeo) {
        this.qcGeo = qcGeo;
    }

    public String getQcComplete() {
        return qcComplete;
    }

    public void setQcComplete(String qcComplete) {
        this.qcComplete = qcComplete;
    }

    public String getQcHouse() {
        return qcHouse;
    }

    public void setQcHouse(String qcHouse) {
        this.qcHouse = qcHouse;
    }

    public List<String> getHistoryValues() {
        return historyValues;
    }

    public void setHistoryValues(List<String> historyValues) {
        this.historyValues = historyValues;
    }

    public String getUnparsedParts() {
        return unparsedParts;
    }

    public void setUnparsedParts(String unparsedParts) {
        this.unparsedParts = unparsedParts;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getQc() {
        return qc;
    }

    public void setQc(String qc) {
        this.qc = qc;
    }

    public static class Metro {
        private String name;
        private String line;
        private Double distance;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLine() {
            return line;
        }

        public void setLine(String line) {
            this.line = line;
        }

        public Double getDistance() {
            return distance;
        }

        public void setDistance(Double distance) {
            this.distance = distance;
        }
    }

    @Override
    public String toString() {
        return "Address{" +
                "postalCode='" + postalCode + '\'' + '\n' +
                ", country='" + country + '\'' + '\n' +
                ", countryIsoCode='" + countryIsoCode + '\'' + '\n' +
                ", federalDistrict='" + federalDistrict + '\'' + '\n' +
                ", regionFiasId='" + regionFiasId + '\'' + '\n' +
                ", regionKladrId='" + regionKladrId + '\'' + '\n' +
                ", regionIsoCode='" + regionIsoCode + '\'' + '\n' +
                ", regionWithType='" + regionWithType + '\'' + '\n' +
                ", regionType='" + regionType + '\'' + '\n' +
                ", regionTypeFull='" + regionTypeFull + '\'' + '\n' +
                ", region='" + region + '\'' + '\n' +
                ", areaFiasId='" + areaFiasId + '\'' + '\n' +
                ", areaKladrId='" + areaKladrId + '\'' + '\n' +
                ", areaWithType='" + areaWithType + '\'' + '\n' +
                ", areaType='" + areaType + '\'' + '\n' +
                ", areaTypeFull='" + areaTypeFull + '\'' + '\n' +
                ", area='" + area + '\'' + '\n' +
                ", cityFiasId='" + cityFiasId + '\'' + '\n' +
                ", cityKladrId='" + cityKladrId + '\'' + '\n' +
                ", cityWithType='" + cityWithType + '\'' + '\n' +
                ", cityType='" + cityType + '\'' + '\n' +
                ", cityTypeFull='" + cityTypeFull + '\'' + '\n' +
                ", city='" + city + '\'' + '\n' +
                ", cityArea='" + cityArea + '\'' + '\n' +
                ", cityDistrictFiasId='" + cityDistrictFiasId + '\'' + '\n' +
                ", cityDistrictKladrId='" + cityDistrictKladrId + '\'' + '\n' +
                ", cityDistrictWithType='" + cityDistrictWithType + '\'' + '\n' +
                ", cityDistrictType='" + cityDistrictType + '\'' + '\n' +
                ", cityDistrictTypeFull='" + cityDistrictTypeFull + '\'' + '\n' +
                ", cityDistrict='" + cityDistrict + '\'' + '\n' +
                ", settlementFiasId='" + settlementFiasId + '\'' + '\n' +
                ", settlementKladrId='" + settlementKladrId + '\'' + '\n' +
                ", settlementWithType='" + settlementWithType + '\'' + '\n' +
                ", settlementType='" + settlementType + '\'' + '\n' +
                ", settlementTypeFull='" + settlementTypeFull + '\'' + '\n' +
                ", settlement='" + settlement + '\'' + '\n' +
                ", streetFiasId='" + streetFiasId + '\'' + '\n' +
                ", streetKladrId='" + streetKladrId + '\'' + '\n' +
                ", streetWithType='" + streetWithType + '\'' + '\n' +
                ", streetType='" + streetType + '\'' + '\n' +
                ", streetTypeFull='" + streetTypeFull + '\'' + '\n' +
                ", street='" + street + '\'' + '\n' +
                ", houseFiasId='" + houseFiasId + '\'' + '\n' +
                ", houseKladrId='" + houseKladrId + '\'' + '\n' +
                ", houseType='" + houseType + '\'' + '\n' +
                ", houseTypeFull='" + houseTypeFull + '\'' + '\n' +
                ", house='" + house + '\'' + '\n' +
                ", blockType='" + blockType + '\'' + '\n' +
                ", blockTypeFull='" + blockTypeFull + '\'' + '\n' +
                ", block='" + block + '\'' + '\n' +
                ", flatType='" + flatType + '\'' + '\n' +
                ", flatTypeFull='" + flatTypeFull + '\'' + '\n' +
                ", flat='" + flat + '\'' + '\n' +
                ", flatArea=" + flatArea +
                ", squareMeterPrice=" + squareMeterPrice +
                ", flatPrice=" + flatPrice +
                ", postalBox='" + postalBox + '\'' + '\n' +
                ", fiasId='" + fiasId + '\'' + '\n' +
                ", fiasCode='" + fiasCode + '\'' + '\n' +
                ", fiasLevel='" + fiasLevel + '\'' + '\n' +
                ", fiasActualityState='" + fiasActualityState + '\'' + '\n' +
                ", kladrId='" + kladrId + '\'' + '\n' +
                ", geonameId='" + geonameId + '\'' + '\n' +
                ", capitalMarker='" + capitalMarker + '\'' + '\n' +
                ", okato='" + okato + '\'' + '\n' +
                ", oktmo='" + oktmo + '\'' + '\n' +
                ", taxOffice='" + taxOffice + '\'' + '\n' +
                ", taxOfficeLegal='" + taxOfficeLegal + '\'' + '\n' +
                ", timezone=" + timezone +
                ", geoLat=" + geoLat +
                ", geoLon=" + geoLon +
                ", beltwayHit='" + beltwayHit + '\'' + '\n' +
                ", beltwayDistance=" + beltwayDistance +
                ", metro=" + metro +
                ", qcGeo='" + qcGeo + '\'' + '\n' +
                ", qcComplete='" + qcComplete + '\'' + '\n' +
                ", qcHouse='" + qcHouse + '\'' + '\n' +
                ", historyValues=" + historyValues +
                ", unparsedParts='" + unparsedParts + '\'' + '\n' +
                ", source='" + source + '\'' + '\n' +
                ", qc='" + qc + '\'' + '\n' +
                '}';
    }
}
