package playground.cheeseblossom.api.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import playground.cheeseblossom.api.http.request.sample.SampleRequestDto;
import playground.cheeseblossom.api.service.SampleService;

@Controller
@RequiredArgsConstructor
public class SampleController {

  private final SampleService sampleService;

  @GetMapping("/")
  public ModelAndView index(@ModelAttribute("sample") SampleRequestDto requestDto) {
    ModelAndView mv = new ModelAndView("index");
    return mv;
  }

  @GetMapping("/change")
  public String change() {
    return "change";
  }

  @GetMapping("/remove")
  public String remove() {
    return "remove";
  }

  @GetMapping("/rremove")
  public String realRemove() {
    return "rremove";
  }
}
