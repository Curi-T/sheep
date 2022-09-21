package t;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author CuriT
 * @Date 2022-9-21 12:38
 */
public class Sheep {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("CuriT");
        System.out.println("单线程，自己随便刷一刷就可以了，\n没必要刷太多，影响人家的服务器运行");
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入t值并回车：");
        String t_value = scanner.nextLine();
        System.out.println("输入次数并回车：");
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            setSheep(t_value, i);
        }
    }

    public static void setSheep(String t_value, int i) throws InterruptedException {
        i++;
        String result = "";
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            String httpUrl = "https://cat-match.easygame2021.com/sheep/v1/game/update_user_skin?skin=1";
            HttpGet request = new HttpGet(httpUrl);
            // 自定义请求头。例如在请求头中添加 jwt-token
            request.setHeader("Host", "cat-match.easygame2021.com");
            Random r = new Random();Thread.sleep(300+r.nextInt(800));
            request.setHeader("Connection", "keep-alive");
            request.setHeader("xweb_xhr", "1");
            request.setHeader("t", t_value);
            request.setHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36 MicroMessenger/7.0.4.501 NetType/WIFI MiniProgramEnv/Windows WindowsWechat/WMPF");
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Accept", "*/*");
            request.setHeader("Sec-Fetch-Site", "cross-site");
            request.setHeader("Sec-Fetch-Mode", "cors");
            request.setHeader("Sec-Fetch-Dest", "empty");
            request.setHeader("Referer", "https://servicewechat.com/wx141bfb9b73c970a9/23/index.html");
            request.setHeader("Accept-Language", "en-us,en");
            request.setHeader("Accept-Encoding", "gzip, deflate");

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                HttpEntity responseEntity = response.getEntity();
                if (responseEntity != null) {
                    result = EntityUtils.toString(responseEntity, "utf-8");
                    System.out.println("第" + i + "次\t\t" + response.getStatusLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}