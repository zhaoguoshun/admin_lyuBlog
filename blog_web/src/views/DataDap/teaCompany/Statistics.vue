<template>
  <div id="Statistics" style="width:100%;height:95%">
    <!-- 历年销量及销售额统计 -->
  </div>
</template>

<script>
import * as echarts from "echarts";
export default {
  name: "Statistics",
  data() {
    return {
      option: {
        legend: {
          textStyle: {
            color: "#fff",
            fontSize: "10px"
          },
          top: 10,
          right: 5
        },
        grid: {
          x: "12%", //x 偏移量
          y: "8%", // y 偏移量
          top: 60,
          right: 30,
          width: "75%", // 宽度
          height: "50%" // 高度
        },
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "cross",
            crossStyle: {
              color: "#999"
            }
          }
        },
        dataset: {
          dimensions: ["product", "销量万吨", "销量亿元"],
          source: [
            { product: "2016", 销量万吨: 2.1, 销量亿元: 4.4 },
            { product: "2017", 销量万吨: 2.5, 销量亿元: 5.9 },
            { product: "2018", 销量万吨: 3.4, 销量亿元: 7.7 },
            { product: "2019", 销量万吨: 4, 销量亿元: 8.8 },
            { product: "2020", 销量万吨: 5.1, 销量亿元: 10.6 }
          ]
        },
        xAxis: {
          type: "category",
          axisLabel: {
            show: true,
            textStyle: {
              color: "#fff", //更改坐标轴文字颜色
              fontSize: "10px" //更改坐标轴文字大小
            }
          }
        },
        yAxis: [
          {
            type: "value",
            name: "销售(万吨)",
            nameTextStyle: {
              color: "#fff",
              fontSize: "10"
            },
            min: 0,
            max: 12,
            axisLabel: {
              show: true,
              textStyle: {
                color: "#fff", //更改坐标轴文字颜色
                fontSize: "10px" //更改坐标轴文字大小
              }
            }
          },
          {
            type: "value",
            name: "销售额(万亿)",
            nameTextStyle: {
              color: "#fff",
              fontSize: "10"
            },
            min: 0,
            max: 12,
            axisLabel: {
              show: true,
              textStyle: {
                color: "#fff", //更改坐标轴文字颜色
                fontSize: "10px" //更改坐标轴文字大小
              }
            }
          }
        ],
        series: [
          { type: "bar", color: "rgb(8,130,137)" },
          { type: "bar", color: "rgb(14,254,255)" }
        ]
      }
    };
  },
  mounted() {
    this.Statistics();
  },
  methods: {
    Statistics() {
      let myChart = echarts.init(document.getElementById("Statistics"));
      this.option && myChart.setOption(this.option);
    }
  }
};
</script>

<style lang="scss" scoped></style>
