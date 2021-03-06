# dubbo-rpc-proxy

#### 介绍
dubbo 接口请求代理插件,暴露RPC接口,可通过HTTP访问

#### 安装教程

1.  Spring Boot 2.x+ 版本
2.  启动类添加@EnableDubboProxy开启代理

#### 使用说明
请求示例
```text
请求URL http://127.0.0.1:8088/dubbo-rpc/dubbo/1.0.0/com.10101111.carpay2v.api.bill.GetBillInfoApiService.getBill
请求方式 POST
{
    "hostName": "10.100.4.27:20880",
	"paramTypes": [
		"com.10101111.carpay2v.api.bill.pojo.GetBillInfoDTO"
	],
	"params": [{
		"orderId": 87371
	}]
}
```
参数说明
```text
http://{server}/dubbo-rpc/{group}/{version}/{methodName}
hostName 指定访问主机
paramTypes 请求参数类型列表
params 请求参数列表
```