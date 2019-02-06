package model;

import java.util.ArrayList;

public class ValidationRequest {

    String email;
    String dataset;
    ArrayList<String> data;

    public ValidationRequest() {
    }

    public ValidationRequest(String email, ArrayList<String> data) {
        this.email = email;
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

    public ArrayList<String> getData() {
        return data;
    }
    public void setData(ArrayList<String> data) {
        this.data = data;
    }
}
