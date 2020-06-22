# 简易聊天服务器端

## 模块划分

### 用户模块

用户模块主要负责登录和注册功能

## 用户信息模块

用户信息模块主要负责用户信息维护

## 好友模块

好友模块主要负责对好友信息进行管理

## 聊天模块

聊天模块主要负责对聊天记录进行维护，同时检测是否有新消息。

## API请求文档

### 用户模块

#### 登录

请求接口：

```java
@RequestMapping("user/login")
public MessageBean login(String phoneNumber,String password){
    return userService.login(phoneNumber, password);
}
```

返回值：

```json
{"code":1,"msg":"登录成功！","data":{"id":1006,"phoneNumber":"178515*****","password":"123456","registerDate":"2020-06-19T11:01:46.000+00:00","loginDate":"2020-06-22T00:42:34.000+00:00"}}
```

code 代表登录成功或者失败，msg为提示信息

```
用户不存在！
密码不能为空
登陆成功
更新账户状态失败，请重试
密码错误
```

#### 注册

请求接口：

```java
@PostMapping("user/register")
    public MessageBean register(String phoneNumber,String password,String name,String sex,String birth,String sign,String email){
        return userService.register(phoneNumber, password, name, sex, birth, sign, email);
    }
```

返回值：

```
{"code":1,"msg":"注册成功！","data":{"id":1006,"phoneNumber":"178515*****","password":"123456","registerDate":"2020-06-19T11:01:46.000+00:00","loginDate":"2020-06-22T00:42:34.000+00:00"}}
```

code 代表注册成功或者失败，msg为提示信息

```
注册成功
注册失败，添加用户表异常(用户已存在)
注册失败，日期非法
```

### 用户信息模块

#### 获取用户信息

```java
@RequestMapping("userInfo/getInfo")
public MessageBean getUserInfoByUid(String uid){
  return userInfoService.getUserInfoById(Integer.parseInt(uid));
}
```

返回信息

```json
{"code":1,"msg":"成功","data":{"id":1008,"name":"晚风","sex":"女","birth":"1998-03-01T16:00:00.000+00:00","sign":"接过生活中酸涩的柠檬，把它变成酸甜可口的柠檬汽水","email":"17851559308@qq.com"}}
```

#### 获取用户名称

```java
@RequestMapping("userInfo/getName")
public String getNameById(String uid){
 return userInfoService.getUserName(Integer.parseInt(uid));
}
```

返回信息

```
晚风
```

### 好友模块

#### 获取好友列表

```java
@RequestMapping("friend/getList")
public MessageBean getMyFriendList(String uid){
    try {
        int i = Integer.parseInt(uid);
        return friendService.getFriendList(i);
    }catch (Exception e){
        return new MessageBean(0,"解析失败",null);
    }

}
```

返回值

```json
{"code":1,"msg":"获取成功！","data":[{"id":1,"userId":1006,"friendId":1007,"friendName":"空竹","combineDate":"2020-06-19T11:07:26.000+00:00"},{"id":9,"userId":1006,"friendId":1008,"friendName":"晚风","combineDate":"2020-06-21T07:49:26.000+00:00"}]}
```

#### 添加好友

```java
@RequestMapping("friend/addFriend")
public MessageBean addFriend(String uid,String fid){
    try {
        return friendService.addFriends(Integer.parseInt(uid),Integer.parseInt(fid));
    }catch (Exception e){
        return new MessageBean(0,"解析失败"+e,null);
    }

}
```

返回值

```json
{"code":1,"msg":"成功！","data":{"code":1,"msg":"获取成功！","data":[{"id":6,"userId":1007,"friendId":1006,"friendName":"巴塞罗那的余晖","combineDate":"2020-06-19T11:50:26.000+00:00"},{"id":11,"userId":1007,"friendId":1008,"friendName":"晚风","combineDate":"2020-06-22T01:50:14.000+00:00"}]}}

该用户不存在
不得重复添加
成功
返回格式仍为MessageBean形式
```

### 聊天模块

#### 获取聊天记录

```java
@RequestMapping("chat/getList")
  public MessageBean getChatList(String uid,String fid){
    return chatListService.getChatListById(uid,fid);
}
```

返回值

```json
{"code":1,"msg":"获取成功！","data":[{"id":6,"content":"你好！","sendId":1007,"receiveId":1006,"date":"2020-06-21T13:45:10.000+00:00","status":0,"teamId":0}]}
```

#### 发送信息

```java
@RequestMapping("chat/sendMessage")
public MessageBean sendMessage(String content, int sendId, int receiveId){
    return chatListService.addChatList(content, sendId, receiveId);
}
```

返回值为发送的信息内容（方便客户端更新）

#### 检查是否有新信息

```java
@RequestMapping("chat/checkNewMessage")
public MessageBean checkForNewMessage(int uid){
    return chatListService.getNewMessage(uid);
}
```

返回值

```json
{"code":1,"msg":"收到新消息啦！","data":[{"id":3,"content":"你现在在干嘛啊","sendId":1008,"receiveId":1007,"date":"2020-06-21T08:11:38.000+00:00","status":1,"teamId":0}]}
```



