package model;

public class ValidationResponse {

    double zeroOneLoss;
    double mappathonScore;

    public ValidationResponse() {
    }

    public double getZeroOneLoss() {
        return zeroOneLoss;
    }
    public void setZeroOneLoss(double zeroOneLoss) {
        this.zeroOneLoss = zeroOneLoss;
    }
    public double getMappathonScore() {
        return mappathonScore;
    }
    public void setMappathonScore(double mappathonScore) {
        this.mappathonScore = mappathonScore;
    }

    @Override
    public String toString() {
        return "1/0-Loss: " + String.valueOf(zeroOneLoss) + "\n" + "Mappathon Score: " + String.valueOf(mappathonScore);
    }
}
