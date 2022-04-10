import request from "@/utils/request";

// 获取路由
export const getWeather = () => {
    return request({
        url: "https://v0.yiketianqi.com/api?unescape=1&version=v62&appid=51279661&appsecret=Z8uRlEwI&cityid=101250406",
        method: "get"
    });
};