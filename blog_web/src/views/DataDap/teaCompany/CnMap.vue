<template>
  <div id="centerData">
    <div id="map"></div>
  </div>
</template>

<script>
import * as echarts from "echarts";
import mapData from "@/assets/map.json";
export default {
  name: "centerData",
  data() {
    return {
      sliderList: []
    };
  },
  mounted() {
    this.initMap(document.getElementById("map"));
    // console.log(this.sliderList);
  },
  methods: {
    getMsg(msg) {
      let _that = this;
      for (let i = 0; i < msg.length; i++) {
        let item = [];
        item.push(msg[i][0]);
        item.push(msg[i][1]);
        item.push(msg[i][2]);
        item.push(msg[i][3]);
        _that.sliderList.push(item);
      }
    },
    initMap(e) {
      // console.log(mapData);
      let myChart = echarts.init(e);
      let option;
      myChart.showLoading();
      myChart.hideLoading();
      echarts.registerMap("China", mapData);
      option = {
        tooltip: {
          trigger: "item",
          showDelay: 0,
          transitionDuration: 0.2,
          // formatter: function(params) {
          //   return params;
          // }
          formatter: function() {
            return;
          }
        },
        title: {
          text: "常宁市行政管辖区",
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
            mapType: "China",
            roam: false,
            map: "China",
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
          }
        ]
      };
      myChart.setOption(option);
      myChart.on("click", e => {
        console.log(e.name);
        if (e.name == "塔山瑶族乡") {
          this.$router.push("/teafirm");
        }
      });
      let sliderlist = this.sliderList;
      setTimeout(() => {
        myChart.on("mouseOver", function(params) {
          for (let i = 0; i < sliderlist.length; i++) {
            if (params.name == sliderlist[i][0]) {
              myChart.setOption({
                series: {
                  type: "map",
                  label: {
                    formatter: "{b}: {@[i]} ({d}%) {sss}"
                  }
                }
              });
              myChart.dispatchAction({
                type: "highlight",
                seriesIndex: 0,
                name: params.name
              });
            }
          }
          setTimeout(function() {
            myChart.dispatchAction({
              type: "highlight",
              seriesIndex: 4,
              dataIndex: params.seriesIndex
            });
          }, 300);
        });
        myChart.on("mouseOut", function(params) {
          for (var i = 0; i < sliderlist.length; i++) {
            // data11[i].value="0";
            if (params.name == sliderlist[i][0]) {
              myChart.dispatchAction({ type: "downplay", name: params.name });
            }
          }
        });
      }, 0);
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
