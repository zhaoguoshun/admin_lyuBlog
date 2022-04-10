<template>
  <div id="centerData">
    <div class="sign" @click="getSign()">
      <img src="@/assets/logo_2.png" />
      <img src="@/assets/logo_1.png" />
      <div class="img3">
        <img src="@/assets/gkr1.png" />
      </div>
      <img src="@/assets/logo_3.png" />
      <img src="@/assets/下载.png" class="back" @click="$router.go(-1)" />
    </div>

    <div id="map"></div>
  </div>
</template>

<script>
import * as echarts from "echarts";
import mapData from "@/assets/tashan.json";

export default {
  name: "centerData",
  data() {
    return {};
  },
  mounted() {
    this.initMap(document.getElementById("map"));
  },
  methods: {
    initMap(e) {
      console.log(mapData);
      let myChart = echarts.init(e);
      let option;
      myChart.showLoading();
      myChart.hideLoading();
      echarts.registerMap("USA", mapData);
      option = {
        tooltip: {
          show: true,
          trigger: "item",
          showDelay: 0,
          transitionDuration: 0.2,
          textStyle: {},
          formatter: function() {
            // const value = (params.value + "").split(".");
            // const valueStr = value[0].replace(
            //   /(\d{1,3})(?=(?:\d{3})+(?!\d))/g,
            //   "$1,"
            // );
            return (
              "数量：" +
              "26家" +
              "</br>" +
              "产量：" +
              "1300吨" +
              "</br>" +
              "产值：" +
              "1.8亿元"
            );
          }
        },
        title: {
          text: "塔山瑶族乡",
          left: "center",
          top: 0,
          textStyle: {
            color: "#fff"
          }
        },
        series: [
          {
            name: "常宁市",
            type: "map",
            mapType: "china",
            roam: false,
            map: "USA",
            zoom: 1.2,
            label: {
              show: false
            },
            emphasis: {
              label: {
                show: true
              }
            },
            select: {
              itemStyle: {
                areaColor: "rgba(7, 18, 38,0.5)"
              },
              label: {
                color: "#01fcff"
              }
            },
            itemStyle: {
              normal: {
                areaColor: "#027ABE30",
                borderColor: "#0fffff",
                shadowColor: "#01fcff",
                borderWidth: 1
              },
              emphasis: {
                borderWidth: 2,
                borderColor: "#0fffff",
                areaColor: "#0179bd",
                label: {
                  show: true,
                  textStyle: {
                    color: "#01fcff"
                  }
                }
              }
            },
            data: mapData.features
          }
        ]
      };
      myChart.setOption(option);
      myChart.on("click", e => {
        console.log(e);
      });

      option && myChart.setOption(option);
    },
    getSign() {
      this.$router.push("/TeaEnterprise");
    }
  }
};
</script>

<style lang="scss" scoped>
#centerData {
  height: 100%;
  padding-top: 0.07rem;
  .sign {
    img:nth-child(1) {
      width: 50px;
      position: absolute;
      top: 280px;
      left: 219px;
      z-index: 999;
      cursor: pointer;
    }

    img:nth-child(2) {
      width: 50px;
      position: absolute;
      top: 380px;
      left: 250px;
      z-index: 999;
      cursor: pointer;
    }
    .img3 {
      img {
        width: 50px;
        position: absolute;
        top: 295px;
        left: 350px;
        z-index: 999;
        cursor: pointer;
        background: #fff;
      }
    }
    img:nth-child(4) {
      width: 50px;
      position: absolute;
      top: 350px;
      left: 500px;
      z-index: 999;
      cursor: pointer;
    }
    .back {
      width: 40px;
      position: absolute;
      top: 70px;
      left: 80px;
      z-index: 999;
      cursor: pointer;
    }
  }
  .top {
    //padding-left: 0.2rem;
    font-size: 0.12rem;
    display: flex;
    .top-one {
      margin-left: 0.1rem;
    }
    .top-item {
      padding-top: 0.03rem;
      flex: 1;
      margin-right: 0.1rem;
      position: relative;
      //border: 1px solid;
      // width: 1.0rem;
      height: 0.8rem;
      background-color: rgba(39, 229, 233, 0.1);

      .top-item-title {
        padding-left: 0.04rem;
        display: flex;
        padding-right: 0.04rem;

        .top-item-title-text {
          color: #01fcff;
          width: 75%;
        }

        .top-item-title-img-div {
          position: absolute;
          right: 4%;
          img {
            width: 0.2rem;
          }
        }
      }

      .top-item-value {
        padding-left: 0.04rem;
        padding-right: 0.04rem;
        padding-top: 15%;
      }

      .top-line {
        bottom: 0;
        position: absolute;
        display: flex;
        height: 0.05rem;
        width: 80%;
      }
    }
  }

  #map {
    height: 88%;
  }
}
</style>
