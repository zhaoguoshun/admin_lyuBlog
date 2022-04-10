<template>
  <div id="visitorNum"></div>
</template>

<script>
import * as echarts from "echarts";
export default {
  data() {
    return {};
  },
  created() {},
  mounted() {
    setTimeout(() => {
      this.getDraw();
    }, 300);
  },

  methods: {
    getDraw() {
      let myChart = echarts.init(document.getElementById("visitorNum"));
      let option = {
        title: {
          text: "访客年龄分布",
          // subtext: "虚构数据",
          textStyle: {
            color: "#fff",
            fontSize: ".14rem"
          },
          top: 5,
          left: 5
        },
        grid: {
          // x: "12%", //x 偏移量
          // y: "7%", // y 偏移量
          top: 35,
          // right: 10,
          // width: "95%", // 宽度
          height: "60%" // 高度
        },
        tooltip: {
          trigger: "axis",
          textStyle: {
            fontSize: ".1rem"
          }
        },
        legend: {
          data: ["男", "女"],
          textStyle: {
            color: "#fff",
            fontSize: "0.1rem"
          },
          top: 5,
          right: 5
        },
        calculable: true,
        xAxis: {
          type: "category",
          data: ["20岁以下", "20-30岁", "31-40岁", "41-50岁", "50岁以上"],
          axisLabel: {
            show: true,
            textStyle: {
              color: "#fff", //更改坐标轴文字颜色
              fontSize: ".12rem" //更改坐标轴文字大小
            }
          },
          axisLine: {
            //x轴线的颜色以及宽度
            show: true,
            lineStyle: {
              color: "#fff",
              width: 0,
              type: "solid"
            }
          },
          axisTick: {
            show: false
          }
        },
        yAxis: {
          type: "value",
          axisLabel: {
            show: false
            // textStyle: {
            //   color: "#fff", //更改坐标轴文字颜色
            //   fontSize: ".1rem" //更改坐标轴文字大小
            // }
          },
          splitLine: {
            show: false
          },
          axisLine: {
            show: false
          },
          axisTick: {
            show: false
          }
        },
        series: [
          {
            name: "男",
            type: "bar",
            data: [2, 25, 4, 1, 2],
            itemStyle: {
              normal: {
                label: {
                  show: true,
                  position: "top",
                  textStyle: {
                    color: "#fff",
                    fontSize: ".1rem"
                  }
                },
                barBorderRadius: [15, 15, 0, 0]
              }
            },
            barWidth: "18%"
          },
          {
            name: "女",
            type: "bar",
            barGap: "200%",
            data: [6, 14, 1, 2, 1],
            itemStyle: {
              normal: {
                label: {
                  show: true,
                  position: "top",
                  textStyle: {
                    color: "#fff",
                    fontSize: ".1rem"
                  }
                },
                barBorderRadius: [15, 15, 0, 0]
              }
            },
            barWidth: "18%"
          }
        ],
        color: ["#23E2F8", "#EB92FE"]
      };
      myChart.setOption(option);
    }
  }
};
</script>

<style lang="scss" scoped>
#visitorNum {
  width: 100%;
  height: 100%;
  flex: 1;
  // height: 50%;
  box-sizing: border-box;
}
</style>
