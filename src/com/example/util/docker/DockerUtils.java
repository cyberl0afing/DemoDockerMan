package com.example.util.docker;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.domain.Container;
import com.google.code.juds.UnixDomainSocket;
import com.google.code.juds.UnixDomainSocketClient;

import java.io.*;

public class DockerUtils {

    public static UnixDomainSocketClient getSocket(){
        String socketFile="/var/run/docker.sock";
        UnixDomainSocketClient socket=null;
        try {
             socket=new UnixDomainSocketClient(socketFile, UnixDomainSocket.SOCK_STREAM);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return socket;
    }
    public static String createContainer(String ImageName){
        String target_json="{\"Image\":\""+ImageName+"\"}";
        UnixDomainSocketClient socket=getSocket();
        InputStream in =socket.getInputStream();
        OutputStream out =socket.getOutputStream();
        PrintWriter w=new PrintWriter(out);
        w.println("POST /containers/create HTTP/1.1");
        w.println("Host: localhost");
        w.println("Accept: */*");
        w.println("Content-Type: application/json");
        w.println("Content-Length: "+target_json.length());
        w.println("");
        w.println(target_json);
        w.flush();

        System.out.println("------ Docker Response-------------");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String res=null;
        int row_number=1;
        try{
            while ((res=br.readLine())!=null){
                if(row_number>=10){
                    break;
                }
                row_number++;
            }
            br.close();
            JSONObject obj=JSON.parseObject(res);
            res=obj.getString("Id");//ysx15738374231
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        socket.close();
        return res;
    }//create a new Container use the specified Image
     //return ContainerID

    public static String createContainer(Container container){
        return null;
    }//OverLoad the method
    // create a new container by Container Obj
    // and return ContainerID
    public static String deleteContainer(Container container){
        return null;
    }
}
