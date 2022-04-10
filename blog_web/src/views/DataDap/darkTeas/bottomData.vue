<template>
  <div id="bottom-data">
    <router-link to="/" class="showTime" tag="div">{{ date }} </router-link>
    <span class="tmp" v-if="weather"
      >{{ weather.wea_day }}&nbsp;&nbsp;{{ weather.tem2 }}℃~{{
        weather.tem1
      }}℃&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(PM2.5:{{ weather.air_pm25 }})</span
    >
  </div>
</template>

<script>
import { getWeather } from "@/api/weather";
export default {
  name: "botttomData",
  data() {
    return {
      date: new Date(),
      weather: {
        wea: "阴",
        wea_day: "",
        tem2: "18",
        tem1: "27"
      }
    };
  },
  mounted() {
    let _this = this;
    let newDate = new Date();
    this.date = newDate.toLocaleString();
    _this.timer = setInterval(() => {
      let newDate = new Date();
      this.date = newDate.toLocaleString();
    }, 1000);
    getWeather().then(res => {
      // if ((res.errcode = 100)) {
      //   return;
      // }
      this.weather.wea = res.wea;
      this.weather.wea_day = res.wea_day;
      this.weather = res;
    });
    //
  },
  methods: {
    dateFormat(fmt, date) {
      //author: meizz
      let o = {
        "M+": date.getMonth() + 1, //月份
        "d+": date.getDate(), //日
        "h+": date.getHours(), //小时
        "m+": date.getMinutes(), //分
        "s+": date.getSeconds(), //秒
        "q+": Math.floor((date.getMonth() + 3) / 3), //季度
        S: date.getMilliseconds() //毫秒
      };
      if (/(y+)/.test(fmt))
        fmt = fmt.replace(
          RegExp.$1,
          (date.getFullYear() + "").substr(4 - RegExp.$1.length)
        );
      for (let k in o)
        if (new RegExp("(" + k + ")").test(fmt))
          fmt = fmt.replace(
            RegExp.$1,
            RegExp.$1.length == 1
              ? o[k]
              : ("00" + o[k]).substr(("" + o[k]).length)
          );
      return fmt;
    },
    handleDate(date) {
      return this.dateFormat("yyyy年MM月");
    }
  },
  watch: {
    option: function(newValue, oldValue) {
      console.log(4444);
      console.log(newValue);
    }
  }
};
</script>

<style lang="scss" scoped>
#bottom-data {
  width: 100%;
  height: 50px;
  background: url(../../../assets/dpimg/footer.png) 0 0 no-repeat;
  background-size: 100%;
  text-align: center;
  position: relative;
}
.showTime {
  position: absolute;
  top: 35%;
  left: 45%;
  font-size: 15px;
  cursor: pointer;
}
.tmp {
  position: absolute;
  top: 35%;
  left: 65%;
  font-size: 15px;
  cursor: pointer;
}
</style>
