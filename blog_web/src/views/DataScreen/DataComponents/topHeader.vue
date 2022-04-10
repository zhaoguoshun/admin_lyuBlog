<template>
  <div id="top-header">
    <dv-decoration-8 class="header-left-decoration" />
    <dv-decoration-5 class="header-center-decoration" />
    <dv-decoration-8 class="header-right-decoration" :reverse="true" />
    <div class="center-title">国顺博客系统</div>
    <router-link to="/" class="showTime" tag="div">{{ date }} </router-link>
    <!--<el-button
      style="position:absolute;top: 34px;right: 34px;"
      type="primary"
      @click="openFullScreen('cheerMusic')"
      v-loading.fullscreen.lock="fullscreenLoading"
    >
      警报
    </el-button>-->
    <audio
      id="cheerMusic"
      ref="music"
      preload="auto"
      src="../../../assets/audio/262.wav"
    />
  </div>
</template>

<script>
export default {
  name: "TopHeader",
  data() {
    return {
      date: new Date(),
      fullscreenLoading: false,
      csr: 0.7,
      isDisba: true,
      loading: [],
      option: {
        lock: true,
        text: "红码警告",
        spinner: "el-icon-warning",
        background: "rgba(255, 0, 0, 0.7)",
        customClass: "zhezhao"
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
  },
  beforeDestroy() {
    if (this.timer) {
      clearInterval(this.timer);
    }
  },
  methods: {
    openFullScreen(id) {
      this.handlePlay(id);
      let _that = this;
      let time = setInterval(() => {
        this.isDisba = !this.isDisba;
        if (this.isDisba) {
          _that.loading = _that.$loading(_that.option);
          let split = _that.option.background.toString().split(',');
          _that.loading.background = split[0] + "," + split[1] + "," + split[2] + "," + '0.7)';
        } else {
          _that.loading = _that.$loading(_that.option);
          let split = _that.option.background.toString().split(',');
          _that.loading.background = split[0] + "," + split[1] + "," + split[2] + "," + '0.5)';
        }
      }, 500);

      setTimeout(() => {
        this.csr = 0;
        clearInterval(time);
        this.loading.close();
      }, 5000);
    },
    handlePlay(id) {
      document.getElementById(id).play();
    },
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

<style lang="scss">
#top-header {
  position: relative;
  width: 100%;
  height: 100px;
  display: flex;
  justify-content: space-between;
  flex-shrink: 0;

  .header-center-decoration {
    width: 40%;
    height: 60px;
    margin-top: 30px;
  }

  .header-left-decoration,
  .header-right-decoration {
    width: 25%;
    height: 60px;
  }

  .center-title {
    position: absolute;
    font-size: 30px;
    font-weight: bold;
    left: 50%;
    top: 15px;
    transform: translateX(-50%);
  }
  .showTime {
    position: absolute;
    top: 34px;
    left: 34px;
    font-size: 13px;
    cursor: pointer;
  }
}
.zhezhao {
  font-size: 2rem;
  color: white;

  .el-loading-spinner .el-loading-text {
    color: white;
    font-size: 0.6rem;
    position: absolute;
    left: 50%;
    top: 1.2rem;
    transform: translate(-50%, -50%);
  }
  .el-loading-spinner i {
    color: yellow;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
  }
}
</style>
