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
            <cn-map class="cnmap" ref="child" />
            <div class="image">
              <img src="@/assets/企业.png" alt="" />
              <img src="@/assets/定位.png" alt="" />
              <img src="@/assets/定位.png" alt="" />
              <img src="@/assets/企业.png" alt="" />
            </div>
          </div>
          <div class="right-right">
            <div class="right-top">
              <div class="right-top-list">
                <div class="title">茶企(32)家</div>
                <div class="swiper">
                  <slider :sliderData="sliderData"></slider>
                </div>
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
import cnMap from "./teaCompany/CnMap";
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
    cnMap,
    slider,
    Statistics,
    YearOnYear,
    sale,
    Nightingale
  },
  data() {
    return {
      sliderData: []
    };
  },
  mounted() {
    setTimeout(() => {
      this.sliderData = [
        ["江河乡", "2", "1.06万吨", "2.21亿"],
        ["柏坊镇", "2", "0.88万吨", "1.84亿"],
        ["水口山街道", "2", "1.03万吨", "2.16亿"],
        ["松柏镇", "1", "0.60万吨", "1.26亿"],
        ["烟洲镇", "1", "1.82万吨", "3.80亿"],
        ["蓬塘乡", "2", "0.41万吨", "0.86亿"],
        ["宜潭乡", "2", "1.44万吨", "3.02亿"],
        ["新河镇", "3", "0.44万吨", "0.93亿"],
        ["大堡乡", "2", "1.03万吨", "2.16亿"],
        ["官岭镇", "1", "0.60万吨", "1.26亿"],
        ["兰江乡", "1", "1.82万吨", "3.80亿"],
        ["培元街道", "1", "1.82万吨", "3.80亿"],
        ["宜阳街道", "1", "1.82万吨", "3.80亿"],
        ["泉峰街道", "1", "1.82万吨", "3.80亿"],
        ["盐湖镇", "1", "1.82万吨", "3.80亿"],
        ["荫田镇", "1", "1.82万吨", "3.80亿"],
        ["西岭镇", "1", "1.82万吨", "3.80亿"],
        ["三角塘镇", "1", "1.82万吨", "3.80亿"],
        ["板桥镇", "1", "1.82万吨", "3.80亿"],
        ["胜桥镇", "1", "1.82万吨", "3.80亿"],
        ["洋泉镇", "1", "1.82万吨", "3.80亿"],
        ["罗桥镇", "1", "1.82万吨", "3.80亿"],
        ["白沙镇", "1", "1.82万吨", "3.80亿"],
        ["庙前镇", "1", "1.82万吨", "3.80亿"],
        ["弥泉乡", "1", "1.82万吨", "3.80亿"],
        ["塔山瑶族乡", "1", "1.82万吨", "3.80亿"],
        ["天堂山办事处", "1", "1.82万吨", "3.80亿"]
      ];
      this.sendMsg();
    }, 60);
  },
  created() {},
  methods: {
    sendMsg() {
      this.$refs.child.getMsg(this.sliderData);
    }
  }
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
    .cnmap {
      margin-top: 50px;
    }
    .image {
      img {
        cursor: pointer;
        z-index: -1;
      }
      img:nth-child(1) {
        width: 35px;
        position: absolute;
        top: 590px;
        left: 230px;
      }
      img:nth-child(2) {
        width: 35px;
        position: absolute;
        top: 450px;
        left: 200px;
      }
      img:nth-child(3) {
        width: 35px;
        position: absolute;
        top: 430px;
        left: 280px;
      }
      img:nth-child(4) {
        width: 35px;
        position: absolute;
        top: 510px;
        left: 260px;
      }
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

.numList {
  width: 100%;
  height: 80%;
  // background: #fff;
  margin-top: 90px;
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
