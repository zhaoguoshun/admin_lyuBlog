<template>
  <div id="sale" style="width:100%;height:95%">
    <!-- 2019年马路镇茶叶销量品类分布 -->
  </div>
</template>

<script>
import * as echarts from "echarts";
export default {
  name: "sale",
  data() {
    return {
      option: {
        tooltip: {
          trigger: "item"
        },
        radar: {
          shape: "circle",
          radius: "65",
          indicator: [
            { text: "黄金茶1号", max: 40, color: "#0efcff" },
            { text: "槠叶齐", max: 40, color: "#0efcff" },
            { text: "福鼎大白", max: 40, color: "#0efcff" },
            { text: "碧香早", max: 40, color: "#0efcff" },
            { text: "山岚茶", max: 40, color: "#0efcff" }
          ]
        },
        series: (function() {
          let series = [];
          series.push({
            type: "radar",
            name: "销量品牌分布",
            center: ["50%", "50%"],
            symbol: "none",
            lineStyle: {
              width: 2,
              color: "#0efcff"
            },
            areaStyle: {
              color: "#0efbff60"
            },
            emphasis: {
              areaStyle: {
                color: "rgba(0,250,0,0.5)"
              }
            },
            data: [
              {
                value: [35, 35, 40, 38, 29]
              }
            ]
          });
          return series;
        })()
      }
    };
  },
  mounted() {
    this.sale();
  },
  methods: {
    sale() {
      let myChart = echarts.init(document.getElementById("sale"));
      this.option && myChart.setOption(this.option);
    }
  }
};
</script>

<style lang="scss" scoped></style>
