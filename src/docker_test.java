import com.google.code.juds.UnixDomainSocket;
import com.google.code.juds.UnixDomainSocketClient;

import java.io.*;
import java.util.Scanner;

//Note: Unnecessary use of -X or --request, POST is already inferred.
//        *   Trying /var/run/docker.sock:0...
//        * Connected to localhost (/run/docker.sock) port 80 (#0)
//        > POST /containers/create HTTP/1.1
//        > Host: localhost
//        > User-Agent: curl/7.70.0
//        > Accept: */*
//> Content-Type: application/json
//> Content-Length: 18
//>
//* upload completely sent off: 18 out of 18 bytes
//* Mark bundle as not supporting multiuse
//< HTTP/1.1 201 Created
//< Api-Version: 1.40
//< Content-Type: application/json
//< Docker-Experimental: false
//< Ostype: linux
//< Server: Docker/19.03.8-ce (linux)
//< Date: Sun, 10 May 2020 21:53:52 GMT
//< Content-Length: 88
//<
//{"Id":"012218a5edb18e98986b2d5b8e0bbdb604b3dd9c833034525a71cee24df7afad","Warnings":[]}

//POST /v1/register/pc/officialAccount/checkLogin HTTP/1.1
//        Host: passport.csdn.net
//        User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:76.0) Gecko/20100101 Firefox/76.0
//        Accept: application/json, text/plain, */*
//Accept-Language: en-US,en;q=0.5
//Accept-Encoding: gzip, deflate, br
//Referer: https://passport.csdn.net/login?code=public
//X-Requested-With: XMLHttpRequest
//X-Tingyun-Id: im-pGljNfnc;r=147841388
//Origin: https://passport.csdn.net
//Connection: keep-alive
//Cookie: uuid_tt_dd=10_37470885270-1588681986180-871605; dc_session_id=10_1588681986180.610258; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1589147506,1589147540,1589147541,1589147833; Hm_ct_6bcd52f51e9b3dce32bec4a3997715ac=6525*1*10_37470885270-1588681986180-871605; __gads=ID=f023328446713f7d:T=1588681994:S=ALNI_Mbj1P55D5DANSyi7vOepcTBNtvNCA; dc_tos=qa4ybj; Hm_up_6bcd52f51e9b3dce32bec4a3997715ac=%7B%22islogin%22%3A%7B%22value%22%3A%220%22%2C%22scope%22%3A1%7D%2C%22isonline%22%3A%7B%22value%22%3A%220%22%2C%22scope%22%3A1%7D%2C%22isvip%22%3A%7B%22value%22%3A%220%22%2C%22scope%22%3A1%7D%7D; dc_sid=d42f3ec6a543ad1fcb23a58128ddcf0b; c_first_ref=www.baidu.com; c_first_page=https%3A//blog.csdn.net/lcalqf/article/details/79449414; c_ref=https%3A//blog.csdn.net/lcalqf/article/details/79449414; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1589147839; announcement=%257B%2522isLogin%2522%253Afalse%252C%2522announcementUrl%2522%253A%2522https%253A%252F%252Fblog.csdn.net%252Fblogdevteam%252Farticle%252Fdetails%252F105203745%2522%252C%2522announcementCount%2522%253A0%252C%2522announcementExpire%2522%253A3600000%257D; utm_source=ffzl_BWzd; c_utm_source=ffzl_BWzd; c-login-auto=1; SESSION=a4d1fcff-3ad3-4886-b1d7-fca55bf78d4d; TY_SESSION_ID=fd5175c4-75be-47bc-bb70-4b924efa9a27
//Content-Length: 0
public class docker_test {
    public static void main(String[] args) throws IOException {
        String unixFile="/var/run/docker.sock";
        UnixDomainSocketClient socket=new UnixDomainSocketClient(unixFile, UnixDomainSocket.SOCK_STREAM);
        InputStream in =socket.getInputStream();
        OutputStream out =socket.getOutputStream();
        PrintWriter w=new PrintWriter(out);
        w.println("POST /containers/create HTTP/1.1");
        w.println("Host: localhost");
        w.println("Accept: */*");
        w.println("Content-Type: application/json");
        w.println("Content-Length: "+"{\"Image\":\"ubuntu\"}".length());
        w.println("");
        w.println("{\"Image\":\"ubuntu\"}");
        w.flush();
        System.out.println("{\"Image\":\"ubuntu\"}".length());

        System.out.println("------ Docker Response-------------");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line=br.readLine())!=null){
            System.out.println(line);
        }
        out.close();
        in.close();
        socket.close();
    }

}
