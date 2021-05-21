package playground.cheeseblossom.api.test.sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import playground.cheeseblossom.api.domain.Sample;
import playground.cheeseblossom.api.domain.SampleRepository;
import playground.cheeseblossom.api.http.request.sample.SampleRequestDto;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleApiControllerTest {

  @Autowired
  private WebApplicationContext context;

  @Autowired
  private SampleRepository sampleRepository;

  private MockMvc mvc;

  @BeforeEach
  public void setup() {
    mvc = MockMvcBuilders
            .webAppContextSetup(context)
            .build();
  }

  @AfterEach
  public void cleanup() {
    sampleRepository.deleteAll();
  }

  @Test
  public void get_test() throws Exception {
    // given
    String text = "sp text";
    Sample s = sampleRepository.save(Sample.builder()
            .text(text)
            .build());
    String url = "/api/list";

    SampleRequestDto requestDto = SampleRequestDto.builder()
            .text(text)
            .build();

    // when
    mvc.perform(MockMvcRequestBuilders
            .get(url)
            .content(new ObjectMapper().writeValueAsString(requestDto))
    )
            .andExpect(status().isOk());

    // then
    List<Sample> list = sampleRepository.findAll();
    then(list.get(0).getText()).isEqualTo(text);
  }

  @Test
  public void post_test() throws Exception {
    // given
    String text = "sp text";
    String url = "/api/save";

    SampleRequestDto requestDto = SampleRequestDto.builder()
            .text(text)
            .build();

    // when
    mvc.perform(MockMvcRequestBuilders
            .post(url)
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(requestDto))
    )
            .andExpect(status().isOk());

    // then
    List<Sample> list = sampleRepository.findAll();
    then(list.get(0).getText()).isEqualTo(text);
  }

  @Test
  public void put_test() throws Exception {
    // given
    String text = "sp text";
    Sample s = sampleRepository.save(Sample.builder()
            .text(text)
            .build());
    String next = "sp text2";
    String url = "/api/change";

    SampleRequestDto requestDto = SampleRequestDto.builder()
            .idx(s.getIdx())
            .text(next)
            .build();

    // when
    mvc.perform(MockMvcRequestBuilders
            .put(url)
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(requestDto))
    )
            .andExpect(status().isOk());

    // then
    List<Sample> list = sampleRepository.findAll();
    then(list.get(0).getText()).isEqualTo(next);
  }

  @Test
  public void delete_test() throws Exception {
    // given
    String text = "sp text";
    Sample s = sampleRepository.save(Sample.builder()
            .text(text)
            .build());
    String url = "/api/remove";
    String result = "Y";

    SampleRequestDto requestDto = SampleRequestDto.builder()
            .idx(s.getIdx())
            .build();

    // when
    mvc.perform(MockMvcRequestBuilders
            .delete(url)
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(requestDto))
    )
            .andExpect(status().isOk());

    // then
    List<Sample> list = sampleRepository.findAll();
    then(list.get(0).getDelYn()).isEqualTo(result);
  }

  @Test
  public void realDelete_test() throws Exception {
    // given
    String text = "sp text";
    Sample s = sampleRepository.save(Sample.builder()
            .text(text)
            .build());
    String url = "/api/rremove";

    SampleRequestDto requestDto = SampleRequestDto.builder()
            .idx(s.getIdx())
            .build();

    // when
    mvc.perform(MockMvcRequestBuilders
            .delete(url)
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(requestDto))
    )
            .andExpect(status().isOk());

    // then
    List<Sample> list = sampleRepository.findAll();
    then(list.size()).isEqualTo(0);
  }
}
