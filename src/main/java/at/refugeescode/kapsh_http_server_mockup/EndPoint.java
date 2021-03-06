package at.refugeescode.kapsh_http_server_mockup;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/")
public class EndPoint {

    private RequestJson requestJson;
    private Set <String> listPath = new HashSet<>() ;
    private String url = "?key=value";
    //private RestTemplate restTemplate;
    List<RequestJson> requestJsonLists = new ArrayList<>();
    private Set<String> setJson = new HashSet<>();


    public EndPoint(RequestJson requestJson) {
        this.requestJson = requestJson;
        //this.restTemplate = restTemplate;
    }


    @GetMapping
    public String get() {

        return "hi first";
    }

    @GetMapping("/protocol")
    public String protocol(){

        return "Response: 200 :"+ setJson;
    }

    @GetMapping("/{path}/{content}")
    String get(@PathVariable String path,@PathVariable String content) {
        String pathRes = setJson.stream()
                .filter(element -> element.contains(path))
                .filter(element -> element.contains(content))
                .findFirst().toString();
        if (pathRes.equalsIgnoreCase("Optional.empty"))
            return "Response: 404";
        else
            return "Response: 200:" +pathRes;

    }



    @PostMapping("/set_response")
    public String post(@RequestBody RequestJson request) {
        if (request.getPath() != null) {
            listPath.add(request.getPath());
            if (request.getState() != null) {
                if(request.getContent() != null){
                    setJson.add(request.toString());
                    return "Response: 200 ";
                }else{
                    setJson.add(request.toString());
                    return "Response: 200";
                }
            }else{
                setJson.add(request.toString());
                return "Response: 200 ";
            }
        }
        else {
            return "Response: 400 ";
        }

    }


}
