<template>
  <div id="brokenLine"></div>
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
      let myChart = echarts.init(document.getElementById("brokenLine"));
      let option = {
        // color: ["#80FFA5", "#00DDFF", "#37A2FF", "#FF0087", "#FFBF00"],
        title: {
          text: "员工/访客/陌生人识别记录统计",
          textStyle: {
            color: "#fff",
            fontSize: ".14rem"
          },
          top: 5,
          left: 5
        },
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "cross",
            label: {
              backgroundColor: "#6a7985"
            }
          }
        },
        legend: {
          data: ["员工", "访客", "陌生人"],
          textStyle: {
            color: "#fff",
            fontSize: ".12rem"
          },
          bottom: 0
        },
        grid: {
          // y:"15%",
          left: "3%",
          right: "5%",
          bottom: "10%",
          containLabel: true
        },
        calculable: true,
        xAxis: {
          type: "category",
          boundaryGap: false,
          data: [
            "2021/8/1",
            "2021/8/2",
            "2021/8/3",
            "2021/8/4",
            "2021/8/5",
            "2021/8/6",
            "2021/8/7"
          ],
          axisLabel: {
            show: true,
            textStyle: {
              color: "#fff", //更改坐标轴文字颜色
              fontSize: ".11rem" //更改坐标轴文字大小
            }
          }
        },
        yAxis: {
          type: "value",
          axisLabel: {
            show: true,
            textStyle: {
              color: "#fff", //更改坐标轴文字颜色
              fontSize: ".11rem" //更改坐标轴文字大小
            }
          },
          splitLine: {
            show: false
          },
          axisLine: {
            show: true
          },
          axisTick: {
            show: true
          }
        },
        series: [
          {
            name: "员工",
            data: [20, 19, 18, 20, 19, 18, 20],
            type: "line",
            smooth: true,
            emphasis: {
              focus: "series"
            }
          },
          {
            name: "访客",
            data: [8, 7, 7, 4, 19, 13, 20],
            type: "line",
            smooth: true,
            emphasis: {
              focus: "series"
            }
          },
          {
            name: "陌生人",
            data: [20, 12, 10, 8, 11, 12, 10],
            type: "line",
            smooth: true,
            emphasis: {
              focus: "series"
            }
          }
        ]
      };
      myChart.setOption(option);
    }
  }
};
</script>

<style lang="scss" scoped>
#brokenLine {
  // width: 50%;
  flex: 2;
  height: 100%;
}
</style>
