package at.refugeescode.kapsh_http_server_mockup;

import org.springframework.stereotype.Service;

@Service
public class RequestJson {

    private String path;
    private String content;
    private Integer state;

    public RequestJson() {

    }

    public RequestJson(String path, String content) {
        this.path = path;
        this.content = content;
    }

    public RequestJson(String path, Integer state) {
        this.path = path;
        this.state = state;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "RequestJson{" +
                "path='" + path + '\'' +
                ", content='" + content + '\'' +
                ", state=" + state +
                '}';
    }
}
