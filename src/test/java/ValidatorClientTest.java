import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import controller.MappathonValidatorClient;
import model.TrainingSet;
import model.ValidationResponse;

public class ValidatorClientTest {

	@Test
	public void test() {

		String email = "hannes.ulrich@itcr.uni-luebeck.de";
		ArrayList<String> data = new ArrayList<String>();

		data.add("(S.0011_IG.4_I.18)-[:equivalent]->(S.0021_IG.1_I.4)");
		data.add("(S.0011_IG.4_I.20)-[:equivalent]->(S.0021_IG.1_I.1)");

		MappathonValidatorClient client = MappathonValidatorClient.getInstance();
		ValidationResponse res = null;
		try {
			res = client.validate(email, TrainingSet.TS1, data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(-2.0, res.getMappathonScore(), 0);
	}

}
