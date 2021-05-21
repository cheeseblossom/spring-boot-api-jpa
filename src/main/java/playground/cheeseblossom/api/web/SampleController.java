package playground.cheeseblossom.api.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import playground.cheeseblossom.api.service.SampleService;

@Controller
@RequiredArgsConstructor
public class SampleController {

  private final SampleService sampleService;

  @GetMapping("/")
  public ModelAndView index() {
    ModelAndView mv = new ModelAndView("index");
    return mv;
  }
}
