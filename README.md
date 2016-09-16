## 目录说明
rpc-sample-api 服务接口声明           
rpc-sample-provider 服务实现           

rpc-sample-consumer-boot 服务消费——spring boot模式          
rpc-sample-consumer-web 服务消费——spring mvc模式           

## 部署方式
把服务接口和服务实现通过mvn deploy部署到ob repo中      
在ob.rpc添加引用，重启      
更新/etc/hosts,让genes.ob.com指向zk安装地址      
例如127.0.0.1 genes.ob.com      

## 测试
spring-boot运行rpc-sample-consumer-boot Bootstrap      
spring mvc运行rpc-sample-consumer-web      
