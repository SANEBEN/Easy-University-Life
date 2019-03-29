# EUL项目文档

## 项目介绍

> 这个项目是我们的一个大创项目,该项目的主要作用是实现在校大学生在学校中的交流APP,考虑到市面上的软件大都不把学生作为自己APP的唯一使用人群,在APP中多了许多无用的功能,我们希望实现一款软件针对学生的主要需求作为主要出发点,开发一款适用于在校大学生的校园生活软件.

## 项目基本配置信息

> http服务端口号 8088

> websocket服务端口号： 9999

## 项目接口说明

* <a href = "#login">1. 登录功能实现</a>
* <a href = "#getUserMessage">2. 获取用户的完整个人信息</a>
* <a >3. 获取课程信息接口</a>
  * <a href = "#getCourseByID">3.1 通过课程ID获取课程的完整信息</a>
  * <a href = "#getCourseByUid">3.2 通过学生的ID获取所选课程的完整信息</a>
* <a href = "#getFriendsByUid">4.根据用户的ID来获取好友的详细信息</a>
* <a href = "#getChatRecord">获取用户的聊天记录</a>

### 登录功能实现

<h2 id = "login">- login 接口</h2>

>访问路径：/login

>需要的参数示例

```Java
@Param(value = "userName") String userName //用户名
@Param(value = "password") String password //密码
```

> 返回格式说明

1. 登录成功

```Json
{
    "status": 1, //状态码为1表示登录成功
    "body": { //body中包含了该用户的个人信息，选课信息，简单的朋友信息
        "messageSimple": {
            "ID": 12,
            "IDNumber": "201711000619",
            "realName": "沈慧贤",
            "role": 1
        },
        "courseSimpleList": [
            {
                "ID": 3,
                "name": "课堂3",
                "Tid": 39,
                "teacher": "胡宇阳"
            },
            {
                "ID": 1,
                "name": "课堂1",
                "Tid": 19,
                "teacher": "吴胜洋"
            },
            {
                "ID": 8,
                "name": "课堂8",
                "Tid": 80,
                "teacher": "刘烜君"
            }
        ],
        "friendSimpleList": [
            {
                "ID": 22,
                "name": "杨云凯"
            },
            {
                "ID": 32,
                "name": "陈安达"
            },
            {
                "ID": 3,
                "name": "胡旭"
            }
        ]
    }
}
```

2. 登录失败

```Json
{
    "status": 0,
    "body": "登录密码错误"
}

{
    "status": 0,
    "body": "用户不存在"
}
```

### 获取用户信息接口

<h2 id = "getUserMessage">- 获取完整的个人信息</h2>

> 访问路径： /getUserMessage

> 参数信息

```Java
@Param(value = "Uid") String Uid
```

> 返回格式说明

```Json
{
    "realName": "沈慧贤",
    "school": {
        "name": "华北电力大学（保定）",
        "description": "",
        "id": "1"
    },
    "major": {
        "name": "英语",
        "description": null,
        "id": "5"
    },
    "gender": 1,
    "email": "201711000619@eul.com",
    "createdTime": "2017-09-10T04:00:00.000+0000",
    "role": 1,
    "id": 12,
    "sid": "1",
    "mid": "5",
    "idnumber": "201711000619"
}
```

### 获取课程信息接口

<h2 id = "getCourseByID">-通过课程ID获取课程的完整信息</h2>

> 访问路径：/getCourseByID

> 参数说明

```Java 
@Param(value = "ID") String ID
```

> 返回值示例

```Json
{
    "name": "课堂3",
    "teacher": {
        "realName": "胡宇阳",
        "school": {
            "name": "华北电力大学（保定）",
            "description": "",
            "id": "1"
        },
        "major": {
            "name": "法政",
            "description": null,
            "id": "4"
        },
        "gender": 1,
        "email": "201711000710@eul.com",
        "createdTime": "2017-09-10T04:00:00.000+0000",
        "role": 0,
        "id": 39,
        "idnumber": "201711000710",
        "mid": "4",
        "sid": "1"
    },
    "begin": 6,
    "end": 16,
    "place": "教x103",
    "volume": 70,
    "credit": 3,
    "time_begin": 5,
    "time_end": 6,
    "type": 1,
    "id": 3,
    "tid": 39
}
```

<h2 id = "getCourseByUid">-通过学生的ID获取该学生所选课程的完整信息</h2>

> 访问路径：/getCourseListByUid

> 参数说明

```Java 
@Param(value = "Uid") String Uid
```

> 返回值示例

 ```Json
 [
    {
        "name": "课堂3",
        "teacher": {
            "realName": "胡宇阳",
            "school": {
                "name": "华北电力大学（保定）",
                "description": "",
                "id": "1"
            },
            "major": {
                "name": "法政",
                "description": null,
                "id": "4"
            },
            "gender": 1,
            "email": "201711000710@eul.com",
            "createdTime": "2017-09-10T04:00:00.000+0000",
            "role": 0,
            "id": 39,
            "idnumber": "201711000710",
            "mid": "4",
            "sid": "1"
        },
        "begin": 6, //课堂开始的周次
        "end": 16, //课堂结束的周次
        "place": "教x103", //课堂所在的教师
        "volume": 70, //课堂容量
        "credit": 3, //课程学分
        "time_begin": 5, //课堂开始的时间，按照节次来划分
        "time_end": 6, // 课堂结束的时间
        "type": 1, //课堂的类型，1为必修课 2为选修课
        "id": 3, //课堂的ID
        "tid": 39 //课堂老师的ID
    },
    {
        "name": "课堂1",
        "teacher": {
            "realName": "吴胜洋",
            "school": {
                "name": "华北电力大学（保定）",
                "description": "",
                "id": "1"
            },
            "major": {
                "name": "英语",
                "description": null,
                "id": "5"
            },
            "gender": 1,
            "email": "201711000626@eul.com",
            "createdTime": "2017-09-10T04:00:00.000+0000",
            "role": 0,
            "id": 19,
            "idnumber": "201711000626",
            "mid": "5",
            "sid": "1"
        },
        "begin": 1,
        "end": 12,
        "place": "教x101",
        "volume": 80,
        "credit": 1,
        "time_begin": 1,
        "time_end": 2,
        "type": 1,
        "id": 1,
        "tid": 19
    },
    {
        "name": "课堂8",
        "teacher": {
            "realName": "刘烜君",
            "school": {
                "name": "华北电力大学（保定）",
                "description": "",
                "id": "1"
            },
            "major": {
                "name": "计算机",
                "description": null,
                "id": "2"
            },
            "gender": 1,
            "email": "201711000816@eul.com",
            "createdTime": "2017-09-10T04:00:00.000+0000",
            "role": 0,
            "id": 80,
            "idnumber": "201711000816",
            "mid": "2",
            "sid": "1"
        },
        "begin": 1,
        "end": 8,
        "place": "教x201",
        "volume": 80,
        "credit": 4,
        "time_begin": 1,
        "time_end": 4,
        "type": 0,
        "id": 8,
        "tid": 80
    }
]
 ```

### 获取用户的好友信息

<h2 id = "getFriendsByUid">-根据用户的ID来获取好友的详细信息</h3>

> 访问路径：/getFriendsByUid

> 参数说明

```Java
@Param(value = "Uid") String Uid
```

>返回值示例

```Json
[
    {
        "friend": {
            "realName": "杨云凯",
            "school": {
                "name": "华北电力大学（保定）",
                "description": "",
                "id": "1"
            },
            "major": {
                "name": "法政",
                "description": null,
                "id": "4"
            },
            "gender": 0,
            "email": "201711000629@eul.com",
            "createdTime": "2017-09-10T04:00:00.000+0000",
            "role": 1,
            "id": 22,
            "idnumber": "201711000629",
            "mid": "4",
            "sid": "1"
        },
        "id": 22
    },
    {
        "friend": {
            "realName": "陈安达",
            "school": {
                "name": "华北电力大学（保定）",
                "description": "",
                "id": "1"
            },
            "major": {
                "name": "法政",
                "description": null,
                "id": "4"
            },
            "gender": 1,
            "email": "201711000703@eul.com",
            "createdTime": "2017-09-10T04:00:00.000+0000",
            "role": 1,
            "id": 32,
            "idnumber": "201711000703",
            "mid": "4",
            "sid": "1"
        },
        "id": 32
    },
    {
        "friend": {
            "realName": "胡旭",
            "school": {
                "name": "华北电力大学（保定）",
                "description": "",
                "id": "1"
            },
            "major": {
                "name": "英语",
                "description": null,
                "id": "5"
            },
            "gender": 1,
            "email": "201711000608@eul.com",
            "createdTime": "2017-09-10T04:00:00.000+0000",
            "role": 1,
            "id": 3,
            "idnumber": "201711000608",
            "mid": "5",
            "sid": "1"
        },
        "id": 3
    }
]
```

### 获取聊天记录

<h2 id = "getChatRecord">根据用户的ID来获取用户的聊天记录</h2>

> 访问路径： /getRecordByUid

> 参数说明：

```Java
@Param(value = "Uid") String Uid
```

> 返回值示例

```Json
[
    {
        "time": "2019-03-29T01:11:36.000+0000",
        "content": "测试消息",
        "id": 1,
        "from_id": 12,//发送消息的人的ID
        "to_id": 2 //收到消息的人的ID
    },
    {
        "time": "2019-03-29T01:11:44.000+0000",
        "content": "测试消息",
        "id": 2,
        "from_id": 12,
        "to_id": 2
    }
]
```
