<template>
  <div id="centerData">
    <div class="top">
      <div class="top-item top-one">
        <div class="top-item-title">
          <div class="top-item-title-text">
            茶园种植面积(亩)
          </div>
          <div class="top-item-title-img-div">
            <img src="../../../assets/images/mian_ji_home.png" />
          </div>
        </div>
        <div class="top-item-value">89900</div>
        <div class="top-line" style="background-color: #f68002;"></div>
      </div>
      <!------------------------>
      <div class="top-item">
        <div class="top-item-title">
          <div class="top-item-title-text">
            产值(万元)
          </div>
          <div class="top-item-title-img-div">
            <img src="../../../assets/images/chan_zhi_home.png" />
          </div>
        </div>
        <div class="top-item-value">42300</div>
        <div class="top-line" style="background-color: #499bff"></div>
      </div>
      <!------------------------>
      <div class="top-item">
        <div class="top-item-title">
          <div class="top-item-title-text">
            产量(吨)
          </div>
          <div class="top-item-title-img-div">
            <img src="../../../assets/images/chan_laing_home.png" />
          </div>
        </div>
        <div class="top-item-value">3270</div>
        <div class="top-line" style="background-color: #f2ce44"></div>
      </div>
      <!------------------------>
      <div class="top-item">
        <div class="top-item-title">
          <div class="top-item-title-text">
            茶园(个)
          </div>
          <div class="top-item-title-img-div">
            <img src="../../../assets/images/cha_yuan_home.png" />
          </div>
        </div>
        <div class="top-item-value">3207</div>
        <div class="top-line" style="background-color: #41db8d"></div>
      </div>
      <!----------------------->
      <div class="top-item">
        <div class="top-item-title">
          <div class="top-item-title-text">
            茶企(个)
          </div>
          <div class="top-item-title-img-div">
            <img src="../../../assets/images/cha_qi_home.png" />
          </div>
        </div>
        <div class="top-item-value">32</div>
        <div class="top-line" style="background-color: #01fcff"></div>
      </div>
      <!------------------------->
      <div class="top-item">
        <div class="top-item-title">
          <div class="top-item-title-text">
            茶农(个)
          </div>
          <div class="top-item-title-img-div">
            <img src="../../../assets/images/cha_nong_home.png" />
          </div>
        </div>
        <div class="top-item-value">360000</div>
        <div class="top-line" style="background-color: #f41d00"></div>
      </div>
    </div>

    <div id="map"></div>
  </div>
</template>

<script>
import * as echarts from "echarts";
import mapData from "@/assets/map.json";

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
        series: [
          {
            name: "uu",
            type: "map",
            mapType: "china",
            roam: false, //控制缩放和拖拽
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
                areaColor: "#0179bd"
              },
              label: {
                color: "#01fcff"
              }
            },
            itemStyle: {
              // areaColor: '#027ABE30',
              normal: {
                areaColor: "#027ABE30",
                borderColor: "#0fffff",
                shadowColor: "#01fcff",
                borderWidth: 2
                // label: {
                //   show: true //显示名称
                // }
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
            /*markPoint: {
              silent: false,
              animation: true,
              symbolSize: [30, 40],
              symbol: 'image://' + require('@/assets/images/mark_chanong.png'),
              label: {
                show: true,
                position: 'bottom',
                distance: 3,
                color: '#fff',
                fontSize: 12,
                formatter: '{b}',
              },
              data: [
                {
                  coord: [112.465927,26.364845]
                }
              ]
            }*/
          }
        ]
      };
      myChart.setOption(option);
      myChart.on("click", e => {
        console.log(e.name);
        if (e.name == "塔山瑶族乡") {
          this.$router.push("/TeaCompany");
        }
      });
    }
  }
};
</script>

<style lang="scss" scoped>
#centerData {
  height: 100%;
  padding-top: 0.07rem;

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
