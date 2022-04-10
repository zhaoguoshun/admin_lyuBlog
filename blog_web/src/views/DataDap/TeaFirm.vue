<template>
  <div id="tea-company">
    <dv-full-screen-container>
      <top-header class="topheader" />
      <div class="content">
        <div class="content-left">
          <tabmuen />
        </div>
        <div class="content-right">
          <div class="right-left">
            <ta-mount class="tamount" />
          </div>
          <div class="right-right">
            <div class="right-top">
              <div class="right-top-list">
                <div class="title">茶企(32)家</div>
                <div class="swiper"><slider></slider></div>
              </div>
              <div class="right-top-list">
                <div class="title">历年销量及销售额统计</div>
                <Statistics></Statistics>
              </div>
            </div>
            <div class="right-middle">
              <div class="title">
                2020年常宁市重点企业累计销量及销售额同比情况
              </div>
              <YearOnYear></YearOnYear>
            </div>
            <div class="right-bottom">
              <div class="right-bottom-list">
                <div class="title">
                  2020年常宁市茶叶销量品类分布
                </div>
                <sale></sale>
              </div>
              <div class="right-bottom-list">
                <div class="title">
                  2020年全市茶叶销售额品类分布
                </div>
                <Nightingale></Nightingale>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="bottom">
        <bottom-data />
      </div>
    </dv-full-screen-container>
  </div>
</template>

<script>
import topHeader from "./darkTeas/topHeader";
import bottomData from "./darkTeas/bottomData";
import Tabmuen from "./teaCompany/Tabmuen";
import taMount from "./teaCompany/TaMount";
import slider from "./teaCompany/slider";
import Statistics from "./teaCompany/Statistics";
import YearOnYear from "./teaCompany/YearOnYear";
import sale from "./teaCompany/sale";
import Nightingale from "./teaCompany/Nightingale";
export default {
  name: "TeaCompany",
  components: {
    topHeader,
    bottomData,
    Tabmuen,
    taMount,
    slider,
    Statistics,
    YearOnYear,
    sale,
    Nightingale
  },
  data() {
    return {};
  },
  mounted() {},
  created() {},
  methods: {}
};
</script>

<style lang="scss" scoped>
* {
  margin: 0;
  padding: 0;
}
#tea-company {
  width: 100%;
  height: 100%;
  color: #fff;
}
#dv-full-screen-container {
  background: url(../../assets/darkTea.jpg) no-repeat top center;
  background-size: 100% 100%;
  display: flex;
  flex-direction: column;
}
.topheader {
  height: 8%;
}
.content {
  display: flex;
  height: 87%;
}
.bottom {
  width: 100%;
  height: 5%;
}
.content-left {
  width: 20%;
  display: flex;
}
.content-right {
  width: 80%;
  display: flex;
  .right-left {
    width: 60%;
    position: relative;
    .tamount {
      margin-top: 100px;
    }
  }
  .right-right {
    width: 40%;
    height: 100%;
    display: flex;
    flex-direction: column;
    .right-top {
      height: 33.333%;
      display: flex;
      .right-top-list {
        width: 50%;
        background: url(../../assets/images/border_03.png) no-repeat;
        background-size: 100% 100%;
      }
    }
    .right-middle {
      height: 33.333%;
      background: url(../../assets/images/border_02.png) no-repeat;
      background-size: 100% 100%;
    }
    .right-bottom {
      height: 33.333%;
      display: flex;
      .right-bottom-list {
        width: 50%;
        background: url(../../assets/images/border_03.png) no-repeat;
        background-size: 100% 100%;
      }
    }
  }
}

.title {
  width: 100%;
  text-align: center;
  margin-top: 18px;
  font-size: 12px;
  color: #0efcff;
}
.swiper {
  margin-top: 5px;
  width: 100%;
  height: 88%;
}
</style>
