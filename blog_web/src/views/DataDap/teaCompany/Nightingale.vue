<template>
  <div id="mian" style="width:100%;height:95%"></div>
</template>

<script>
import * as echarts from "echarts";
export default {
  name: "Nightingale",
  data() {
    return {
      option: {
        tooltip: {
          trigger: "item",
          formatter: "{b} : {c} ({d}%)"
        },
        legend: {
          top: "bottom",
          data: []
        },
        series: [
          {
            name: "Nightingale Chart",
            type: "pie",
            radius: [20, 90],
            center: ["50%", "50%"],
            roseType: "area",
            label: {
              position: "inner",
              color: "#fff"
            },
            itemStyle: {
              // borderRadius: 8
            },
            data: [
              { value: 40, name: "黄金茶1号" },
              { value: 38, name: "槠叶齐" },
              { value: 32, name: "福鼎大白" },
              { value: 30, name: "碧香早" },
              { value: 28, name: "山岚茶" }
            ]
          }
        ]
      }
    };
  },
  mounted() {
    this.sale();
  },
  methods: {
    sale() {
      let myChart = echarts.init(document.getElementById("mian"));
      this.option && myChart.setOption(this.option);
    }
  }
};
</script>

<style></style>
