// package test.java.org.snakeinc.server;
// import static org.junit.jupiter.api.Assertions.assertEquals;

// import java.beans.Transient;

// import java.util.List;
// import java.sql.SQLNonTransientConnectionException;
// import java.util.ArrayList;

// import org.junit.jupiter.api.Test;
// import main.java.org.snakeinc.server.model.StatBody;
// import main.java.org.snakeinc.server.model.ScoreEntity;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.web.client.TestRestTemplate;
// import org.springframework.http.ResponseEntity;
// import org.springframework.test.context.ActiveProfiles;
// import org.springframework.http.HttpServletResponse;

// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @ActiveProfiles("test")
// public class ScoreIntegrationTest {
//     @Autowired
//     TestRestTemplate testRestTemplate;

//     @Test 
//     void basic_test(){
//         List<ScoreEntity> response = testRestTemplate.getForEntity("/api/v1/scores", ScoreEntity[].class);
//         assertEquals(response.getStatusCode(), org.springframework.http.HttpServletResponse.valueOf(200));
//         List<ScoreEntity> body = response.getBody();
//         assertEquals(1, body.length);
//     }
// }
