## 使用说明

- 使用 java 程序测试是否能获取到用户真实 IP
    - 包含 docker 环境
    - 包含 kubernetes Ingress 环境

1. docker 环境

   ```shell
   docker run \
     --restart=always \
     -itd \
     --privileged=true \
     --name java-0.0.1-SNAPSHOT \
     -p 63456:8080 \
     registry.jihulab.com/xuxiaowei-com-cn/java:0.0.1-SNAPSHOT
   ```
    
   测试示例
    
    ```shell
    C:\Users\xuxiaowei>curl http://172.25.25.221:63456
    {"remoteHost":"172.25.25.4","headerNames":{"host":["172.25.25.221:63456"],"user-agent":["curl/8.0.1"],"accept":["*/*"]},"remotePort":53580,"remoteAddr":"172.25.25.4"}
    C:\Users\xuxiaowei>
    C:\Users\xuxiaowei>ipconfig
    
    Windows IP 配置
    
    
    以太网适配器 以太网:
    
       连接特定的 DNS 后缀 . . . . . . . :
       IPv4 地址 . . . . . . . . . . . . : 172.25.25.4
       子网掩码  . . . . . . . . . . . . : 255.255.255.0
       默认网关. . . . . . . . . . . . . : fe80::1%3
                                           172.25.25.1
    
    C:\Users\xuxiaowei>
    ```

2. kubernetes（k8s）环境

    ```shell
    kubectl apply -f https://jihulab.com/xuxiaowei-com-cn/java/-/raw/main/deploy.yaml
    kubectl apply -f https://jihulab.com/xuxiaowei-com-cn/java/-/raw/main/ingress.yaml
    ```

    ```shell
    [root@k8s-control-plane-1 ~]# kubectl get ingress java-resp-localhost
    NAME                  CLASS   HOSTS                   ADDRESS   PORTS   AGE
    java-resp-localhost   nginx   java.resp.localdev.me             80      8h
    [root@k8s-control-plane-1 ~]#
    ```

    ```shell
    C:\Users\xuxiaowei>curl --resolve java.resp.localdev.me:80:172.25.25.220 http://java.resp.localdev.me
    {"remoteHost":"172.25.25.4","headerNames":{"x-request-id":["a48ab4e34d281f77ab805eece24f3be2"],"x-real-ip":["172.25.25.4"],"x-forwarded-scheme":["http"],"x-forwarded-host":["java.resp.localdev.me"],"x-forwarded-proto":["http"],"host":["java.resp.localdev.me"],"x-forwarded-port":["80"],"x-scheme":["http"],"user-agent":["curl/8.0.1"],"accept":["*/*"]}}
    C:\Users\xuxiaowei>
    C:\Users\xuxiaowei>ipconfig
    
    Windows IP 配置
    
    
    以太网适配器 以太网:
    
       连接特定的 DNS 后缀 . . . . . . . :
       IPv4 地址 . . . . . . . . . . . . : 172.25.25.4
       子网掩码  . . . . . . . . . . . . : 255.255.255.0
       默认网关. . . . . . . . . . . . . : fe80::1%3
                                           172.25.25.1
    
    C:\Users\xuxiaowei>
    ```