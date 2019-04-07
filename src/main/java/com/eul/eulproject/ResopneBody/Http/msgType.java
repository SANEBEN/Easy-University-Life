package com.eul.eulproject.ResopneBody.Http;

/**
 * 通过一个枚举类型来表示所有可能用到的消息类型，
 * 所有的信息均使用json格式发送，
 * 包含一个表示消息类型的type和消息本体body
 * 举例说明
 * {
 * "type":1,
 * "body":101
 * }
 * [type = 0] 用SHUT_DOWN表示，说明服务器即将关机
 * [type = 1] 用LOGIN表示，用于登录验证的消息，消息中包含了用户的ID
 * [type = 2] 用SUCCESS表示，用于说明服务器成功收到消息
 * [type = 3] 用FAIL表示，用于说明服务器接受消息失败
 * [type = 4] 用ERROR表示，用于说明发送的消息格式等不正确,并引发服务器错误
 * @author 三年二班的路小雨
 */

public enum msgType {
    SHUT_DOWN, LOGIN, SUCCESS, FAIL, ERROR
}
