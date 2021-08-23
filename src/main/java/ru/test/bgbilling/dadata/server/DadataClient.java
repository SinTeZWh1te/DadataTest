package ru.test.bgbilling.dadata.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.bitel.bgbilling.server.util.Setup;
import ru.bitel.common.logging.BGNestedContext;
import ru.test.bgbilling.dadata.common.bean.*;
import ru.test.bgbilling.dadata.common.bean.address.Address;
import ru.test.bgbilling.dadata.common.bean.bank.Bank;
import ru.test.bgbilling.dadata.common.bean.organization.Organization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author sintezwh1te
 */
public class DadataClient {
    private static final Logger logger = LogManager.getLogger();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String BASE_URL = "https://suggestions.dadata.ru/suggestions/api/4_1/rs";
    private static String DADATA_TOKEN;
    private static final String SUGGESTION_PREFIX = "/suggest";
    private static final String FIND_BY_ID_PREFIX = "/findById";

    public DadataClient(Setup setup) {
        objectMapper.findAndRegisterModules();
        DADATA_TOKEN = setup.get("dadata.token", "");
    }

    public Suggestion<Organization> findOrganizationById(String id) throws JsonProcessingException {
        return findById(SuggestionTypes.ORGANIZATION, new BasicRequest(id)).getSuggestionList().stream().findFirst().orElse(null);
    }

    public Suggestion<Address> findAddressById(String id) throws JsonProcessingException {
        return findById(SuggestionTypes.ADDRESS, new BasicRequest(id)).getSuggestionList().stream().findFirst().orElse(null);
    }

    public List<Suggestion<Address>> suggestAddress(String value) throws JsonProcessingException {
        return suggest(SuggestionTypes.ADDRESS, new BasicRequest(value)).getSuggestionList();
    }

    public Suggestion<Bank> findBankById(String id) throws JsonProcessingException {
        return findById(SuggestionTypes.BANK, new BasicRequest(id)).getSuggestionList().stream().findFirst().orElse(null);
    }

    protected <T> DadataResponse<T> findById(SuggestionType<T> suggestionType, BasicRequest request) throws JsonProcessingException {
        return doRequest(suggestionType.getResponseClass(), request, FIND_BY_ID_PREFIX, suggestionType.getFindByIdOperationPrefix());
    }

    protected <T> DadataResponse<T> suggest(SuggestionType<T> suggestionType, BasicRequest request) throws JsonProcessingException {
        return doRequest(suggestionType.getResponseClass(), request, SUGGESTION_PREFIX, suggestionType.getSuggestOperationPrefix());
    }

    private <T> DadataResponse<T> doRequest(TypeReference<DadataResponse<T>> responseClass, BasicRequest request, String operationPrefix, String suggestionTypePrefix) throws JsonProcessingException {
        BGNestedContext.push("test");
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(BASE_URL + operationPrefix + suggestionTypePrefix);
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = (HttpURLConnection) urlConnection;
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(5000);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Token " + DADATA_TOKEN);
            connection.setDoOutput(true);

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(objectMapper.writeValueAsString(request).getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            outputStream.close();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getResponseCode() == 200 ? connection.getInputStream() : connection.getErrorStream()));
            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                result.append(inputLine);
            }
            bufferedReader.close();
            connection.disconnect();
        } catch (Exception e) {
            logger.error(e);
        }
        if (logger.isDebugEnabled()) {
            logger.debug(result.toString());
        }
        return objectMapper.readValue(result.toString(), responseClass);
    }
}
