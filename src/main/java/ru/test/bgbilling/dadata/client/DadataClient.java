package ru.test.bgbilling.dadata.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.test.bgbilling.dadata.bean.*;
import ru.test.bgbilling.dadata.bean.organization.Organization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * @author sintezwh1te
 */
public class DadataClient {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String BASE_URL = "https://suggestions.dadata.ru/suggestions/api/4_1/rs";
    private static final String DADATA_TOKEN = "Token ";
    private static final String SUGGESTION_PREFIX = "/suggest";
    private static final String FIND_BY_ID_PREFIX = "/findById";

    public DadataClient() {
    }

    public Suggestion<Organization> findOrganizationById(String id) throws JsonProcessingException {
        return findById(SuggestionTypes.ORGANIZATION, new BasicRequest(id)).getSuggestionList().get(0);
    }

    protected <T> DadataResponse<T> findById(SuggestionType<T> suggestionType, BasicRequest request) throws JsonProcessingException {
        return doRequest(suggestionType.getResponseClass(), request, FIND_BY_ID_PREFIX, suggestionType.getSuggestOperationPrefix());
    }

    private <T> DadataResponse<T> doRequest(TypeReference<DadataResponse<T>> responseClass, BasicRequest request, String operationPrefix, String suggestionTypePrefix) throws JsonProcessingException {
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
            connection.setRequestProperty("Authorization", DADATA_TOKEN);
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
            System.err.println(e);
        }
        return objectMapper.readValue(result.toString(), responseClass);
    }
}
