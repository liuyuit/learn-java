package pattern.builder;

import pattern.builder.html.HtmlBuilder;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 *
 * @author liaoxuefeng
 */
public class Main {

    public static void main(String[] args) {
        String markdown = String.join("\n", // Markdown document
                "## Builder Pattern", // heading
                "> Seperate the construction of a complex object from its representation",
                "Use builder pattern when the construction process is complex.", "----", "Here is an example.");
        HtmlBuilder builder = new HtmlBuilder();
        String html = builder.toHtml(markdown);
        System.out.println(html);

        String url = URLBuilder.builder() // 创建Builder
                .setDomain("www.liaoxuefeng.com") // 设置domain
                .setScheme("https") // 设置scheme
                .setPath("/") // 设置路径
                .setQuery(Map.of("a", "123", "q", "K&R")) // 设置query
                .build(); // 完成build
        System.out.println(url);
    }
}


class URLBuilder {

    private String scheme = "http";
    private int port = -1;
    private String domain = null;
    private String path = "/";
    private String username = null;
    private String password = null;
    private Map<String, String> query = null;

    public static URLBuilder builder() {
        return new URLBuilder();
    }

    public String build() {
        StringBuilder sb = new StringBuilder();
        sb.append(scheme).append("://");
        if (username != null && password != null) {
            sb.append(username).append(':').append(password).append('@');
        }
        sb.append(domain);
        if (port >= 0) {
            sb.append(':').append(port);
        }
        sb.append(path);
        if (query != null && !query.isEmpty()) {
            query.forEach((k, v) -> {
                sb.append(k).append('=').append(URLEncoder.encode(v, StandardCharsets.UTF_8));
            });
        }
        return sb.toString();
    }

    public URLBuilder setScheme(String scheme) {
        this.scheme = Objects.requireNonNull(scheme);
        return this;
    }

    public URLBuilder setDomain(String domain) {
        this.domain = Objects.requireNonNull(domain);
        return this;
    }

    public URLBuilder setPath(String path) {
        this.path = Objects.requireNonNull(path);
        return this;
    }

    public URLBuilder setQuery(Map<String, String> query) {
        this.query = query;
        return this;
    }

    public URLBuilder setPort(int port) {
        if (port < 0 || port > 65535) {
            throw new IllegalArgumentException("Invalid port");
        }
        this.port = port;
        return this;
    }

    public URLBuilder setCredential(String username, String password) {
        this.username = Objects.requireNonNull(username);
        this.password = Objects.requireNonNull(password);
        return this;
    }

}