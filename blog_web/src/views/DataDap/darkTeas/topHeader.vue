<template>
  <div id="top-header">
    <div class="nav use-result">常宁市茶叶全产业链大数据指挥舱</div>
    <div class="nav_btn">
      <div class="btn_left">
        <!-- <div class="active  btn_list"></div> -->
        <!-- <div class="active  btn_list"></div> -->
        <div class="active  btn_list"></div>
        <div class="compeny">
          <img src="@/assets/logo/logo1.png" /><span>湖南万欧科技有限公司</span>
          <!-- <img src="@/assets/logo/logo.png" alt="" /> -->
        </div>
      </div>
      <div class="btn_right">
        <div class="active  btn_list"></div>
        <div class="active  btn_list"></div>
        <div class="active  btn_list"></div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "TopHeader",
  data() {
    return {};
  },
  mounted() {}
};
</script>

<style lang="scss" scoped>
#top-header {
  width: 100%;
  height: 70px;
  background: url(../../../assets/dpimg/top.png) 0 0 no-repeat;
  background-size: 100%;
  text-align: center;
  position: relative;
}

.use-result {
  position: relative;
  top: 8px;
  width: 100%;
  text-align: center;
  line-height: 1.5em;
  color: #0efcff;
  font-size: 24px;
}
.nav_btn {
  position: absolute;
  top: 1.5vw;
  width: 100%;
  height: 2vw;

  .btn_left {
    float: left;
    width: 25%;
    margin-left: 5%;
    height: 100%;
    display: flex;
    .compeny {
      position: absolute;
      text-align: center;
      display: flex;
      align-items: center;
      top: 0px;
      left: 86px;
      img {
        // opacity: 0.5;
        width: 20px;
      }
      span {
        color: #0efcff;
        font-size: 20px;
      }
    }
  }
  .btn_right {
    float: right;
    width: 25%;
    margin-right: 5%;
    height: 100%;
  }
}
.btn_list {
  position: relative;
  float: left;
  width: 30%;
  height: 90%;
  line-height: 1.2em;
  margin-right: 10px;
  flex: 1;
}
.active {
  border-color: #0efcff;
  box-shadow: inset 1px 1px 0.234vw 1px #0efcff;
  transform: skewX(-38deg);
}
</style>
