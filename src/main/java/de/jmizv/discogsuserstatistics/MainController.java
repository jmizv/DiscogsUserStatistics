package de.jmizv.discogsuserstatistics;


import de.jmizv.discogsuserstatistics.model.StatTask;
import de.jmizv.discogsuserstatistics.service.StatTaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

  private final StatTaskService _statTaskService;

  public MainController(StatTaskService statTaskService) {
    _statTaskService = statTaskService;
  }

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/stat")
  public String stat(ModelMap modelMap) {
    modelMap.addAttribute("stats", _statTaskService.getAll());
    return "stat";
  }

  @GetMapping("/success")
  public String success() {
    return "success";
  }

  @GetMapping("/current-state")
  public String currentState(@RequestParam("username") String username, ModelMap modelMap) {
    modelMap.addAttribute("username", username);
    return "current-state";
  }

  @PostMapping(value = "/create-task", consumes = {"*/*"})
  public String createTask(@RequestParam String username) {
    var task = _statTaskService.getByUsername(username);
    if (task.isEmpty()) {
      _statTaskService.createForUsername(username);
      return "redirect:/success";
    }
    var finishDate = task.map(StatTask::getFinishedDate);
    if (finishDate.isEmpty()) {
      return "redirect:/success";
    }
    return "redirect:/user-stat";
  }
}
