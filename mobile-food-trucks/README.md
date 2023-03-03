一.项目简介
该项目实现了一个移动餐车查询的接口，功能较为简单，主要查询applicant为Natan's Catering且状态为APPROVED的移动餐车。
二.部署
1.前提条件
安装docker、openjdk8
2.部署流程
  1).通过git clone拉取代码到本地
  2).执行mvn clean install -DskipTests打包代码
  3).将jar文件、docker文件上传到服务器同一目录下
  4).执行命令 sudo docker build . -t mobile-food-trucks:v1.0 打包镜像，并通过docker images命令查看生成的镜像
  5).通过命令 sudo docker run -d -p 8080:8080 --name mobile-food-trucks mobile-food-trucks:v1.0 运行镜像
  6).在浏览器输入http://ip:8080/foodtruck/query执行查询
三.扩展
由于时间所限，本项目仅实现了一个查询移动餐车的较为简单的接口，后续可以根据业务需要实现更为复杂的功能。主要可以从以下几个方面进行扩展：
  1).引入SpringCloud相关组件，添加服务的注册，接口的熔断、限流、降级等功能
  2).对用户操作数据记录日志，基于日志分析偏好，添加营销等功能


