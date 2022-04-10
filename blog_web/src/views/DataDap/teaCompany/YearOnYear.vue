<template>
  <div id="YearOnYear" style="width:100%;height:95%">
    <!-- 19年马路镇重点企业累计销量及销售额同比情况 -->
  </div>
</template>

<script>
import * as echarts from "echarts";
export default {
  name: "YearOnYear",
  data() {
    return {
      option: {
        legend: {
          data: ["累计销量同步销量", "累计销量额同比"],
          textStyle: {
            color: "#fff",
            fontSize: "10px"
          },
          top: 10
        },
        grid: {
          // x: "12%", //x 偏移量
          // y: "8%", // y 偏移量
          top: 60,
          right: 30,
          width: "85%", // 宽度
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
        xAxis: {
          type: "category",
          data: [
            "九龙茶业",
            "大宋茶业",
            "瑶园茶业",
            "谷佳茶业",
            "天堂云雾茶业"
          ],
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
            name: "百分比",
            nameTextStyle: {
              color: "#fff",
              fontSize: "10"
            },
            min: 0,
            max: 20,
            interval: 5,
            axisLabel: {
              show: true,
              textStyle: {
                color: "#fff", //更改坐标轴文字颜色
                fontSize: "10px" //更改坐标轴文字大小
              },
              formatter: "{value} %"
            }
          }
        ],

        series: [
          {
            name: "累计销量同步销量",
            type: "bar",
            color: "rgb(14,254,255)",
            data: [12.2, 8.9, 14.5, 12.3, 6.3],
            barWidth: "18%"
          },
          {
            name: "累计销量额同比",
            type: "bar",
            color: "rgb(255,103,38)",
            data: [13.2, 10.9, 15.5, 15.3, 13.6],
            barWidth: "18%"
          }
        ]
      }
    };
  },
  mounted() {
    this.YearOnYear();
  },
  methods: {
    YearOnYear() {
      let myChart = echarts.init(document.getElementById("YearOnYear"));
      this.option && myChart.setOption(this.option);
    }
  }
};
</script>

<style lang="scss" scoped></style>
