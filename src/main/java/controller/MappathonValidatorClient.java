package controller;

import com.google.gson.Gson;
import model.InputException;
import model.TrainingSet;
import model.ValidationRequest;
import model.ValidationResponse;
import okhttp3.*;

import java.util.ArrayList;

public class MappathonValidatorClient {

    private static final String URL = "https://validate.mappathon.de";
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final String emailRegex = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
    private static final String dataRegex = "\\(S\\.[0-9]*\\_IG\\.[0-9]*\\_I\\.[0-9]*\\)-\\[:(equal|relatedto|equivalent|narrower|wider)\\]->\\(S\\.[0-9]*\\_IG\\.[0-9]*\\_I\\.[0-9]*\\)";

    private static MappathonValidatorClient instance;

    private MappathonValidatorClient(){}

    public static MappathonValidatorClient getInstance() {
        if (MappathonValidatorClient.instance == null) {
            MappathonValidatorClient.instance = new MappathonValidatorClient();
        }
        return MappathonValidatorClient.instance;
    }

    public ValidationResponse validate(String email, TrainingSet name, ArrayList<String> data) throws InputException {

        if (!email.matches(emailRegex)) {
            throw new InputException("email is not valid");
        }

        for (String s : data) {
            if (!s.matches(dataRegex)) {
                throw new InputException("Syntax error on " + s);
            }
        }

        ValidationRequest valReq = new ValidationRequest();
        valReq.setEmail(email);
        valReq.setDataset(name.toString());
        valReq.setData(data);

        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, gson.toJson(valReq));
        Request request = new Request.Builder().url(URL).post(body).build();
        ValidationResponse valRes = null;

        try {
            Response response = client.newCall(request).execute();
            valRes = gson.fromJson(response.body().string(), ValidationResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Validation Service temporally unavailable");
        }
        return valRes;
    }
}





