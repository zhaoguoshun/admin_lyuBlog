<template>
  <div id="top-header">
    <dv-border-box-12>
    <el-row>
      <el-col :span="8"><div class="left">智能电房运行情况</div></el-col>
      <el-col :span="8"><div class="content">
        <span>智能电房@云上电能</span>
        </div></el-col>
      <el-col :span="8"><div class="right">设电服务运行情况</div></el-col>
    </el-row>
    <router-link to="/" class="showTime" tag="div">{{ date }} </router-link>
    </dv-border-box-12>
  </div> 
</template>

<script>
export default {
  name: "TopHeader",
  data() {
    return {
      date: new Date(),
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
#top-header {
  position: relative;
  width: 100%;
  height: 100px;
  display: flex;
  justify-content: space-between;
  flex-shrink: 0;
  color: rgb(205, 207, 204);
}
.showTime {
    position: absolute;
    top: 10px !important;
    left: 34px;
    font-size: 13px;
    cursor: pointer;
  }
  .el-col {
    height: 100px;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .left {
    position: absolute;
    margin-top: 30px;
    font-size: 24px ;
  }
  .right {
    position: absolute;
    margin-top: 30px;
    font-size: 24px;
  }
  .content>span {
    font-size: 30px;
  }
</style>
